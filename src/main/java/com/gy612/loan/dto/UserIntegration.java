package com.gy612.loan.dto;

import java.util.List;

import com.gy612.loan.entity.User;
import com.gy612.loan.entity.UserInfo;
import com.gy612.loan.entity.UserRole;
import com.gy612.loan.entity.UserSecure;
import com.gy612.loan.entity.UserState;

/**
 * 用户 信息整合
 * 
 * @author K550J
 * 
 */
public class UserIntegration {

	private User user;
	private UserInfo userInfo;
	private List<UserRole> userRoles;
	private UserSecure userSecure;
	private UserState userState;

	public UserIntegration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserIntegration(User user, UserInfo userInfo,
			List<UserRole> userRoles, UserSecure userSecure, UserState userState) {
		super();
		this.user = user;
		this.userInfo = userInfo;
		this.userRoles = userRoles;
		this.userSecure = userSecure;
		this.userState = userState;
	}

	public UserIntegration(User user, UserInfo userInfo, UserSecure userSecure,
			UserState userState) {
		super();
		this.user = user;
		this.userInfo = userInfo;
		this.userSecure = userSecure;
		this.userState = userState;
	}

	public UserIntegration(User user, UserInfo userInfo, UserState userState) {
		super();
		this.user = user;
		this.userInfo = userInfo;
		this.userState = userState;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserSecure getUserSecure() {
		return userSecure;
	}

	public void setUserSecure(UserSecure userSecure) {
		this.userSecure = userSecure;
	}

	public UserState getUserState() {
		return userState;
	}

	public void setUserState(UserState userState) {
		this.userState = userState;
	}
}
