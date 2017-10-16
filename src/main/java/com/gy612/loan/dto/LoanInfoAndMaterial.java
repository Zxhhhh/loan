package com.gy612.loan.dto;

import com.gy612.loan.entity.CompanyLoanInfo;

/**
 * 贷款信息，材料封装
 * @author K550J
 *
 * @param <I>
 * @param <M>
 */
public class LoanInfoAndMaterial<I,M> {

	private I info;
	private M material;
	
	public LoanInfoAndMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoanInfoAndMaterial(I info, M material) {
		super();
		this.info = info;
		this.material = material;
	}

	public I getInfo() {
		return info;
	}

	public void setInfo(I info) {
		this.info = info;
	}

	public M getMaterial() {
		return material;
	}

	public void setMaterial(M material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "LoanInfoAndMaterial [info=" + info + ", material=" + material
				+ "]";
	}

	
}
