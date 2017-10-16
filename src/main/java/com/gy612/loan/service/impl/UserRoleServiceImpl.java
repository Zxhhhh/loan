package com.gy612.loan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gy612.loan.dao.TypeUserroleMapper;
import com.gy612.loan.dao.UserMapper;
import com.gy612.loan.dao.UserRoleMapper;
import com.gy612.loan.dto.LoanResult;
import com.gy612.loan.entity.TypeUserrole;
import com.gy612.loan.entity.TypeUserroleExample;
import com.gy612.loan.entity.UserRole;
import com.gy612.loan.entity.UserRoleExample;
import com.gy612.loan.entity.UserRoleExample.Criteria;
import com.gy612.loan.service.UserRoleService;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	@Autowired
	private TypeUserroleMapper typeUserroleMapper;
	

	@Override
	public List<UserRole> getUserRoleByUserId(String userId) {
		
		UserRoleExample example = new UserRoleExample();
		Criteria cri = example.createCriteria();
		cri.andUserIdEqualTo(userId);
		
		List<UserRole> result = userRoleMapper.selectByExample(example);
		
		
		return result;
	}


	@Override
	public List<TypeUserrole> getAllTypeUserrole() {
		return typeUserroleMapper.selectByExample(new TypeUserroleExample());
	}


	@Override
	@Transactional
	public LoanResult<UserRole> addUsrRole(UserRole userRole) {
		LoanResult<UserRole> result = null;
		try{
			if(userRole!=null){
				Integer count = userRoleMapper.insert(userRole);
				if(count!=0){
					result = new LoanResult<UserRole>(true,userRole);
				}else{
					result = new LoanResult<UserRole>(false,"数据库错误:插入异常");
				}
			}else{
				result = new LoanResult<UserRole>(false,"非法数据 :数据为空");
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return result;
	}

}
