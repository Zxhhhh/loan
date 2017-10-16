package com.gy612.loan.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gy612.loan.entity.Remind;
import com.gy612.loan.service.RemindService;
import com.gy612.loan.utils.DwrPush;

/**
 * 系统定时推送
 * @author K550J
 *
 */
@Component
public class SystemTask {
	
	@Autowired
	private RemindService remindService;
	
	public void system(){
		
		DwrPush.FeedbackSend("user","各位用户早上好");
		
	}

}
