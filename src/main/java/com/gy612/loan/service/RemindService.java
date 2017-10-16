package com.gy612.loan.service;

import java.util.List;

import com.gy612.loan.dto.LoanResult;
import com.gy612.loan.entity.Remind;

/**
 * 消息推送 service
 * @author K550J
 *
 */
public interface RemindService {

	/**
	 * 获取消息推送列表
	 * @param userId
	 * @param remindType
	 * @param remindState
	 * @return
	 */
	public List<Remind> getRemindList(Integer pageNum,String userId,String remindType,String remindState);

	/**
	 * 更改消息状态
	 * @param remindId
	 * @param way
	 * @return
	 */
	public LoanResult<Remind> changeRemindState(String remindId,String way);
	
	/**
	 * 新增消息
	 * @param remind
	 * @return
	 */
	public LoanResult<Remind> addRemind(Remind remind);
	
	/**
	 * 新增消息且推送
	 * @param remind
	 * @return
	 */
	public LoanResult<Remind> addRemindAndPush(Remind remind);
	
	public List<Remind> getRemindsByUserId(String userId);
	
	
	public List<Remind> getRemindByState(byte remindState,String userId);
	
	public Integer getCountByState(Integer remindState,String userId);
}
