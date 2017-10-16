package com.gy612.loan.dto;

import java.util.List;

/**
 * 贷款还款详细
 * @author K550J
 *
 */
public class LoanReturnDetail {
	
	private Double yearRate;//年利率
	private Double invest;//本金
	private Double interestCount; //总利息
	private Double returnInvest;//应还款
	private List<LoanPerMonthReturnDetail> details;//每月详细
	
	public LoanReturnDetail(Double yearRate, Double invest,
			Double interestCount, List<LoanPerMonthReturnDetail> details) {
		super();
		this.yearRate = yearRate;
		this.invest = invest;
		this.interestCount = interestCount;
		this.details = details;
	}
	
	public Double getInvest() {
		return invest;
	}
	public void setInvest(Double invest) {
		this.invest = invest;
	}
	public Double getInterestCount() {
		return interestCount;
	}
	public void setInterestCount(Double interestCount) {
		this.interestCount = interestCount;
	}
	public Double getReturnInvest() {
		return returnInvest;
	}
	public void setReturnInvest(Double returnInvest) {
		this.returnInvest = returnInvest;
	}
	public List<LoanPerMonthReturnDetail> getDetails() {
		return details;
	}
	public void setDetails(List<LoanPerMonthReturnDetail> details) {
		this.details = details;
	}

	public Double getYearRate() {
		return yearRate;
	}

	public void setYearRate(Double yearRate) {
		this.yearRate = yearRate;
	}

}
