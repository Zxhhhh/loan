
package com.gy612.loan.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.gy612.loan.dto.LoanResult;
import com.gy612.loan.dto.RegisterUserResult;
import com.gy612.loan.dto.UserIntegration;
import com.gy612.loan.entity.BorrowInfo;
import com.gy612.loan.entity.CompanyLoanInfo;
import com.gy612.loan.entity.PersonalLoanInfo;
import com.gy612.loan.entity.User;
import com.gy612.loan.entity.UserExample;
import com.gy612.loan.entity.UserInfo;
import com.gy612.loan.entity.UserSecure;

/**
 * 用户 service 
 * @author K550J
 *
 */
public interface UserService {
	
	/**
	 * 根据example
	 * @param example
	 * @return
	 */
	public List<User> selectByExample(UserExample example);
	
    /**
     * 新增用户信息
     * 并返回新增的用户对象
     * @param username
     * @param passwordAfterEncode
     * @return
     */
	public RegisterUserResult userRegister(String username,String passwordAfterEncode,String userMail);
	
	
	/**
	 * 用户登录
	 * @param nameOrMail
	 * @param password
	 * @return
	 */
	public LoanResult<User> userLogin(String nameOrMail,String password);
	
	/**
	 * 激活用户
	 * @param id
	 * @param inputCode
	 * @param correctCode
	 * @return
	 */
	public LoanResult<User> userActivity(String id);
	
	/**
	 * 用户完善
	 * @param userId
	 * @param userInfo
	 * @return
	 */
	public LoanResult<User> userImprove(String userId,UserInfo userInfo);
	
	/**
	 * 整合用户
	 * @param id
	 * @return
	 */
	public UserIntegration userIntegration(String id);
	
	/**
	 * 通过用户名检查用户状态
	 * @param name
	 * @return
	 */
	public LoanResult<UserIntegration> userCheck(String name);
	
	/**
	 * 更改用户密码(忘记密码状态下)
	 * @return
	 */
	public LoanResult<User> ChangePass(String id,String password);
	
	/**
	 * 更改用户密码(登录状态下)
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	public LoanResult<UserIntegration> changePass_login(UserIntegration userIntegration, String oldPassword,
			String newPassword);
	
	/**
	 * 用户安全设置
	 * @param user
	 * @param userSecure
	 * @return
	 */
	public LoanResult<UserIntegration> secureSet(UserIntegration userIntegration,UserSecure userSecure);
	
	/**
	 * 修改用户信息
	 * @param userIntegration
	 * @param userInfo
	 * @return
	 */
	public LoanResult<UserIntegration> updateInfo(UserIntegration userIntegration,UserInfo userInfo);
	
	/**
	 * 上传用户头像
	 * @param userIntegration
	 * @param input
	 * @return
	 */
	public LoanResult<UserIntegration> uploadLogo(UserIntegration userIntegration,MultipartFile file,String repository_src);
	
	/**
	 * 用户实名认证
	 * @param file
	 * @param userIdentitynum
	 * @param userRealname
	 * @return
	 */
	public LoanResult<UserIntegration> userCertification(UserIntegration userIntegration,MultipartFile file,String userIdentitynum,String userRealname,String path);
	
	/**
	 * 安全问题答案检查
	 * @param id
	 * @param quesAnswer
	 * @return
	 */
	public LoanResult<User> quesAnswerCheck(String id,String quesAnswer);
	
	public  User getUserById(String userId);

}
