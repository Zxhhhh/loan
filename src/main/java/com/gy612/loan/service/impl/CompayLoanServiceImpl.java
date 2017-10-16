package com.gy612.loan.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gy612.loan.dao.CompanyLoanInfoMapper;
import com.gy612.loan.dao.CompanyLoanMaterialMapper;
import com.gy612.loan.dto.LoanInfoAndMaterial;
import com.gy612.loan.dto.LoanResult;
import com.gy612.loan.dto.UserIntegration;
import com.gy612.loan.entity.CompanyLoanInfo;
import com.gy612.loan.entity.CompanyLoanInfoExample;
import com.gy612.loan.entity.PersonalLoanInfo;
import com.gy612.loan.entity.PersonalLoanInfoExample;
import com.gy612.loan.entity.PersonalLoanMaterial;
import com.gy612.loan.entity.CompanyLoanInfoExample.Criteria;
import com.gy612.loan.entity.CompanyLoanMaterial;
import com.gy612.loan.service.CompanyLoanService;
import com.gy612.loan.utils.AccountValidatorUtils;
import com.gy612.loan.utils.NumUtils;

@Service("companyLoanService")
public class CompayLoanServiceImpl implements CompanyLoanService {
	
	
	public static final   double YEARRATE = 0.144;
	
	@Autowired
	private CompanyLoanInfoMapper companyLoanInfoMapper;
	
	@Autowired
	private CompanyLoanMaterialMapper companyLoanMaterialMapper;

	@Override
	public List<CompanyLoanInfo> getCompanyLoanInfoList(Integer pageNum,
			String userId) {
		
		CompanyLoanInfoExample example = new CompanyLoanInfoExample();
		Criteria cri = example.createCriteria();
		cri.andUserIdEqualTo(userId);
		
		List<CompanyLoanInfo> result = companyLoanInfoMapper.selectByExample(example);
		
		return result;
	}

	@Override
	public LoanInfoAndMaterial<CompanyLoanInfo, CompanyLoanMaterial> getCompanyLoanDetail(
			String companyLoanId) {
		
		LoanInfoAndMaterial<CompanyLoanInfo,CompanyLoanMaterial> result = new LoanInfoAndMaterial<>();
		
		CompanyLoanInfo info = companyLoanInfoMapper.selectByPrimaryKey(companyLoanId);
		if(info!=null){
			result.setInfo(info);
			CompanyLoanMaterial material = companyLoanMaterialMapper.selectByPrimaryKey(info.getMaterialId());
			if(material!=null){
				result.setMaterial(material);
			}
		}
		
		return result;
	}

	@Override
	public LoanResult<CompanyLoanInfo> checkCompanyLoanInfo(
			CompanyLoanInfo companyLoanInfo, UserIntegration userIntegration) {
		
		LoanResult<CompanyLoanInfo> result = null;
		if(companyLoanInfo!=null){
			String contactPhone =  companyLoanInfo.getLoanContactPhone();
			if(contactPhone!=null&&AccountValidatorUtils.isMobile(contactPhone)){
				String contactName = companyLoanInfo.getLoanContactName();
				String loanName = companyLoanInfo.getLoanName();
				if(contactName!=null&&AccountValidatorUtils.isChinese(contactName)){
					Double loanMoney = companyLoanInfo.getLoanMoney();
					Double returnMoney = companyLoanInfo.getLoanReturnMoney();
					if(loanMoney>0&&returnMoney>0){
						String id = NumUtils.createId();
						String userId = userIntegration.getUser().getId();
						companyLoanInfo.setId(id);
						companyLoanInfo.setUserId(userId);
						companyLoanInfo.setLoanState((byte)0);
						companyLoanInfo.setIsRepay((byte)2);
						companyLoanInfo.setLoanDeadline(null);
						System.out.println("企业资料:"+companyLoanInfo);
						result = new LoanResult<CompanyLoanInfo>(true,companyLoanInfo);
						
					}else{
						result = new LoanResult<CompanyLoanInfo>(false,"贷款与还款金额必须为正数");
					}
				}else{
					result = new LoanResult<CompanyLoanInfo>(false,"贷款人姓名不能为非中文字符");
				}
			}else{
				result = new LoanResult<CompanyLoanInfo>(false,"手机格式错误");
			}
		}else{
			result = new LoanResult<CompanyLoanInfo>(false,"提交数据为空");
		}
		
		return result;
	}

	@Override
	public LoanResult<CompanyLoanInfo> addCompanyLoan(
			MultipartFile materialAptitude, MultipartFile materialMortgage,
			String path, CompanyLoanInfo companyLoanInfo,
			UserIntegration userIntegration) {
		
		LoanResult<CompanyLoanInfo> result = null;
		
		String username = userIntegration.getUser().getUsername();
		String dateStr = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); 
		//1.保存上传的资料
		String relativePath = "repository/companyLoanMaterial/"+username+"/"+dateStr;
		String savePath = path+relativePath;
		File dir = new File(savePath);
		if(!dir.exists()){
			dir.mkdirs();
		}
		LoanResult<String> materialAptitudeResult  = PersonalLoanServiceImpl.uploadFile(savePath,username+"MaterialAptitude",materialAptitude,relativePath);
		LoanResult<String> materialMortgageResult  = PersonalLoanServiceImpl.uploadFile(savePath,username+"MaterialMortgage",materialMortgage,relativePath);
		if(materialAptitudeResult.isSuccess&&materialMortgageResult.isSuccess){
			//2.获取路径保存资料到数据库
			String materialAptitude_path = materialAptitudeResult.getData();
			String materialMortgage_path = materialMortgageResult.getData();
			String id  =  NumUtils.createId();
			CompanyLoanMaterial companyLoanMaterial = new CompanyLoanMaterial(id,materialAptitude_path,materialMortgage_path);
			Integer materialCount = companyLoanMaterialMapper.insert(companyLoanMaterial);
			if(materialCount!=0){
				companyLoanInfo.setMaterialId(id);
				Integer infoCount = companyLoanInfoMapper.insert(companyLoanInfo);
				if(infoCount!=0){
					result = new LoanResult<CompanyLoanInfo>(true,companyLoanInfo);
				}
			}
		}
		
		return result;
	}

	@Override
	@Transactional
	public LoanResult<String> deleteCompanyLoan(String companyLoanInfoId) {
		
		LoanResult<String> result  =  null;
		
		CompanyLoanInfo companyLoanInfo = companyLoanInfoMapper.selectByPrimaryKey(companyLoanInfoId);
		if(companyLoanInfo!=null){
			Byte state = companyLoanInfo.getLoanState();
			if(state==0){
				int deleteCount = companyLoanInfoMapper.deleteByLeftJoin(companyLoanInfoId);
				if(deleteCount!=0){
					result = new LoanResult<String>(true,"撤回企业贷款成功","");
				}else{
					
				}
			}else{
				result = new LoanResult<String>(false,"","只有未被审核的贷款申请才能撤回");
			}
		}else{
			result = new LoanResult<String>(false,"","企业贷款信息不存在，请勿篡改页面信息");
		}
		
		return result;
	}

	@Override
	public LoanResult<String> repayCompanyLoan(String companyLoanInfoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyLoanInfo> getCompanyLoanInfoByIsRepay(byte isRepay) {
		
		CompanyLoanInfoExample example = new CompanyLoanInfoExample();
		Criteria cri = example.createCriteria();
		cri.andIsRepayEqualTo(isRepay);
		
		List<CompanyLoanInfo> result = companyLoanInfoMapper.selectByExample(example);
		
		return result;
		
	}

}
