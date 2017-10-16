package com.gy612.loan.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.gy612.loan.dao.PersonalLoanInfoMapper;
import com.gy612.loan.dao.PersonalLoanMaterialMapper;
import com.gy612.loan.dto.LoanInfoAndMaterial;
import com.gy612.loan.dto.LoanResult;
import com.gy612.loan.dto.UserIntegration;
import com.gy612.loan.entity.PersonalLoanInfo;
import com.gy612.loan.entity.PersonalLoanInfoExample;
import com.gy612.loan.entity.PersonalLoanInfoExample.Criteria;
import com.gy612.loan.entity.PersonalLoanMaterial;
import com.gy612.loan.entity.Remind;
import com.gy612.loan.service.PersonalLoanService;
import com.gy612.loan.service.RemindService;
import com.gy612.loan.utils.AccountValidatorUtils;
import com.gy612.loan.utils.AverageCapitalUtils;
import com.gy612.loan.utils.NumUtils;

@Service("personalLoanService")
public class PersonalLoanServiceImpl implements PersonalLoanService {

	
	public static final Integer LIST_SIZE = 8;
	
	public static final   double YEARRATE = 0.144; // 年利率
	
	@Autowired
	private PersonalLoanInfoMapper personalLoanInfoMapper;
	
	@Autowired
	private PersonalLoanMaterialMapper personalLoanMaterialMapper;
	
	@Autowired
	private RemindService remindService;
	
	@Override
	public List<PersonalLoanInfo> getAllPersonalLoanInfo() {
		return personalLoanInfoMapper.selectByExample(new PersonalLoanInfoExample());
	}
	
	@Override
	public List<PersonalLoanInfo> getPersonalLoanInfoList(Integer pageNum,
			String userId) {
		
		
		PersonalLoanInfoExample example = new PersonalLoanInfoExample();
		Criteria cri = example.createCriteria();
		cri.andUserIdEqualTo(userId);
		
		List<PersonalLoanInfo> result = personalLoanInfoMapper.selectByExample(example);
		
		return result;
	}

	@Override
	public LoanInfoAndMaterial<PersonalLoanInfo, PersonalLoanMaterial> getPersonalLoanDetail(
			String personalLoanId) {
		
		LoanInfoAndMaterial<PersonalLoanInfo,PersonalLoanMaterial> result = new LoanInfoAndMaterial<>();
		
		PersonalLoanInfo info = personalLoanInfoMapper.selectByPrimaryKey(personalLoanId);
		if(info!=null){
			result.setInfo(info);
			PersonalLoanMaterial material = personalLoanMaterialMapper.selectByPrimaryKey(info.getMeterialId());
			if(material!=null){
				result.setMaterial(material);
			}
		}
		
		return result;
	}

	@Override
	public LoanResult<PersonalLoanInfo> checkPersonalLoanInfo(
			PersonalLoanInfo personalLoanInfo,UserIntegration userIntegration) {
		
		LoanResult<PersonalLoanInfo> result = null;
		if(personalLoanInfo!=null){
			String userPhone  = personalLoanInfo.getLoanPhone();
			System.out.println("手机:"+userPhone);
			if(userPhone!=null&&AccountValidatorUtils.isMobile(userPhone)){
				String userName = personalLoanInfo.getLoanName();
				System.out.println("贷款人姓名:"+userName);
				if(userName!=null&&AccountValidatorUtils.isChinese(userName)){
					Double loanMoney = personalLoanInfo.getLoanMoney();
					Double returnMoney = personalLoanInfo.getLoanReturnMoney();
					if(loanMoney>0&&returnMoney>0){
						//数据验证都OK
						String id = NumUtils.createId();
						String userId = userIntegration.getUser().getId();
						personalLoanInfo.setId(id);
						personalLoanInfo.setUserId(userId);
						personalLoanInfo.setLoanState((byte)0);
						personalLoanInfo.setIsRepay((byte)2);
						personalLoanInfo.setLoanDeadline(null);
						System.out.println("个人贷款资料:"+personalLoanInfo);
						result = new LoanResult<PersonalLoanInfo>(true,personalLoanInfo);
					}else{
						result = new LoanResult<PersonalLoanInfo>(false,"贷款与还款金额必须为正数");
					}
				}else{
					result = new LoanResult<PersonalLoanInfo>(false,"贷款人姓名不能为非中文字符");
				}
			}else{
				result = new LoanResult<PersonalLoanInfo>(false,"手机格式错误");
			}
		}else{
			result = new LoanResult<PersonalLoanInfo>(false,"提交数据为空");
		}
		
		return result;
	}

	@Override
	@Transactional 
	public LoanResult<PersonalLoanInfo> addPersonalLoan(
			MultipartFile materialPersonal, MultipartFile materialMortgage,
			String path,PersonalLoanInfo personalLoanInfo,UserIntegration userIntegration) {
			
			LoanResult<PersonalLoanInfo> result = null;
		
			String username = userIntegration.getUser().getUsername();
			String dateStr = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); 
			//1.保存上传的资料
			String relativePath = "repository/personalLoanMaterial/"+username+"/"+dateStr;
			String savePath = path+relativePath;
			File dir = new File(savePath);
			if(!dir.exists()){
				dir.mkdirs();
			}
			LoanResult<String> materialPersonalResult  = uploadFile(savePath,username+"MaterialPersonal",materialPersonal,relativePath);
			LoanResult<String> materialMortgageResult  = uploadFile(savePath,username+"MaterialMortgage",materialMortgage,relativePath);
			if(materialPersonalResult.isSuccess&&materialMortgageResult.isSuccess){
				//2.获取路径保存资料到数据库
				String materialPersonal_path = materialPersonalResult.getData();
				String materialMortgage_path = materialMortgageResult.getData();
				String id  =  NumUtils.createId();
				PersonalLoanMaterial personalLoanMaterial = new PersonalLoanMaterial(id,materialPersonal_path,materialMortgage_path);
				Integer materialCount = personalLoanMaterialMapper.insert(personalLoanMaterial);
				if(materialCount!=0){
					//3.保存个人贷款信息
					personalLoanInfo.setMeterialId(id);
					Integer infoCount = personalLoanInfoMapper.insert(personalLoanInfo);
					if(infoCount!=0){
						//发送消
						Remind remind = new Remind((byte)1,(byte)0,personalLoanInfo.getUserId(),"贷款反馈:您的一笔"+personalLoanInfo.getLoanMoney()+"个人已成功申请，请等待管理员审核");
						remindService.addRemindAndPush(remind);
						result = new LoanResult<PersonalLoanInfo>(true,personalLoanInfo);
					}else{
						result = new LoanResult<PersonalLoanInfo>(false,"内部错误:信息保存失败");
					}
				}else{
					result =  new LoanResult<PersonalLoanInfo>(false,"内部错误:资料保存失败");
				}
			}else{
				result = new LoanResult<PersonalLoanInfo>(false,"内部错误:文件上传失败");
			}
		
		return result;
	}
	
	public static LoanResult<String> uploadFile(String dir,String fileName,MultipartFile file,String relativePath){
		LoanResult<String> result = null;
		String originalName = file.getOriginalFilename();
		String postfix = originalName.substring(originalName.lastIndexOf("."),originalName.length());
		System.out.println("文件名:"+fileName+postfix);
		File tarFile = new File(dir,fileName+postfix);
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(),tarFile);//上传目标文件
			System.out.println("文件上传成功！！");
			String fileRelativePath = relativePath+"/"+tarFile.getName();
			result = new LoanResult<String>(true,fileRelativePath,"");
		} catch (Exception e) {
			e.printStackTrace();
			result = new LoanResult<String>(false,"","文件上传失败");
		}
		return result;
	}

	@Override
	@Transactional
	public LoanResult<String> deletePersonLoan(String personalLoanInfoId) {
		LoanResult<String> result  =  null;
		PersonalLoanInfo personalLoanInfo = personalLoanInfoMapper.selectByPrimaryKey(personalLoanInfoId);
		try{
			if(personalLoanInfo!=null){
				Byte state = personalLoanInfo.getLoanState();
				if(state==0){
					String materialId = personalLoanInfo.getMeterialId();
					Integer deleteInfoCount = personalLoanInfoMapper.deleteByPrimaryKey(personalLoanInfoId);
					if(deleteInfoCount!=0){
						Integer deleteMaterialCount = personalLoanMaterialMapper.deleteByPrimaryKey(materialId);
						if(deleteInfoCount!=0){
							//发消息推送
							Remind remind = new Remind((byte)1,(byte)0,personalLoanInfo.getUserId(),"贷款反馈:您的一笔"+personalLoanInfo.getLoanMoney()+"个人贷款申请已成功撤回");
							remindService.addRemindAndPush(remind);
							
							result = new LoanResult<String>(true,"成功撤回个人贷款申请","");
						}else{
							result = new LoanResult<String>(false,"","贷款资料删除失败");
						}
					}else{
						result = new LoanResult<String>(false,"","贷款信息删除失败");
					}
				}else{
					result = new LoanResult<String>(false,"","只有未被审核的贷款申请才能撤回");
				}
			}else {
				result = new LoanResult<String>(false,"","个人贷款信息不存在，请勿篡改页面信息");
			}
		}catch (Exception e) {
			e.printStackTrace();
			result = new LoanResult<String>(false,"","内部错误：请稍后重试");
		}
		return result;
	}

	@Override
	@Transactional
	public LoanResult<String> repayPersonalLoan(String personalLoanInfoId) {
		
		LoanResult<String> result  =  null;
		PersonalLoanInfo personalLoanInfo = personalLoanInfoMapper.selectByPrimaryKey(personalLoanInfoId);
		if(personalLoanInfo!=null){
			Byte loanState = personalLoanInfo.getIsRepay();
			if(loanState==0){
				personalLoanInfo.setIsRepay((byte)1);
				personalLoanInfo.setLoanRepayDate(new Date());
				Integer count = personalLoanInfoMapper.updateByPrimaryKey(personalLoanInfo);
				if(count!=0){
					//发消息推送
					Remind remind = new Remind((byte)1,(byte)0,personalLoanInfo.getUserId(),"贷款反馈:您的一笔"+personalLoanInfo.getLoanMoney()+"个人贷款已成功还款");
					remindService.addRemindAndPush(remind);
					
					result = new LoanResult<String>(true,"还款成功! <a href='index/toIndex'>返回首页</a>","");
				}else{
					result = new LoanResult<String>(false,"","数据库内部错误：还款失败");
				}
			}else{
				if(loanState==3){
					result = new LoanResult<String>(false,"","还款期限已过，请联系管理员咨询超时还款事宜");
				}else{
					result = new LoanResult<String>(false,"","贷款尚未发放或已经还款");
				}
			}
		}else{
			result = new LoanResult<String>(false,"","个人贷款信息不存在，请勿篡改页面信息");
		}
		return result;
	}

	@Override
	public List<PersonalLoanInfo> getPersonalLoanInfoByIsRepay(byte isRepay) {
		
		PersonalLoanInfoExample example = new PersonalLoanInfoExample();
		Criteria cri = example.createCriteria();
		cri.andIsRepayEqualTo(isRepay);
		
		List<PersonalLoanInfo> result = personalLoanInfoMapper.selectByExample(example);
		
		return result;
	}

	@Override
	@Transactional
	public LoanResult<String> takemoneyPersonalLoan(String personalLoanInfoId) {
		
		LoanResult<String> result  =  null;
		PersonalLoanInfo personalLoanInfo = personalLoanInfoMapper.selectByPrimaryKey(personalLoanInfoId);
		try{
			if(personalLoanInfo!=null){
				System.out.println("月:"+personalLoanInfo.getLoanMonth());
				Long monthDate = personalLoanInfo.getLoanMonth().longValue()*24*30*1000*3600;//借款的毫秒
				System.out.println("月数化为毫秒:"+monthDate);
				Date deadLine = new Date(new Date().getTime()+monthDate);//截止的日期
				System.out.println(deadLine);
				String deadLineStr = new SimpleDateFormat("yyyy-MM-dd").format(deadLine);
				personalLoanInfo.setIsRepay((byte)0);//把还款状态从未领款->未还款
				personalLoanInfo.setLoanDeadline(deadLine);
				Integer updateCount = personalLoanInfoMapper.updateByPrimaryKey(personalLoanInfo);
				if(updateCount!=0){
					//发消息推送
					Remind remind = new Remind((byte)1,(byte)0,personalLoanInfo.getUserId(),"贷款反馈:您的一笔"+personalLoanInfo.getLoanMoney()+"个人贷款已成功领款");
					remindService.addRemindAndPush(remind);
					
					String content = "领款成功,请于"+personalLoanInfo.getLoanMonth()+"个月的<strong>"+deadLineStr+"</strong>前还款";
					result = new LoanResult<String>(true,content,"");
				}else{
					result = new LoanResult<String>(false,"","数据库异常");
				}
				
			}else{
				result = new LoanResult<String>(false,"","个人贷款信息不存在，请勿篡改页面信息");
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(); //hui gun
		}
		
		return result;
	}

}
