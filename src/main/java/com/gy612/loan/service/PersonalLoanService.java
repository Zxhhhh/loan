package com.gy612.loan.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.gy612.loan.dto.LoanInfoAndMaterial;
import com.gy612.loan.dto.LoanResult;
import com.gy612.loan.dto.UserIntegration;
import com.gy612.loan.entity.PersonalLoanInfo;
import com.gy612.loan.entity.PersonalLoanMaterial;

/**
 * 个人贷款 service
 * @author K550J
 *
 */
public interface PersonalLoanService {
	
	/**
	 * 获取所有个人贷款
	 * @return
	 */
	public List<PersonalLoanInfo> getAllPersonalLoanInfo();
	
	public List<PersonalLoanInfo> getPersonalLoanInfoByIsRepay(byte isRepay);
	
	
	/**
	 * 获取个人贷款列表
	 * @param pageNum
	 * @param userId
	 * @return
	 */
	public List<PersonalLoanInfo> getPersonalLoanInfoList(Integer pageNum,String userId);
	
	/**
	 * 获取个人贷款详细
	 * @param personalLoanId
	 * @return
	 */
	public LoanInfoAndMaterial<PersonalLoanInfo,PersonalLoanMaterial> getPersonalLoanDetail(String personalLoanId);
	
	/**
	 * 在保存个人贷款信息前检查
	 * @return
	 */
	public LoanResult<PersonalLoanInfo> checkPersonalLoanInfo(PersonalLoanInfo personalLoanInfo,UserIntegration userIntegration);
	
	/**
	 * 新增个人贷款
	 * @return
	 */
	public LoanResult<PersonalLoanInfo> addPersonalLoan(MultipartFile materialPersonal,MultipartFile materialMortgage,String path,PersonalLoanInfo personalLoanInfo,UserIntegration userIntegration);
	
	/**
	 * 撤回个人贷款申请(删除未被审核的个人贷款)
	 * @param personalLoanInfoId
	 * @return
	 */
	public LoanResult<String> deletePersonLoan(String personalLoanInfoId);
	
	/**
	 * 个人贷款还款
	 * @param personalLoanInfoId
	 * @return
	 */
	public LoanResult<String> repayPersonalLoan(String personalLoanInfoId);
	
	/**
	 * 个人贷款领款
	 * @param personalLoanInfoId
	 * @return
	 */
	public LoanResult<String> takemoneyPersonalLoan(String personalLoanInfoId);
	
}
