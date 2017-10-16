package com.gy612.loan.dto;

import com.gy612.loan.entity.User;

/**
 * 用户注册模块的json封装
 * @author K550J
 *
 */
public class RegisterUserResult extends LoanResult<User> {
	
	//邮箱验证码
	private Integer mailCheckCode;
	
	//目标邮箱地址
	private String targetMailUrl;

	public RegisterUserResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegisterUserResult(boolean isSuccess, String errorMessage) {
		super(isSuccess, errorMessage);
		// TODO Auto-generated constructor stub
	}

	public RegisterUserResult(boolean isSuccess, User data) {
		super(isSuccess, data);
		// TODO Auto-generated constructor stub
	}

	public RegisterUserResult(Integer mailCheckCode, String targetMailUrl) {
		super();
		this.mailCheckCode = mailCheckCode;
		this.targetMailUrl = targetMailUrl;
	}

	public Integer getMailCheckCode() {
		return mailCheckCode;
	}

	public void setMailCheckCode(Integer mailCheckCode) {
		this.mailCheckCode = mailCheckCode;
	}

	public String getTargetMailUrl() {
		return targetMailUrl;
	}

	public void setTargetMailUrl(String targetMailUrl) {
		this.targetMailUrl = targetMailUrl;
	}
	
	

}
