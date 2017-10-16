package com.gy612.loan.service;

import java.util.List;

import com.gy612.loan.entity.CoopBusiness;
import com.gy612.loan.entity.CoopBusinessExample;

public interface CoopBusinessService {
	
	/**
	 * 通过example查询合作公司
	 * @param example
	 * @return
	 */
	public List<CoopBusiness> selectByExample(CoopBusinessExample example);
	

}
