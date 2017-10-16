package com.gy612.loan.dto;

import com.gy612.loan.entity.User;
import com.gy612.loan.entity.UserInfo;

/**
 * 用户登录模块的json封装
 * @author K550J
 *
 */
public class LoginUserResult extends LoanResult<User> {
	
	private UserInfo userInfo;

	public LoginUserResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginUserResult(boolean isSuccess, String errorMessage) {
		super(isSuccess, errorMessage);
		// TODO Auto-generated constructor stub
	}

	public LoginUserResult(boolean isSuccess, User data) {
		super(isSuccess, data);
		// TODO Auto-generated constructor stub
	}
	
	public LoginUserResult(UserInfo userInfo) {
		super();
		this.userInfo = userInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	

}
