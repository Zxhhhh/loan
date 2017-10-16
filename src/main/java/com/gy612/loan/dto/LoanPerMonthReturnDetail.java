package com.gy612.loan.dto;

/**
 * 每月贷款还款详细
 * @author K550J
 *
 */
public class LoanPerMonthReturnDetail {
	
	private Integer month;//月份
	private Double principalInterest;//月份本息和
	private Double principal;//月份每月本金
	private Double interest;//月份利息
	
	public LoanPerMonthReturnDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoanPerMonthReturnDetail(Integer month, Double principalInterest,
			Double principal, Double interest) {
		super();
		this.month = month;
		this.principalInterest = principalInterest;
		this.principal = principal;
		this.interest = interest;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Double getPrincipalInterest() {
		return principalInterest;
	}

	public void setPrincipalInterest(Double principalInterest) {
		this.principalInterest = principalInterest;
	}

	public Double getPrincipal() {
		return principal;
	}

	public void setPrincipal(Double principal) {
		this.principal = principal;
	}

	public Double getInterest() {
		return interest;
	}

	public void setInterest(Double interest) {
		this.interest = interest;
	}

}
