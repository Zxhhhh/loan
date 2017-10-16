

package com.gy612.loan.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gy612.loan.dto.UserIntegration;
import com.gy612.loan.entity.CompanyLoanInfo;
import com.gy612.loan.entity.Feedback;
import com.gy612.loan.entity.PersonalLoanInfo;
import com.gy612.loan.entity.Remind;
import com.gy612.loan.entity.TypeUserrole;
import com.gy612.loan.service.FeedbackService;
import com.gy612.loan.service.PersonalLoanService;
import com.gy612.loan.service.RemindService;
import com.gy612.loan.service.UserRoleService;
import com.gy612.loan.service.UserService;
import com.gy612.loan.utils.DwrPush;

/**
 * 主页的Contoller 处理来自主页的请求
 * @author K550J
 *
 */
@RequestMapping("/index")
@Controller
public class IndexController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private PersonalLoanService personalLoanService;
	@Autowired
	private RemindService remindService;
	@Autowired
	private FeedbackService feedbackService;
	
	/**
	 * 转到主页
	 * @return
	 */
	@RequestMapping(value="toIndex")
	public String toIndex(HttpSession session,Model model){
		UserIntegration userIntegration = (UserIntegration)session.getAttribute("user");
		List<PersonalLoanInfo> loans = personalLoanService.getPersonalLoanInfoList(1,userIntegration.getUser().getId());
		List<Remind> reminds = remindService.getRemindsByUserId(userIntegration.getUser().getId());
		List<Feedback> feedbacks = feedbackService.getFeedbacksByUserId(userIntegration.getUser().getId());
		
		model.addAttribute("loanCount",loans.size());
		model.addAttribute("remindCount",reminds.size());
		model.addAttribute("feedbackCount",feedbacks.size());
		return "index";
	}
	
	/**
	 * 进入用户中心
	 * @return
	 */
	@RequestMapping("toUserCenter")
	public String toUserCenter(){
		return "userCenter";
	}
	
	/**
	 * 进入用户中心->个人信息
	 * @return
	 */
	@RequestMapping("toUserCenter_info")
	public String toUserCenter_info(){
		return "userCenter_info";
	}
	
	/**
	 * 进入安全设置
	 * @return
	 */
	@RequestMapping("toSecureSet")
	public String toSecureSet(){
		return "secureSet";
	}
	
	/**
	 * 进入信息详情页
	 */
	@RequestMapping("toInfoDetail")
	public String toInfoDetail(){
		return "infoDetail";
	}
	
	
	/**
	 * 进入更改密码页面
	 * @return
	 */
	@RequestMapping("toChangePassword_login")
	public String toChangePassword_login(){
		return "changePassword_login";
	}
	
	/**
	 * 进入实名认证页面
	 * @return
	 */
	@RequestMapping(value="toCertification")
	public String toCertification(){
		return "certification";
	}
	
	/**
	 * 进入websocket页面
	 * @return
	 */
	@RequestMapping("toWebsocket")
	public String toWebsocket(){
		return "websocket";
	}
	
	@RequestMapping("toRegister")
	public String toRegister(){
		return "register";
	}
	
	/**
	 * 前往借贷记录页面
	 * @return
	 */
	@RequestMapping("toLoanRecord")
	public String toLoanRecord(){
		
		return "loanRecord";
	}
	
	/**
	 * 前往消息中心页面
	 * @return
	 */
	@RequestMapping("toRemindCenter")
	public String toNewsCenter(Integer page,String remindType,String remindState,Model model){
		
		if(page==null){
			page = 1;
		}
		
		model.addAttribute("page",page);
		model.addAttribute("remindType",remindType);
		model.addAttribute("remindState",remindState);
		
		return "remindCenter";
	}
	

	
	/**
	 * 前往个人的贷款上传资料页面
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("toPersonalLoanMaterial")
	public String toPersonalLoanMaterial(Model model,HttpSession session){
		PersonalLoanInfo personalLoanInfo = (PersonalLoanInfo)session.getAttribute("personalLoanInfo");
		if(personalLoanInfo==null){
				System.out.println("1");
				model.addAttribute("error","由正确途径进入贷款");
				return "index/toIndex";
		}
		return "personalLoanMaterial";
	}
	
	/**
	 * 前往个人的贷款上传资料页面
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("toCompanyLoanMaterial")
	public String toCompanyLoanMaterial(Model model,HttpSession session){
		CompanyLoanInfo companyLoanInfo = (CompanyLoanInfo)session.getAttribute("companyLoanInfo");
		if(companyLoanInfo==null){
				System.out.println("1");
				model.addAttribute("error","由正确途径进入贷款");
				return "index/toIndex";
		}
		return "companyLoanMaterial";
	}
	
	
	/**
	 * 前往意见反馈页面
	 * @return
	 */
	@RequestMapping("toFeedback")
	public String toFeedback(){
		return "feedback";
	}
	
	/**
	 * 前往反馈记录页面
	 * @return
	 */
	@RequestMapping("toFeedbackRecord")
	public String toFeedbackRecord(Integer page,Model model){
		if(page==null){
			page=1;
		}
		model.addAttribute("page",page);
		return "feedbackRecord";
	}
	
	@RequestMapping("toServerSend")
	public String toSerrverSend(){
		DwrPush.ServerSend("zxh","测试消息12312323");
		return "index";
	}
	
	@RequestMapping("toUserRole")
	public String toUserRole(Model model){
		List<TypeUserrole> types = userRoleService.getAllTypeUserrole();
		model.addAttribute("types",types);
		return "userRole";
	}
	
	@RequestMapping("toSendMessage")
	public String toSendMessage(){
		return "sendMessage";
	}
	
}
