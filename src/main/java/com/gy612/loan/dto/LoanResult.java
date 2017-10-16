package com.gy612.loan.dto;

/**
 * 存放借贷系统 ajax json返回对象封装
 * 
 * @author K550J
 * 
 * @param <T>
 */
public class LoanResult<T> {
	
	//方法调用是否成功
	public boolean isSuccess;
	//数据
	public T data;
	//错误信息
	public String errorMessage;

	public LoanResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	//方法成功时调用
	public LoanResult(boolean isSuccess, T data) {
		super();
		this.isSuccess = isSuccess;
		this.data = data;
	}

	//方法失败时调用
	public LoanResult(boolean isSuccess, String errorMessage) {
		super();
		this.isSuccess = isSuccess;
		this.errorMessage = errorMessage;
	}
	
	//T为String时用
	public LoanResult(boolean isSuccess, T data, String errorMessage) {
		super();
		this.isSuccess = isSuccess;
		this.data = data;
		this.errorMessage = errorMessage;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "LoanResult [isSuccess=" + isSuccess + ", data=" + data
				+ ", errorMessage=" + errorMessage + "]";
	}
	
	

}
