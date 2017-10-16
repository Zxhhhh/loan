package com.gy612.loan.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gy612.loan.dto.LoanPerMonthReturnDetail;
import com.gy612.loan.dto.LoanResult;
import com.gy612.loan.dto.LoanReturnDetail;
import com.gy612.loan.dto.RegisterUserResult;
import com.gy612.loan.dto.UserIntegration;
import com.gy612.loan.entity.CompanyLoanInfo;
import com.gy612.loan.entity.PersonalLoanInfo;
import com.gy612.loan.entity.UserInfo;
import com.gy612.loan.service.CompanyLoanService;
import com.gy612.loan.service.PersonalLoanService;
import com.gy612.loan.utils.AverageCapitalUtils;
import com.sun.org.glassfish.external.statistics.annotations.Reset;

/**
 * 贷款 controller
 * @author K550J
 *
 */
@Controller
@RequestMapping("/loan")
public class LoanController {
	
	private static final double YEARRATE = 0.144;//年利率
	
	@Autowired
	private PersonalLoanService personalLoanService;
	
	@Autowired
	private CompanyLoanService companyLoanService;
	
	
	/**
	 * ajax json 获取当前系统时间的毫秒值
	 * @return
	 */
	@RequestMapping(value="now",method=RequestMethod.GET,
				produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public LoanResult<Long> time(){
		Date now = new Date();
		return new LoanResult<>(true,now.getTime());
	}
	
	/**
	 * 进入贷款前的实名认证检查 
	 * @return
	 */
	@RequestMapping("certificationCheck")
	public String certificationCheck(HttpSession session,Model model){
		
		/*实名认证检查
		 * 1.在session获取Userinfo对象的实名信息
		 * 2.判断实名信息是否为空，都不为空则进入贷款页，为空则返回首页
		 */
		
		UserIntegration userIntegration = (UserIntegration)session.getAttribute("user");
		String realname = userIntegration.getUserInfo().getUserRealname();
		String identity = userIntegration.getUserInfo().getUserIdentitynum();
		if(realname!=null&&identity!=null){
			model.addAttribute("userId",userIntegration.getUser().getId());///页面用这个字段，防止账号有其他地方登录
			return "personalLoanInfo";
		}else{
			model.addAttribute("error","未进行实名验证，无法贷款");
			return "index/toIndex";
		}
	}
	
	@RequestMapping(value="enter/toPersonalLoanInfo")
	public String enterPersonalLoan(){
		return "personalLoanInfo";
	}
	
	@RequestMapping(value="enter/toCompanyLoanInfo")
	public String enterCompanyLoan(){
		return "companyLoanInfo";
	}
	
	/**
	 * 获取要还款的金额
	 * @param loanMoney
	 * @param loanMonth
	 * @return
	 */
	@RequestMapping(value="{loanMoney}/{loanMonth}/getReturnMoney",method=RequestMethod.POST,produces={"application/json;charset=utf-8"})
	@ResponseBody
	public LoanResult<Double> getReturnMoney(@PathVariable("loanMoney")Double loanMoney,@PathVariable("loanMonth")Integer loanMonth){
		LoanResult<Double> result =  null;
		if(loanMoney!=null&&loanMoney instanceof Double){
			if(loanMonth!=null&&loanMonth instanceof Integer){
			  Double interestCount = AverageCapitalUtils.getInterestCount(loanMoney,YEARRATE,loanMonth);
			  Double returnMoney = interestCount+loanMoney;//需还款=本金+总利息
			  result = new LoanResult<Double>(true,returnMoney);
			}else{
				result = new LoanResult<Double>(false,"还款月数格式有问题");
			}
		}else{
			result = new LoanResult<Double>(false,"贷款金额格式有问题");
		}
		return result;
	}
	
	/**
	 * 获取还款详情
	 * @return
	 */
	@RequestMapping(value="{loanMoney}/{loanMonth}/getReturnDetail",method=RequestMethod.POST)
	public String getReturnDetail(Model model,@PathVariable("loanMoney") Double loanMoney,@PathVariable("loanMonth") Integer loanMonth){
		System.out.println("进入方法:"+loanMoney+"-"+loanMonth);
		LoanReturnDetail returnDetail = AverageCapitalUtils.getReturnDetail(loanMoney, loanMonth,YEARRATE);
		
		model.addAttribute("returnDetail",returnDetail);
		
		return "returnDetail";
	}
	
	/**
	 * 保存个人贷款资料
	 * @return
	 */
	@RequestMapping(value="savePersonalLoanInfo",method=RequestMethod.POST,produces={"application/json;charset=utf-8"})
	@ResponseBody
	public LoanResult<PersonalLoanInfo> savePersonalLoanInfo(HttpSession session,PersonalLoanInfo personalLoanInfo){
		
		/*保存贷款资料
		 * 1.接收个人贷款资料
		 * 2.判断个人贷款资料字段是否合法(后台判断)
		 * 3.字段无误后，把资料保存至session
		 */
		
		LoanResult<PersonalLoanInfo> result = null;
		UserIntegration userIntegration = (UserIntegration)session.getAttribute("user");
		result  = personalLoanService.checkPersonalLoanInfo(personalLoanInfo,userIntegration);//后台检查个人贷款信息字段
		if(result.isSuccess){
			//贷款信息暂存至session中
			session.setAttribute("personalLoanInfo",result.getData());
		}
		return result;
	}

	/**
	 * 完成个人贷款资料上传，创建个人贷款申请
	 * @param session
	 * @param materialPersonal
	 * @param materialMortgage
	 * @return
	 */
	@RequestMapping(value="addPersonalLoan",produces={"application/json;charset=utf-8"})
	@ResponseBody
	public LoanResult<PersonalLoanInfo> addPersonalLoan(HttpSession session,
				@RequestParam("materialPersonal") MultipartFile materialPersonal,
				@RequestParam("materialMortgage") MultipartFile materialMortgage){
		
		/*创建个人贷款申请
		 * 0.判断session是否保存个人贷款资料
		 * 1.上传保存资料文件
		 * 2.创建资料对象并保存到数据库
		 * 3.把session的个人贷款资料存到数据库
		 * 
		 */
		LoanResult<PersonalLoanInfo> result = null;
		PersonalLoanInfo personalLoanInfo = (PersonalLoanInfo)session.getAttribute("personalLoanInfo");
		UserIntegration userIntegration = (UserIntegration)session.getAttribute("user");
		if(personalLoanInfo!=null){
			String path = session.getServletContext().getRealPath("/");
			result = personalLoanService.addPersonalLoan(materialPersonal, materialMortgage, path, personalLoanInfo,userIntegration);
			if(result.isSuccess){
				session.removeAttribute("personalLoanInfo");//删除前面暂存的贷款信息
			}
		}else{
			result = new LoanResult<PersonalLoanInfo>(false,"贷款信息有问题");
		}
		
		return result;
	}

	/**
	 * 撤回个人贷款申请(删除未被审核的个人贷款)
	 * @param personalLoanInfoId
	 * @return
	 */
	@RequestMapping(value="{personalLoanInfoId}/deletePersonalLoan",produces={"application/json;charset=utf-8"})
	@ResponseBody
	public LoanResult<String> deletePersonalLoan(@PathVariable("personalLoanInfoId") String personalLoanInfoId){
		LoanResult<String> result = null;
		result = personalLoanService.deletePersonLoan(personalLoanInfoId);
		return result;
	}
	
	/**
	 * 个人贷款还款 
	 * @param personalLoanInfoId
	 * @return
	 */
	@RequestMapping(value="{personalLoanInfoId}/repayPersonalLoan",produces={"application/json;charset=utf-8"})
	@ResponseBody
	public LoanResult<String> repayPersonalLoan(HttpSession session,@PathVariable("personalLoanInfoId") String personalLoanInfoId){
		
		/*个人贷款还款
		 * 
		 * 1.修改贷款状态
		 * 2.记录还款时间
		 * 
		 */
		
		LoanResult<String> result = null;
		result = personalLoanService.repayPersonalLoan(personalLoanInfoId);
		System.out.println(result.getData());
		return result;
	}
	
	
	/**
	 * 个人贷款领款
	 * @param session
	 * @param personalLoanInfoId
	 * @return
	 */
	@RequestMapping(value="{personalLoanInfoId}/takemoneyPersonalLoan",produces={"application/json;charset=utf-8"})
	@ResponseBody
	public LoanResult<String> takemoneyPersonalLoan(HttpSession session,@PathVariable("personalLoanInfoId") String personalLoanInfoId){
		
		LoanResult<String> result = null;
		try{
			result = personalLoanService.takemoneyPersonalLoan(personalLoanInfoId);
		}catch (Exception e) {
			result = new LoanResult<String>(false,"","系统异常，请稍后重试或反馈管理员");
		}
		return result;
	}
	
	/**
	 * 企业贷款保存信息
	 * @param session
	 * @param companyLoanInfo
	 * @return
	 */
	@RequestMapping(value="saveCompanyLoanInfo",method=RequestMethod.POST,produces={"application/json;charset=utf-8"})
	@ResponseBody
	public LoanResult<CompanyLoanInfo> saveCompanyLoanInfo(HttpSession session,CompanyLoanInfo companyLoanInfo){
		
		LoanResult<CompanyLoanInfo> result = null;
		UserIntegration userIntegration = (UserIntegration)session.getAttribute("user");
		result  = companyLoanService.checkCompanyLoanInfo(companyLoanInfo, userIntegration);//后台检查个人贷款信息字段
		if(result.isSuccess){
			//贷款信息暂存至session中
			session.setAttribute("companyLoanInfo",result.getData());
		}
		return result;
	}
	
	/**
	 * 完成企业资料上传，创建企业贷款申请
	 * @param session
	 * @param materialPersonal
	 * @param materialMortgage
	 * @return
	 */
	@RequestMapping(value="addCompanyLoan",produces={"application/json;charset=utf-8"})
	@ResponseBody
	public LoanResult<CompanyLoanInfo> addCompanyLoan(HttpSession session,
				@RequestParam("materialAptitude") MultipartFile materialAptitude,
				@RequestParam("materialMortgage") MultipartFile materialMortgage){
		
		/*创建个人贷款申请
		 * 0.判断session是否保存个人贷款资料
		 * 1.上传保存资料文件
		 * 2.创建资料对象并保存到数据库
		 * 3.把session的企业资料存到数据库
		 * 
		 */
		LoanResult<CompanyLoanInfo> result = null;
		CompanyLoanInfo companyLoanInfo = (CompanyLoanInfo)session.getAttribute("companyLoanInfo");
		UserIntegration userIntegration = (UserIntegration)session.getAttribute("user");
		if(companyLoanInfo!=null){
			String path = session.getServletContext().getRealPath("/");
			result = companyLoanService.addCompanyLoan(materialAptitude, materialMortgage, path, companyLoanInfo,userIntegration);
			if(result.isSuccess){
				session.removeAttribute("companyLoanInfo");//删除前面暂存的贷款信息
			}
		}else{
			result = new LoanResult<CompanyLoanInfo>(false,"贷款信息有问题");
		}
		return result;
	}
	
	/**
	 * 撤回企业贷款申请(删除未被审核的企业贷款)
	 * @param personalLoanInfoId
	 * @return
	 */
	@RequestMapping(value="{companyLoanInfoId}/deleteCompanyLoan",produces={"application/json;charset=utf-8"})
	@ResponseBody
	public LoanResult<String> deleteCompanyLoan(@PathVariable("companyLoanInfoId") String companyLoanInfoId){
		LoanResult<String> result = null;
		result = companyLoanService.deleteCompanyLoan(companyLoanInfoId);
		return result;
	}
	
	/**
	 * 企业贷款还款 
	 * @param personalLoanInfoId
	 * @return
	 */
	@RequestMapping(value="{companyLoanInfoId}/repayCompanyLoan",produces={"application/json;charset=utf-8"})
	@ResponseBody
	public LoanResult<String> repayCompanyLoan(HttpSession session,@PathVariable("companyLoanInfoId") String companyLoanInfoId){
		
		LoanResult<String> result = null;
		result = companyLoanService.repayCompanyLoan(companyLoanInfoId);
		System.out.println(result.getData());
		return result;
	}
	
	
	
}
