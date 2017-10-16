package com.gy612.loan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gy612.loan.dao.BorrowInfoMapper;
import com.gy612.loan.dao.BorrowMaterialMapper;
import com.gy612.loan.dto.LoanInfoAndMaterial;
import com.gy612.loan.entity.BorrowInfo;
import com.gy612.loan.entity.BorrowInfoExample;
import com.gy612.loan.entity.BorrowInfoExample.Criteria;
import com.gy612.loan.entity.BorrowMaterial;
import com.gy612.loan.service.BorrowService;

@Service("borrowService")
public class BorrowServiceImpl implements BorrowService {

	@Autowired
	private BorrowInfoMapper borrowInfoMapper;
	
	@Autowired
	private BorrowMaterialMapper borrowMaterialMapper;
	
	@Override
	public List<BorrowInfo> getBorrowInfoList(Integer pageNum, String userId) {
		
		BorrowInfoExample example = new BorrowInfoExample();
		Criteria cri = example.createCriteria();
		cri.andUserIdEqualTo(userId);
		
		List<BorrowInfo> result = borrowInfoMapper.selectByExample(example);
		
		return result;
		
	}

	@Override
	public LoanInfoAndMaterial<BorrowInfo, BorrowMaterial> getBorrowDetail(
			String borrowId) {
		// TODO Auto-generated method stub
		return null;
	}

}
