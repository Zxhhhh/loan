package com.gy612.loan.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import com.gy612.loan.dao.UserInfoMapper;
import com.gy612.loan.dao.UserMapper;
import com.gy612.loan.dao.UserRoleMapper;
import com.gy612.loan.dao.UserSecureMapper;
import com.gy612.loan.dao.UserStateMapper;
import com.gy612.loan.dto.LoanResult;
import com.gy612.loan.dto.RegisterUserResult;
import com.gy612.loan.dto.UserIntegration;
import com.gy612.loan.entity.Remind;
import com.gy612.loan.entity.TypeUserrole;
import com.gy612.loan.entity.User;
import com.gy612.loan.entity.UserExample;
import com.gy612.loan.entity.UserSecure;
import com.gy612.loan.entity.UserState;
import com.gy612.loan.entity.UserExample.Criteria;
import com.gy612.loan.entity.UserInfo;
import com.gy612.loan.entity.UserRole;
import com.gy612.loan.exception.MailAddrException;
import com.gy612.loan.service.RemindService;
import com.gy612.loan.service.UserRoleService;
import com.gy612.loan.service.UserService;
import com.gy612.loan.utils.MailUtils;
import com.gy612.loan.utils.NumUtils;

/**
 * 用户 service 实现类
 * @author K550J
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	@Autowired
	private UserStateMapper userStateMapper;
	@Autowired
	private UserSecureMapper userSecureMapper;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private RemindService remindService;
	
	
	@Override
	public List<User> selectByExample(UserExample example) {
		return userMapper.selectByExample(example);
	}

    
	@Override
	@Transactional //方法启动事务
	public RegisterUserResult userRegister(String username, String password,
			String userMail) {
		
		/*验证，创建用户
		 * 1.验证用户账号，邮箱是否存在
		 * 2.创建账号
		 * 
		 */
		RegisterUserResult result = null;
		try{
			UserExample example = new UserExample();
			Criteria cri = example.createCriteria();
			cri.andUsernameEqualTo(username);
			List<User> name_users = selectByExample(example);
			
			example = new UserExample();
			cri = example.createCriteria();
			cri.andUsermailEqualTo(userMail);
			List<User> mail_users = selectByExample(example);
			
			if(name_users.size()==0){
				if(mail_users.size()==0){
					String salt = NumUtils.createSlat();
					String id = NumUtils.createId();
					String encodePassword = DigestUtils.md5DigestAsHex((salt+password).getBytes());
					
					User user = new User(id, username,encodePassword,userMail, salt);
					byte b = 0;
					user.setIsActivate(b);
					Integer count = userMapper.insert(user);
					if(count!=0){
						user =  userMapper.selectByPrimaryKey(id);
						String mailService = userMail.split("@")[1];
						result = new RegisterUserResult(true,user);
						result.setTargetMailUrl("http://mail."+mailService);
						
						Integer mailCheckCode = NumUtils.createMailCheckCode();
						result.setMailCheckCode(mailCheckCode);//传输邮箱验证码
						result = MailUtils.sendCheckMail(result);//发邮件
						
					}else{
						result = new RegisterUserResult(false,"系统内部错误");
					}
				}else{
					result = new RegisterUserResult(false,"邮箱已被注册");
				}
			}else{
				result = new RegisterUserResult(false,"用户已存在");
			}
		}catch(MailAddrException e1){
			e1.printStackTrace();
			throw  new MailAddrException("邮箱地址不存在");
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();//回滚
		}
		return result;
	}


	@Override
	public LoanResult<User> userActivity(String id) {
		
		LoanResult<User> result;
		
		User user = userMapper.selectByPrimaryKey(id);
		if(user!=null){
				byte b =1;
				user.setIsActivate(b);
				int count = userMapper.updateByPrimaryKeySelective(user);
				if(count!=0){
					result = new LoanResult<User>(true,user);
				}else{
					result = new LoanResult<User>(false,"系统内部错误");
				}
		}else{
			result = new LoanResult<User>(false,"用户错误，请勿篡改页面");
		}
		
		return result;
	}


	@Override
	@Transactional
	public LoanResult<User> userImprove(String userId, UserInfo userInfo) {
		
		LoanResult<User> result;
		User user = userMapper.selectByPrimaryKey(userId);
		try{
			if(user!=null){
				String infoId = NumUtils.createId();
				userInfo.setId(infoId);
				Integer infoCount = userInfoMapper.insert(userInfo);
				if(infoCount!=0){
					user.setInfoId(infoId);
					Integer count = userMapper.updateByPrimaryKey(user);
					if(count!=0){
						result = new LoanResult<User>(true,user);
						//加入用户状态与权限
						result = userRoleAndState(result);
					}else{
						result = new LoanResult<>(false,"系统内部错误");
						throw new RuntimeException();
					}
				}else{
					result = new LoanResult<>(false,"系统内部错误");
				}
			}else{
				result = new LoanResult<>(false,"用户信息不存在，请重新登录");
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();//回滚
		}
		return result;
	}
	
	private LoanResult<User> userRoleAndState(LoanResult<User> userResult){
		
		User user = userResult.getData();
		//String roleId = NumUtils.createId();
		//UserRole userRole = new UserRole();
		String stateId = NumUtils.createId();
		UserState state = new UserState(stateId,(byte)0,(byte)0,(byte)0);
		Integer stateCount = userStateMapper.insert(state);
		if(stateCount!=0){
			user.setStateId(stateId);
			Integer count = userMapper.updateByPrimaryKey(user);
			if(count!=0){
				//TODO 用户权限构建
				createUserRoles(user.getId());
				userResult.setData(user);
			}else{
				userResult = new LoanResult<User>(false,"系统内部错误:用户状态加载异常");
			}
		}else{
			userResult = new LoanResult<User>(false,"系统内部错误:用户状态构建异常");
		}
		
		return userResult;
	}
	
	private void createUserRoles(String userId){
		List<TypeUserrole> typeUserroles = userRoleService.getAllTypeUserrole();//拿到所有权限类型
		for(TypeUserrole t:typeUserroles){
			UserRole userRole = new UserRole(NumUtils.createId(),1,userId,t.getId());
			LoanResult<UserRole> insertResult = userRoleService.addUsrRole(userRole);
			if(!insertResult.isSuccess){
				throw new RuntimeException("生成用户权限异常");
			}
		}
	}


	@Override
	public UserIntegration userIntegration(String id) {
		
		UserIntegration userIntegration = null;
		
		User user = userMapper.selectByPrimaryKey(id);
		
		UserInfo userInfo =  userInfoMapper.selectByPrimaryKey(user.getInfoId());
		UserState userState = userStateMapper.selectByPrimaryKey(user.getStateId());
		
		List<UserRole> roles = userRoleService.getUserRoleByUserId(id);
		System.out.println("size:"+roles.size());
		
		
		if(user.getSecureId()!=null){//用户已进行安全设置
			UserSecure userSecure = userSecureMapper.selectByPrimaryKey(user.getSecureId());
			userIntegration = new UserIntegration(user, userInfo,userSecure,userState);
		}else{//用户未进行安全设置
			userIntegration = new UserIntegration(user, userInfo,userState);
		}
		userIntegration.setUserRoles(roles);
		return userIntegration;
	}


	@Override
	public LoanResult<User> userLogin(String nameOrMail, String password) {
		
		LoanResult<User> result = null;
		
		//TODO 判断验证码
		
		result = loginByName(nameOrMail, password);
		if(result==null){
			result = loginByMail(nameOrMail,password);
			if(result==null){
				result = new LoanResult<User>(false,"用户/邮箱不存在");
			}
		}
		return result;
	}
	
	//以用户名登录
	private LoanResult<User> loginByName(String username,String password){
		
		User user = null;
		LoanResult<User> result = null;
		
		UserExample example = new UserExample();
		Criteria cri = example.createCriteria();
		cri.andUsernameEqualTo(username);
		List<User> users = userMapper.selectByExample(example);
		if(users.size()==1){//证明用户存在
			
			user = users.get(0);
			System.out.println(user);
			String salt = user.getSalt();
			String encodePassword = DigestUtils.md5DigestAsHex((salt+password).getBytes());
			if(encodePassword.equals(user.getPassword())){//登录成功
				result = new LoanResult<User>(true,user);
			}else{
				result = new LoanResult<>(false,"用户存在，但密码错误");
			}
		}
		
		return result;
	}
	
	//以邮箱登录
	private LoanResult<User> loginByMail(String usermail,String password){
		
		User user = null;
		LoanResult<User> result = null;
		
		UserExample example = new UserExample();
		Criteria cri = example.createCriteria();
		cri.andUsermailEqualTo(usermail);
		List<User> users = userMapper.selectByExample(example);
		if(users.size()==1){//证明用户存在
			
			user = users.get(0);
			System.out.println(user);
			String salt = user.getSalt();
			String encodePassword = DigestUtils.md5DigestAsHex((salt+password).getBytes());
			if(encodePassword.equals(user.getPassword())){//登录成功
				result = new LoanResult<User>(true,user);
			}else{
				result = new LoanResult<>(false,"邮箱存在，但密码错误");
			}
		}
		
		return result;
	}


	@Override
	public LoanResult<UserIntegration> userCheck(String name) {
		
		LoanResult<UserIntegration> result = null;
		
		UserExample example = new UserExample();
		Criteria cri = example.createCriteria();
		cri.andUsernameEqualTo(name);
		List<User> users = userMapper.selectByExample(example);
		
		if(users.size()!=0){
			String id = users.get(0).getId();
			UserIntegration userIntegration = userIntegration(id);//获取用户的所有数据
			
			byte freeze = userIntegration.getUserState().getIsFreeze();
			//判断用户状态
			if(freeze!=1){
				result = new LoanResult<>(true,userIntegration);
			}else{
				result = new LoanResult<>(false,"账户被冻结，请联系管理员");
			}
		}else{
			result = new LoanResult<>(false,"用户不存在");
		}
		
		return result;
	}


	@Override
	public LoanResult<User> ChangePass(String id, String password) {
		
		LoanResult<User> result = null;
		User user = userMapper.selectByPrimaryKey(id);
		if(user!=null){
			String salt = user.getSalt();
			String encodePassword = DigestUtils.md5DigestAsHex((salt+password).getBytes());
			user.setPassword(encodePassword);
			int count = userMapper.updateByPrimaryKey(user);
			if(count!=0){
				user = userMapper.selectByPrimaryKey(id);
				result = new LoanResult<User>(true,user);
			}else{
				result = new LoanResult<User>(false,"更改密码失败");
			}
		}else{
			result = new LoanResult<User>(false,"用户不存在，请勿篡改页面信息");
		}
		
		return result;
	}


	@Override
	@Transactional
	public LoanResult<UserIntegration> secureSet(UserIntegration userIntegration,UserSecure userSecure) {
		LoanResult<UserIntegration> result =null;
		
		UserSecure oldSecure = userIntegration.getUserSecure();
		try{
			if(oldSecure==null){//代表没有进行安全设置
				String secureId = NumUtils.createId();
				userSecure.setId(secureId);
				Integer userSecureResult =  userSecureMapper.insert(userSecure);
				if(userSecureResult!=0){
					userSecure.setCreateDate(new Date());
					userIntegration.setUserSecure(userSecure);
					User user = userIntegration.getUser();
					user.setSecureId(secureId);
					Integer userResult =  userMapper.updateByPrimaryKey(user);
					if(userResult!=0){//在user表加入安全对象
						userIntegration.setUser(user);
						//发消息推送
						Remind remind = new Remind((byte)1,(byte)0,user.getId(),"系统推送:安全设置新增成功");
						remindService.addRemindAndPush(remind);
						
						result = new LoanResult<UserIntegration>(true,userIntegration);
					}else{
						result = new LoanResult<UserIntegration>(false,"内部错误:用户更改失败");
					}
				}else{
					result = new LoanResult<UserIntegration>(false,"内部错误:新增安全设置失败");
				}
			}else{//代表已进行安全设置，是修改
				userSecure.setId(oldSecure.getId());
				Integer updateResult =  userSecureMapper.updateByPrimaryKeySelective(userSecure);
				if(updateResult!=0){
						UserSecure newSecure = userSecureMapper.selectByPrimaryKey(oldSecure.getId());
						userIntegration.setUserSecure(newSecure);
						result = new LoanResult<UserIntegration>(true,userIntegration);
						
						//发消息推送
						Remind remind = new Remind((byte)1,(byte)0,userIntegration.getUser().getId(),"系统推送:安全设置修改成功");
						remindService.addRemindAndPush(remind);
						
				}else{
					result = new LoanResult<UserIntegration>(false,"内部错误:更新安全设置失败");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();//运行时异常:业务回滚
		}

		return result;
	}


	@Override
	public LoanResult<UserIntegration> updateInfo(
			UserIntegration userIntegration, UserInfo newInfo) {
		
		LoanResult<UserIntegration> result =null;
		
		UserInfo oldInfo = userIntegration.getUserInfo();
		String infoId = oldInfo.getId();
		newInfo.setId(infoId);//设置要修改的用户id
		
		Integer count = userInfoMapper.updateByPrimaryKeySelective(newInfo);//只更新非空
		if(count!=0){
			//修改用户信息成功
			newInfo = userInfoMapper.selectByPrimaryKey(infoId);//获得用户信息的完整对象
			userIntegration.setUserInfo(newInfo);//更新用户整合
			result = new LoanResult<UserIntegration>(true,userIntegration);
			
			//发消息推送
			Remind remind = new Remind((byte)1,(byte)0,userIntegration.getUser().getId(),"系统推送:用户信息修改成功");
			remindService.addRemindAndPush(remind);
			
		}else{
			result = new LoanResult<UserIntegration>(false,"系统内部错误:修改信息失败");
		}
		
		return result;
	}


	@Override
	public LoanResult<UserIntegration> uploadLogo(
			UserIntegration userIntegration, MultipartFile file,String repository_src) {
		
		LoanResult<UserIntegration> result = null;
		
		if(!file.isEmpty()){
				
		
			   /*3.保存上传文件内容*/
				  //1.设置保存上传文件的路径
				  	//放服务器里
				  String realPathString_src = repository_src+"repository/userLogo"; //Tomcat项目下的路径
				  File fileuploadDir_src = new File(realPathString_src);
				  if(!fileuploadDir_src.exists()){
					  fileuploadDir_src.mkdirs();
				  }
				  
				  //2.设置文件路径
				  String user_account = userIntegration.getUser().getUsername();
				  String originalName =file.getOriginalFilename();
				  String fileNamePostfix = originalName.substring(originalName.lastIndexOf("."),originalName.length()); //获得上传文件的后缀
				  String uploadFileName = user_account+"Logo"+fileNamePostfix;
				  
				  
				  File saveFile_src = new File(fileuploadDir_src,uploadFileName);
				  
				  try {
					FileUtils.copyInputStreamToFile(file.getInputStream(),saveFile_src);
					System.out.println("文件上传成功！！");
				} catch (IOException e) {
					result = new LoanResult<UserIntegration>(false,"文件上传错误");
				}
				  
				  System.out.println("文件路径:"+saveFile_src.getAbsolutePath());
				  
				  
			   /*4.调用方法修改用户的user_pic字段*/
				  //String uploadLogoRtn = new UserService().updateLogo(user_account,uploadFileName);
				  System.out.println(uploadFileName);
				  System.out.println(fileuploadDir_src+"--"+uploadFileName);
			  
			  /*5.存到数据库*/
			  UserInfo userInfo = userIntegration.getUserInfo();
			  userInfo.setUserLogo("repository/userLogo/"+uploadFileName);
			  Integer count = userInfoMapper.updateByPrimaryKeySelective(userInfo);
			  if(count!=0){
				  result = new LoanResult<UserIntegration>(false,"修改数据库失败");
			  }else{
				  userIntegration.setUserInfo(userInfo);
				  result = new LoanResult<UserIntegration>(true,userIntegration);
			  }
		}else{
			result = new LoanResult<UserIntegration>(false,"上传文件不存在");
		}
	    return result;
	}


	@Override
	public LoanResult<UserIntegration> changePass_login(UserIntegration userIntegration, String oldPassword,
			String newPassword) {
		
		LoanResult<UserIntegration> result = null;
		User user = userIntegration.getUser();
		if(user!=null){
			String salt = user.getSalt();
			String oldEncodePassword = DigestUtils.md5DigestAsHex((salt+oldPassword).getBytes());
			if(oldEncodePassword.equals(user.getPassword())){
				String newEncodePassword = DigestUtils.md5DigestAsHex((salt+newPassword).getBytes());
				user.setPassword(newEncodePassword);
				int count = userMapper.updateByPrimaryKey(user);//更新密码
				if(count!=0){
					System.out.println("更改密码成功");
					userIntegration.setUser(user); //更新用户整合
					result = new LoanResult<UserIntegration>(true,userIntegration);
				}else{
					result = new LoanResult<UserIntegration>(false,"系统内部错误，更改密码失败");
				}
			}else{
				result = new LoanResult<UserIntegration>(false,"原密码错误，无法修改密码");
			}
		}else{
			result = new LoanResult<UserIntegration>(false,"用户信息错误，请勿篡改页面信息");
		}
		return result;
	}


	@Override
	@Transactional
	public LoanResult<UserIntegration> userCertification(UserIntegration userIntegration,MultipartFile file,
			String userIdentitynum, String userRealname,String path) {
		
		LoanResult<UserIntegration> result = null;
		
		List<UserInfo> userInfos = userInfoMapper.selectByUserRealnameOrUserIdentitynum(userRealname, userIdentitynum);
		
		if(userInfos.size()==0){
			if(!file.isEmpty()){
				String partName = "repository/certification";
				System.out.println("目录路径:"+path+partName);
				File dir = new File(path+partName);
				if(!dir.exists()){
					dir.mkdirs();
				}
				String originalName =file.getOriginalFilename();
				String postfix = originalName.substring(originalName.lastIndexOf("."),originalName.length()); //获得上传文件的后缀
				File tarFile = new File(dir,userIntegration.getUser().getUsername()+"IdentityPic"+postfix);
				try {
					FileUtils.copyInputStreamToFile(file.getInputStream(),tarFile);//上传目标文件
					System.out.println("文件上传成功！！");
					String filePath = partName+"/"+tarFile.getName();
					System.out.println("文件相对路径:"+filePath);
					System.out.println("文件绝对路径:"+tarFile.getAbsolutePath());
					//插入数据库
					UserInfo userInfo = userIntegration.getUserInfo();
					userInfo.setUserRealname(userRealname);
					userInfo.setUserIdentitynum(userIdentitynum);
					userInfo.setUserIdentitypic(filePath);
					Integer count = userInfoMapper.updateByPrimaryKey(userInfo);
					if(count!=0){
						userIntegration.setUserInfo(userInfo);
						//设置用户状态
						UserState userState = userIntegration.getUserState();
						userState.setIsCertification((byte)1);
						Integer stateCount = userStateMapper.updateByPrimaryKey(userState);
						if(stateCount!=0){
							userIntegration.setUserState(userState);
							result = new LoanResult<UserIntegration>(true,userIntegration);
						}else{
							result = new LoanResult<UserIntegration>(false,"实名认证失败:用户状态错误");
						}
					}else{
						result = new LoanResult<UserIntegration>(false,"实名认证失败:数据加入数据库出错");
					}
				} catch (IOException e) {
					result = new LoanResult<UserIntegration>(false,"实名认证失败:文件上传出错");
					e.printStackTrace();
				}
			}else{
				result = new LoanResult<UserIntegration>(false,"实名验证失败:身份证文件不能为空");
			}
		}else{
			result = new LoanResult<UserIntegration>(false,"实名验证失败:信息已被认证");
		}
		
		return result;
	}


	@Override
	public LoanResult<User> quesAnswerCheck(String id, String quesAnswer) {
		
		LoanResult<User> result = null;
		
		if(id!=null&&quesAnswer!=null){
			
			User user = userMapper.selectByPrimaryKey(id);
			if(user!=null){
				UserSecure userSecure = userSecureMapper.selectByPrimaryKey(user.getSecureId());
				String answer = userSecure.getSecureAnswer();
				if(answer.equals(quesAnswer)){
					result = new LoanResult<User>(true,user);
				}else{
					result = new LoanResult<User>(false,"安全问题答案错误");
				}
			}else{
				result = new LoanResult<User>(false,"用户不存在！请勿篡改页面数据");
			}
		}else{
			result = new LoanResult<User>(false,"数据不能为空");
		}
		
		return result;
	}


	@Override
	public User getUserById(String userId) {
		User user = userMapper.selectByPrimaryKey(userId);
		return user;
	}
}
