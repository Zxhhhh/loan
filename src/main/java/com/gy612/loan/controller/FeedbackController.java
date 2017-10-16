package com.gy612.loan.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.gy612.loan.dto.LoanResult;
import com.gy612.loan.dto.UserIntegration;
import com.gy612.loan.entity.Feedback;
import com.gy612.loan.service.FeedbackService;

/**
 * 反馈意见 controller
 * @author K550J
 *
 */
@Controller
@RequestMapping("/feedback")
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	/**
	 * 新增意见反馈
	 * @param feedback
	 * @return
	 */
	@RequestMapping(value="addFeedback",method=RequestMethod.POST,produces={"application/json;charset=utf-8"})
	@ResponseBody
	public LoanResult<Feedback> addFeedback(Feedback feedback,HttpSession session){
		
		/*新增意见反馈
		 * 1.接收反馈参数
		 * 2.获取用户信息并把信息保存至数据库
		 * 3.保存无误后进行在线推送
		 */
		
		System.out.println("in method");
		UserIntegration userIntegration = (UserIntegration)session.getAttribute("user");
		LoanResult<Feedback> result = null;
		result = feedbackService.addFeedback(feedback, userIntegration);
		return result;
	}
	
	/**
	 * 获取用户的反馈消息
	 * @param model
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="{pageNum}/getUserFeedbacks")
	public String getUserFeedbacks(@PathVariable("pageNum")Integer pageNum,Model model,HttpSession session,String check,String repay){
		
		if(pageNum==null){
			pageNum = 1;
		}
		
		model.addAttribute("check",check);
		model.addAttribute("repay",repay);
		
		String userId = ((UserIntegration)session.getAttribute("user")).getUser().getId();
		List<Feedback> result = feedbackService.getUserFeedbacks(pageNum,userId,check,repay);
		PageInfo<Feedback> pageInfo = new PageInfo<Feedback>(result);
		System.out.println("size:"+result.size());
			model.addAttribute("feedbacks",result);
			model.addAttribute("feedbacksPageInfo",pageInfo);
			return "feedbackList";
			
	}

}
