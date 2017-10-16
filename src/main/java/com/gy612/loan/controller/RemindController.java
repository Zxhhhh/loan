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
import com.gy612.loan.entity.Remind;
import com.gy612.loan.service.RemindService;

/**
 * 消息推送 controller
 * @author K550J
 *
 */
@RequestMapping("/remind")
@Controller
public class RemindController {
	
	@Autowired
	private RemindService remindService;
	
	/**
	 * 获取消息列表
	 * @param session
	 * @param remindType
	 * @param remindState
	 * @param model
	 * @return
	 */
	@RequestMapping("{pageNum}/getRemindList")
	public String getRemindList(@PathVariable("pageNum")Integer pageNum,HttpSession session,String remindType,String remindState,Model model){
		
		if(pageNum==null){
			pageNum = 1;
		}
		
		model.addAttribute("remindType",remindType);
		model.addAttribute("remindState",remindState);
		
		UserIntegration userIntegration = (UserIntegration)session.getAttribute("user");
		String userId = userIntegration.getUser().getId();
		List<Remind> result = remindService.getRemindList(pageNum,userId, remindType, remindState);
		PageInfo<Remind> pageInfo = new PageInfo<Remind>(result);
		model.addAttribute("reminds",result);
		model.addAttribute("remindsPageInfo",pageInfo);
		
		return "remindList";
	}
	
	/**
	 * 更改消息状态
	 * @param remindId
	 * @return
	 */
	@RequestMapping(value="{remindId}/{way}/remindStateChange",method=RequestMethod.POST,produces={"application/json;charset=utf-8"})
	@ResponseBody
	public LoanResult<Remind> remindStateChange(@PathVariable("remindId")String remindId,@PathVariable("way")String way){
		LoanResult<Remind> result = null;
		if((!"N".equals(way))||(!"Y".equals(way))){
			result = remindService.changeRemindState(remindId, way);
		}else{
			result = new LoanResult<Remind>(false,"状态更改方向不明确，操作失败!");
		}
		return result;
	}

}
