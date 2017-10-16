package com.gy612.loan.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.gy612.loan.dto.LoanInfoAndMaterial;
import com.gy612.loan.dto.LoanResult;
import com.gy612.loan.dto.UserIntegration;
import com.gy612.loan.entity.CompanyLoanInfo;
import com.gy612.loan.entity.CompanyLoanMaterial;

/**
 * 企业贷款 service 
 * @author K550J
 *
 */
public interface CompanyLoanService {
	
	
	public List<CompanyLoanInfo> getCompanyLoanInfoByIsRepay(byte isRepay);
	
	/**
	 * 获取企业贷款列表
	 * @param pageNum
	 * @param userId
	 * @return
	 */
	public List<CompanyLoanInfo> getCompanyLoanInfoList(Integer pageNum,String userId);

	/**
	 * 获取企业贷款详细
	 * @param companyLoanId
	 * @return
	 */
	public LoanInfoAndMaterial<CompanyLoanInfo,CompanyLoanMaterial> getCompanyLoanDetail(String companyLoanId);
	
	/**
	 * 在保存企业贷款信息前检查
	 * @return
	 */
	public LoanResult<CompanyLoanInfo> checkCompanyLoanInfo(CompanyLoanInfo companyLoanInfo,UserIntegration userIntegration);
	
	/**
	 * 新增企业贷款
	 * @return
	 */
	public LoanResult<CompanyLoanInfo> addCompanyLoan(MultipartFile materialAptitude,MultipartFile materialMortgage,String path,CompanyLoanInfo companyLoanInfo,UserIntegration userIntegration);
	
	/**
	 * 撤回企业贷款申请(删除未被审核的个人贷款)
	 * @param CompanyLoanInfoId
	 * @return
	 */
	public LoanResult<String> deleteCompanyLoan(String companyLoanInfoId);
	
	/**
	 * 企业贷款还款
	 * @param CompanyLoanInfoId
	 * @return
	 */
	public LoanResult<String> repayCompanyLoan(String companyLoanInfoId);
	
}
