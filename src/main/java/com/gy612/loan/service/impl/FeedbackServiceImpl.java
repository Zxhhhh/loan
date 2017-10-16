package com.gy612.loan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.gy612.loan.dao.FeedbackMapper;
import com.gy612.loan.dto.LoanResult;
import com.gy612.loan.dto.UserIntegration;
import com.gy612.loan.entity.Feedback;
import com.gy612.loan.entity.FeedbackExample;
import com.gy612.loan.entity.FeedbackExample.Criteria;
import com.gy612.loan.service.FeedbackService;
import com.gy612.loan.utils.NumUtils;

@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService {
	
	@Autowired
	private FeedbackMapper feedbackMapper;

	@Override
	public LoanResult<Feedback> addFeedback(Feedback feedback,UserIntegration userIntegration) {
		
		LoanResult<Feedback> result = null;
		
		if(feedback!=null){
			String userId = userIntegration.getUser().getId();
			String id = NumUtils.createId();
			feedback.setId(id);
			feedback.setUserId(userId);
			feedback.setFeedbackState((byte)0);
			Integer count = feedbackMapper.insert(feedback);
			if(count!=0){
				byte freeze = userIntegration.getUserState().getIsFreeze();
				//判断用户状态
				if(freeze!=1){	
					result = new LoanResult<>(true,feedback);
				}else{
					result = new LoanResult<>(false,"账户被屏蔽无法反馈信息，请联系管理员");
				}
			}else{
				result = new LoanResult<>(false,"内部错误:数据库插入失败");
			}
		}else{
			result = new LoanResult<>(false,"发送信息错误");
		}
		return result;
	}

	@Override
	public List<Feedback> getUserFeedbacks(Integer pageNum,String userId,String check,String repay) {
		
		List<Feedback> result = null;
		
		if(userId!=null){
			
			FeedbackExample example = new FeedbackExample();
			Criteria cri = example.createCriteria();
			cri.andUserIdEqualTo(userId);
			if(check!=null){
				if("1".equals(check)){
					cri.andFeedbackStateEqualTo((byte)1);
				}else if("2".equals(check)){
					cri.andFeedbackStateEqualTo((byte)2);
				}
			}else{
				if(repay!=null){
					if("1".equals(repay)){
						cri.andFeedbackStateNotEqualTo((byte)0);
					}else if("2".equals(repay)){
						cri.andFeedbackStateEqualTo((byte)0);
					}
				}
			}
			PageHelper.startPage(pageNum,8);
			result = feedbackMapper.selectByExample(example);
		}
		
		return result;
	}

	@Override
	public List<Feedback> getFeedbacksByUserId(String userId) {
		
		FeedbackExample example = new FeedbackExample();
		Criteria cri = example.createCriteria();
		cri.andUserIdEqualTo(userId);
		
		return feedbackMapper.selectByExample(example);
	}

}
