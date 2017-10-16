package com.gy612.loan.service;

import java.util.List;

import com.gy612.loan.dto.LoanResult;
import com.gy612.loan.entity.TypeUserrole;
import com.gy612.loan.entity.UserRole;

/**
 * 用户权限 service 
 * @author K550J
 *
 */
public interface UserRoleService {
	
	public List<UserRole> getUserRoleByUserId(String userId);
	
	public List<TypeUserrole> getAllTypeUserrole();

	public LoanResult<UserRole> addUsrRole(UserRole userRole);
	
}
