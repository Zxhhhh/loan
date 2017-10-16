package com.gy612.loan.service;

import java.util.List;

import com.gy612.loan.dto.LoanInfoAndMaterial;
import com.gy612.loan.entity.BorrowInfo;
import com.gy612.loan.entity.BorrowMaterial;

/**
 * 借钱 service
 * @author K550J
 *
 */
public interface BorrowService {
	
	/**
	 * 获取借钱信息
	 * @param pageNum
	 * @param userId
	 * @return
	 */
	public List<BorrowInfo> getBorrowInfoList(Integer pageNum,String userId);
	
	/**
	 * 获取借钱详细
	 * @param borrowId
	 * @return
	 */
	public LoanInfoAndMaterial<BorrowInfo,BorrowMaterial> getBorrowDetail(String borrowId);

}
