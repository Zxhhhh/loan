package com.gy612.loan.service;

import java.util.List;

import com.gy612.loan.dto.LoanResult;
import com.gy612.loan.dto.UserIntegration;
import com.gy612.loan.entity.Feedback;

/**
 * 意见反馈 service
 * @author K550J
 *
 */
public interface FeedbackService {
	
	/**
	 * 新增反馈
	 * @param feedback
	 * @return
	 */
	public LoanResult<Feedback> addFeedback(Feedback feedback,UserIntegration userIntegration);

	/**
	 * 获取一个用户的所有反馈信息
	 * @param userId
	 * @return
	 */
	public List<Feedback> getUserFeedbacks(Integer pageNum,String userId,String check,String repay);
	
	public List<Feedback> getFeedbacksByUserId(String userId);
}
