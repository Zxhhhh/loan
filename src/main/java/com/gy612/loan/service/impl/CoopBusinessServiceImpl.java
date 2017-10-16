package com.gy612.loan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gy612.loan.dao.CoopBusinessMapper;
import com.gy612.loan.entity.CoopBusiness;
import com.gy612.loan.entity.CoopBusinessExample;
import com.gy612.loan.service.CoopBusinessService;

@Service("coopBusinessService")
public class CoopBusinessServiceImpl implements CoopBusinessService {

	@Autowired
	private CoopBusinessMapper coopBusinessMapper;
	
	@Override
	public List<CoopBusiness> selectByExample(CoopBusinessExample example) {
		return coopBusinessMapper.selectByExample(example);
	}

}
