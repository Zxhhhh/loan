package com.gy612.loan.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.gy612.loan.dao.UserMapper;
import com.gy612.loan.dto.LoanInfoAndMaterial;
import com.gy612.loan.dto.LoanResult;
import com.gy612.loan.dto.RegisterUserResult;
import com.gy612.loan.dto.UserIntegration;
import com.gy612.loan.entity.BorrowInfo;
import com.gy612.loan.entity.BorrowMaterial;
import com.gy612.loan.entity.CompanyLoanInfo;
import com.gy612.loan.entity.CompanyLoanMaterial;
import com.gy612.loan.entity.PersonalLoanInfo;
import com.gy612.loan.entity.PersonalLoanMaterial;
import com.gy612.loan.entity.User;
import com.gy612.loan.entity.UserInfo;
import com.gy612.loan.entity.UserSecure;
import com.gy612.loan.exception.MailAddrException;
import com.gy612.loan.service.BorrowService;
import com.gy612.loan.service.CompanyLoanService;
import com.gy612.loan.service.PersonalLoanService;
import com.gy612.loan.service.UserService;
import com.gy612.loan.utils.MailUtils;
import com.gy612.loan.utils.NumUtils;

/*
 *用户模块controller 
 * @author K550J
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private PersonalLoanService personalLoanService;
	
	@Autowired
	private CompanyLoanService companyLoanService;
	
	@Autowired
	private BorrowService borrowService;
	
	@Value("#{propertiesReader['repository_src']}")
	private String repository_src;
	
	@RequestMapping("/toRegister")
	public String toRegister(){
		
		return "register";
	}
	
	
	
	/**
	 * 用户注册
	 * @param model
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value="register",produces="application/json;charset=utf-8")
	@ResponseBody
	public RegisterUserResult userRegister(String username,String password,String userMail,HttpSession session,Model model){
		
		RegisterUserResult user = null;
		/*注册:
		 * 1.验证注册账号(用户,邮箱是否已存在,验证码是否正确)
		 * 2.加密密码->保存至数据库(设为未激活)->创建验证码
		 */
		try{
			user = userService.userRegister(username, password, userMail);//注册
			System.out.println(user);
			if(user.isSuccess){
				//证明用户是经过注册进来的
				session.setAttribute("check",true);
			}
		}catch (MailAddrException e) {
			user = new RegisterUserResult(false,"邮箱地址不存在");
		}catch (Exception e) {
			user = new RegisterUserResult(false,"系统内部错误");
		}
		
		return user;
	}
	
	/**
	 * 发送一封验证邮件
	 * @param id
	 * @return
	 */
	@RequestMapping(value="sendCheckMail",method=RequestMethod.POST)
	@ResponseBody
	
	public RegisterUserResult sendCheckMail(String id){
		
		/*手动发送验证邮件
		 * 1.发送邮件
		 * 2.获得验证码与邮件地址并存至RegisterUserResult中
		 * 3.返回RegisterUserResult
		 * 
		 */
		
		Integer checkCode = NumUtils.createMailCheckCode();
		User user = userMapper.selectByPrimaryKey(id);
		RegisterUserResult result = new RegisterUserResult(true,user);
		result.setMailCheckCode(checkCode);
		result = MailUtils.sendCheckMail(result);
		return result;
	}
	
	/**
	 * 激活用户
	 * @return
	 */
	@RequestMapping(value="activity",produces="application/json;charset=utf-8")
	@ResponseBody
	public LoanResult<User> userActivity(String id,String inputCode,String correctCode){
		
		/*激活用户:
		 * 1.传入激活的用户id，验证码
		 * 2.审核id是否正确，验证码是否正确
		 * 3.成功后修改用户激活状态
		 * 
		 */
		LoanResult<User> user = null;
		if(inputCode.equals(correctCode)){
			user = userService.userActivity(id);//激活用户
		}else{
			user = new LoanResult<User>(false,"验证码错误");
		}
		
		return user;
	}
	
	/**
	 * 跳转至用户信息页面
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("{id}/toUserInfo")
	public String toUserInfo(Model model,@PathVariable("id") String id,HttpSession session,HttpServletRequest request){
		System.out.println("id:"+id);
		if(session.getAttribute("check")!=null){//防止用户直接通过url进入,check仅在登录或注册成功时给予
			//model.addAttribute("id",id);
			request.setAttribute("id",id);
			return "userinfo";
		}else{
			return "redirect:/user/toRegister";
		}
		
	}
	
	/**
	 * 完善个人资料
	 * @return
	 * @param id
	 * @param userInfo
	 */
	@RequestMapping(value="infoImprove",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public LoanResult<User> userInfoImprove(@RequestParam("userId") String userId,UserInfo userInfo){
		
		/*完善用户
		 * 1.通过id获得用户对象
		 * 2.完善个人信息:新建用户信息对象，并把记录的id插入到用户记录中
		 * 3.完善个人权限，状态:新建用户状态，用户权限对象，并把记录id插入用户记录中
		 * 4.返回封装对象
		 */
		System.out.println(userInfo);
		LoanResult<User> user = userService.userImprove(userId, userInfo);
		return user;
	}
	
	@RequestMapping(value="{id}/integrationUser")
	public String integrationUser(@PathVariable("id") String id,HttpSession session){
		
		/*整合用户
		 * 1.通过id找到用户
		 * 2.通过用户获取用户的状态(state),权限(role),安全(secure),信息(info)对象
		 * 3.把5个对象封装，并传入到session中
		 * 4.重定向调用前往主页的方法(两个方法分开，便于mvc拦截器拦截)
		 */
		UserIntegration userIntegration = userService.userIntegration(id);
		if(userIntegration!=null){
			session.removeAttribute("check");
			session.setAttribute("user",userIntegration);
			return "redirect:/index/toIndex";
		}else{
			return "redirect:/user/toRegister";
		}
	}
	
	
	/**
	 * 转到登录页
	 * @return
	 */
	@RequestMapping(value="toLogin",method=RequestMethod.GET)
	public String toLogin(){
		return "login";
	}
	
	/**
	 * 用户登录
	 * @param nameOrMail
	 * @param password
	 * @return
	 */
	@RequestMapping(value="loginCheck",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public LoanResult<User> loginCheck(String nameOrMail,String password){
		
		/*用户登录(仅处理用户登录，用户状态的判断)
		 * 1.获取用户名/邮箱 密码 验证码
		 * 2.进行登录,进行两次判断(用户名，邮箱)
		 * 3.把封装好的结果通过
		 */
		LoanResult<User> user = userService.userLogin(nameOrMail, password);
		
		return user;
	}
	
	/**
	 * 用户登出
	 */
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(HttpSession session){
		
		/*用户登出
		 * 1.删除session会话保存的user对象
		 * 2.注销session
		 * 3.返回登录页
		 * 
		 */
		session.removeAttribute("user");
		session.invalidate();
		
		return "redirect:/user/toLogin";
	}
	
	/**
	 * 用户登录至主页
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value="{id}/login")
	public String login(@PathVariable("id") String id,HttpSession session){
		
		/*用户登录至主页
		 * 1.通过id获取用户对象
		 * 2.判断用户是否为空(url直接访问),有无填写用户信息
		 * 3.重定向到对应请求
		 */
		
		User user = userMapper.selectByPrimaryKey(id);
		
		if(user!=null){
			//证明用户是经过注册进来的
			session.setAttribute("check",true);
			
			if(user.getInfoId()!=null){
				return "redirect:/user/"+id+"/integrationUser";
			}else{
				return "redirect:/user/"+id+"/toUserInfo";
			}
		}
		return "redirect:/user/toLogin";
	}
	
	/**
	 * 转到密码忘记页
	 * @return
	 */
	@RequestMapping(value="toForgetPassword")
	public String toForgetPassword(){
		
		return "forgetPassword";
	}
	
	/**
	 * 由用户名获取用户信息(类似用户整合)
	 * @param username
	 * @return
	 */
	@RequestMapping(value="checkUser",produces="application/json;charset=utf-8")
	@ResponseBody
	public LoanResult<UserIntegration> checkUser(String username){
	  LoanResult<UserIntegration> user = userService.userCheck(username);
	  return user;
	}
	
	/**
	 * 验证邮箱验证码
	 * @param id
	 * @return
	 */
	@RequestMapping(value="check",produces="application/json;charset=utf-8")
	@ResponseBody
	public LoanResult<User> check(String id,String inputCode,String correctCode,HttpSession session){
		
		/*验证邮箱验证码
		 * 1.判断输入验证码是否一致
		 * 2.获取用户并返回
		 * 
		 */
		LoanResult<User> result = null;
		if(correctCode.equals(inputCode)){
			User user = userMapper.selectByPrimaryKey(id);
			if(user!=null){
				result = new LoanResult<>(true,user);
				session.setAttribute("changePassCheck","changePassCheck");//加上标记,表明已通过验证
			}else{
				result = new LoanResult<User>(false,"用户信息错误,请勿篡改页面数据");
			}
		}else{
			result = new LoanResult<User>(false,"验证码错误");
		}
		
		return result;
	}
	
	/**
	 * 转到更改密码页
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("{id}/toChangePass")
	public String toChangePass(@PathVariable("id") String id,Model model,HttpSession session){

		if(session.getAttribute("changePassCheck")!=null){
			model.addAttribute("id",id);
			session.removeAttribute("changePassCheck");//进入更改密码页面后便删除标记
			return "changePass";
		}else{
			return "redirect:/user/toLogin";
		}
	}
	
	/**
	 * 更改密码(忘记密码状态下)
	 * @param id
	 * @param newPassword
	 * @param confirmPassword
	 * @return
	 */
	@RequestMapping(value="changePass",produces="application/json;charset=utf-8")
	@ResponseBody
	public LoanResult<User> changeePass(String id,String newPassword,String confirmPassword){
		
		/*更改密码(忘记密码状态下):
		 * 1.判断两次密码输入是否正确
		 * 2.通过id获取用户，判断用户，加密，修改密码
		 * 3.返回新的用户对象
		 */
		
		LoanResult<User> result = null;
		
		if(newPassword.equals(confirmPassword)){
			//TODO 更改密码
			result = userService.ChangePass(id, newPassword);
		}else{
			result = new LoanResult<>(false,"两次密码输入不相同");
		}
		return result;
	}
	
	/**
	 * 修改密码(已登录状态下)
	 * @param oldPass
	 * @param newPass
	 * @param confirmPass
	 * @param session
	 * @return
	 */
	@RequestMapping(value="changePass_login",produces={"application/json;charset=utf-8"})
	@ResponseBody
	public LoanResult<UserIntegration> changePass_login(String oldPass,String newPass,String confirmPass,HttpSession session){
		
		/*修改密码(已登录状态下)
		 * 
		 */
		
		LoanResult<UserIntegration> result = null;
		UserIntegration userIntegration = (UserIntegration)session.getAttribute("user");
		if(newPass.equals(confirmPass)){//判断两次是否输入一致
			result = userService.changePass_login(userIntegration, oldPass, newPass);
			if(result.isSuccess){//说明修改密码成功
				session.setAttribute("user",userIntegration);
			}else{
				result = new LoanResult<UserIntegration>(false,result.getErrorMessage());
			}
		}else{
			result = new LoanResult<UserIntegration>(false,"两次密码输入不相同");
		}
		
		return result;
		
	}
	
	/**
	 * 用户安全设置
	 * @param userSecure
	 * @return
	 */
	@RequestMapping(value="secureSet",produces={"application/json;charset=utf-8"})
	@ResponseBody
	public LoanResult<UserIntegration> secureSet(UserSecure userSecure,HttpSession session){
		
		/*安全设置
		 * 1.获取安全对象，插入到数据库中
		 * 2.把安全对象id设置到用户对象中
		 * 3.更新用户整合对象并存到session
		 */
		
		LoanResult<UserIntegration> result = null;
		UserIntegration userIntegration = (UserIntegration)session.getAttribute("user");
		try{
			result = userService.secureSet(userIntegration, userSecure);
			if(result.isSuccess){//更新用户整合
				userIntegration = result.getData();
				session.setAttribute("user",userIntegration);
			}
		}catch (Exception e) {
			result = new LoanResult<UserIntegration>(false,"内部异常,请稍后重试");
		}
		
		return result;
	}
	
	/**
	 * 修改用户信息
	 * @param userInfo
	 * @return
	 */
	@RequestMapping(value="updateUserInfo",produces="application/json;charset=utf-8")
	@ResponseBody
	public LoanResult<UserIntegration> updateUserInfo(UserInfo userInfo,HttpSession session){
		
		/*修改用户信息
		 * 1.在session获得用户整合的对象
		 * 2.把传入的新用户信息userinfo存至数据库
		 * 3.回调，获取最新的完整用户信息
		 * 4.更新用户整合对象并存到session
		 */
		System.out.println("age:"+userInfo.getUserAge());
		LoanResult<UserIntegration> result = null;
		UserIntegration userIntegration = (UserIntegration)session.getAttribute("user");
		result = userService.updateInfo(userIntegration, userInfo);
		if(result.isSuccess){
			session.setAttribute("user",result.getData());//更新session的用户整合
			
		}
		
		return result;
	}
	
	/**
	 * 上传用户头像
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value="logoUpload",produces="application/json;charset=utf-8")
	@ResponseBody
	public LoanResult<UserIntegration> logoUpload(@RequestParam("userLogo1") MultipartFile file,HttpSession session){
		LoanResult<UserIntegration> result = null;
		System.out.println("文件名:"+file.getOriginalFilename());
		UserIntegration userIntegration = (UserIntegration)session.getAttribute("user");
		try{
			String path = session.getServletContext().getRealPath("/");
			result = userService.uploadLogo(userIntegration, file, path);//上传文件
			session.setAttribute("user",result.getData());//更新用户整合
		}catch (Exception e) {
			result = new LoanResult<UserIntegration>(false,"系统异常，不能读取");
		}
	    return result;
	}
	
	/**
	 * 用户进行实名认证 
	 * @return
	 */
	@RequestMapping(value="certification",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public LoanResult<UserIntegration> userCertification(HttpSession session,@RequestParam("userIdentitypic") MultipartFile file,String userIdentitynum,String userRealname){
		
		LoanResult<UserIntegration> result = null;
		
		System.out.println("上传的文件名:"+file.getOriginalFilename());
		
		/*实名认证
		 * 1.获取上传的图片和姓名，号码
		 * 2.判断姓名，号码是否已被实名认证
		 * 3.若无，上传图片，获取地址赋到userInfo
		 * 4.更新用户整合
		 */
		UserIntegration userIntegration = (UserIntegration)session.getAttribute("user");
		String path = session.getServletContext().getRealPath("/");
		result = userService.userCertification(userIntegration, file, userIdentitynum, userRealname, path);
		if(result.isSuccess){//如果方法调用成功,则更新用户整合
			session.setAttribute("user",userIntegration);
		}
		
		return result;
	}

	/**
	 * 获取个人贷款记录列表
	 * @return
	 */
	@RequestMapping("personalLoanList")
	public String personalLoanList(Integer pageNum,HttpSession session,Model model){
	
		if(pageNum==null){
			pageNum = 1;
		}
		
		UserIntegration userIntegration = (UserIntegration)session.getAttribute("user");
		List<PersonalLoanInfo> loans = personalLoanService.getPersonalLoanInfoList(pageNum,userIntegration.getUser().getId());
		PageInfo<PersonalLoanInfo> pageInfo = new PageInfo<>(loans);
		
		model.addAttribute("loans",loans);
		model.addAttribute("pageInfo",pageInfo);
		
		return "personalLoanList";
	}
	
	/**
	 * 获取个人贷款详细
	 * @param personalLoanInfoId
	 * @param model
	 * @return
	 */
	@RequestMapping("{personalLoanInfoId}/personalLoanDetail")
	public String personalLoanDetail(@PathVariable("personalLoanInfoId") String personalLoanInfoId,Model model){
		
		System.out.println("id:"+personalLoanInfoId);
		LoanInfoAndMaterial<PersonalLoanInfo,PersonalLoanMaterial> infoAndMaterial = personalLoanService.getPersonalLoanDetail(personalLoanInfoId);
		model.addAttribute("im",infoAndMaterial);
		System.out.println(infoAndMaterial);
		return "personalLoanDetail";
	}
	
	/**
	 * 获取企业贷款记录列表
	 * @param pageNum
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("companyLoanList")
	public String companyLoanList(Integer pageNum,HttpSession session,Model model){
		
		if(pageNum==null){
			pageNum = 1;
		}
		
		UserIntegration userIntegration = (UserIntegration)session.getAttribute("user");
		List<CompanyLoanInfo> loans =  companyLoanService.getCompanyLoanInfoList(pageNum, userIntegration.getUser().getId());
		PageInfo<CompanyLoanInfo> pageInfo = new PageInfo<>(loans);
		model.addAttribute("loans",loans);
		model.addAttribute("pageInfo",pageInfo);
		
		return "companyLoanList";
	}
	
	/**
	 * 获取企业贷款详细
	 * @param personalLoanInfoId
	 * @param model
	 * @return
	 */
	@RequestMapping("{companyLoanInfoId}/companyLoanDetail")
	public String compannyLoanDetail(@PathVariable("companyLoanInfoId") String companyLoanInfoId,Model model){
		
		System.out.println("id:"+companyLoanInfoId);
		LoanInfoAndMaterial<CompanyLoanInfo,CompanyLoanMaterial> infoAndMaterial = companyLoanService.getCompanyLoanDetail(companyLoanInfoId);
		model.addAttribute("im",infoAndMaterial);
		System.out.println(infoAndMaterial);
		return "companyLoanDetail";
	}
	
	/**
	 * 获取借钱记录列表
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("borrowList")
	public String borrowList(Integer pageNum,HttpSession session,Model model){
		
		if(pageNum==null){
			pageNum = 1;
		}
		
		UserIntegration userIntegration = (UserIntegration)session.getAttribute("user");
		List<BorrowInfo> loans = borrowService.getBorrowInfoList(pageNum,userIntegration.getUser().getId());
		PageInfo<BorrowInfo> pageInfo = new PageInfo<BorrowInfo>(loans);
		model.addAttribute("loans",loans);
		model.addAttribute("pageInfo",pageInfo);
		return "borrowList";
	}
	
	/**
	 * 获取借钱详细
	 * @param borrowId
	 * @return
	 */
	@RequestMapping("{borrowInfoId}/borrowDetail")
	public String borrowDetail(String borrowInfoId,Model model){
		
		LoanInfoAndMaterial<BorrowInfo,BorrowMaterial> infoAndMaterial = borrowService.getBorrowDetail(borrowInfoId);
		model.addAttribute("im",infoAndMaterial);
		
		return "borrowDetail";
	}
	
	/**
	 * 
	 * @param id
	 * @param quesAnswer
	 * @return
	 */
	@RequestMapping(value="checkQuesAnswer",method=RequestMethod.POST,produces={"application/json;charset=utf-8"})
	@ResponseBody
	public LoanResult<User> checkQuesAnswer(HttpSession session,String id,String quesAnswer){
		
		LoanResult<User> result = null;
		
		result = userService.quesAnswerCheck(id, quesAnswer);
		if(result.isSuccess){
			session.setAttribute("changePassCheck","changePassCheck");//加上标记,表明已通过验证
		}
		
		return result;
	}
	
}
