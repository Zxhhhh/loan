package com.gy612.loan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.gy612.loan.dao.RemindMapper;
import com.gy612.loan.dao.UserMapper;
import com.gy612.loan.dao.cache.CacheEntry;
import com.gy612.loan.dao.cache.RedisDao;
import com.gy612.loan.dto.LoanResult;
import com.gy612.loan.entity.Remind;
import com.gy612.loan.entity.RemindExample;
import com.gy612.loan.entity.RemindExample.Criteria;
import com.gy612.loan.entity.User;
import com.gy612.loan.service.RemindService;
import com.gy612.loan.service.UserService;
import com.gy612.loan.utils.DwrPush;
import com.gy612.loan.utils.NumUtils;
import com.gy612.loan.utils.PageSizeUtils;

@Service("remindService")
public class RemindServiceImpl implements RemindService {
	
	@Autowired
	private RemindMapper remindMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RedisDao redisDao;

	@Override
	public List<Remind> getRemindList(Integer pageNum,String userId, String remindType,
			String remindState) {
		
		List<Remind> result = null;
		
		RemindExample example = new RemindExample();
		Criteria cri = example.createCriteria();
		cri.andUserIdEqualTo(userId);
		if(remindType!=null&&!"".equals(remindType)){
			cri.andRemindTypeEqualTo(Byte.valueOf(remindType));
		}
		if(remindState!=null&&!"".equals(remindState)){
			cri.andRemindStateEqualTo(Byte.valueOf(remindState));
		}
		PageHelper.startPage(pageNum,PageSizeUtils.PAGE_SIZE);
		result = remindMapper.selectByExample(example);
		
		return result;
	}

	@Override
	@Transactional
	public LoanResult<Remind> changeRemindState(String remindId, String way) {
		
		LoanResult<Remind> result = null;
		
		Remind remind = remindMapper.selectByPrimaryKey(remindId);
		if(remind.getRemindState()==0){
			updateReidsOfRemindCount(remind.getUserId(),-1);//改变了状态，缓存要对应减少
		}
		if(remind!=null){
			if("Y".equals(way)){
				remind.setRemindState((byte)1);//设置为已读
			}else if("N".equals(way)){
				remind.setRemindState((byte)0);//设置为未读
			}
			Integer count = remindMapper.updateByPrimaryKeySelective(remind);
			if(count!=0){
				result =  new LoanResult<Remind>(true,remind);
				updateRedisReminds(remind.getUserId());//更新缓存列表
			}else{
				result = new LoanResult<Remind>(false,"更新失败");
			}
		}
		
		return result;
	}

	@Override
	@Transactional
	public LoanResult<Remind> addRemind(Remind remind) {
		
		LoanResult<Remind> result = null;
		
		if(remind!=null){
			String remindId = NumUtils.createId();
			remind.setId(remindId);
			Integer count = remindMapper.insert(remind);
			if(count!=0){
				remind = remindMapper.selectByPrimaryKey(remindId);	
				result = new LoanResult<Remind>(true,remind);
							
				//更改缓存
				updateReidsOfRemindCount(remind.getUserId(),1);
				updateRedisReminds(remind.getUserId());//更新缓存列表
				
			}else{
				result = new LoanResult<Remind>(false,"错误:消息插入错误");
			}
		}else{
			result = new LoanResult<Remind>(false,"错误:非法参数");
		}
		
		return result;
	}

	@Override
	public List<Remind> getRemindByState(byte remindState, String userId) {
		
		RemindExample example = new RemindExample();
		Criteria cri =example.createCriteria();
		cri.andRemindStateEqualTo(remindState);
		cri.andUserIdEqualTo(userId);
		
		List<Remind> reminds = remindMapper.selectByExample(example);
		
		return reminds;
	}

	@Override
	public Integer getCountByState(Integer remindState, String userId) {
		
		Integer count = remindMapper.countByRemindState(remindState, userId);
		
		return count;
	}

	@Override
	public LoanResult<Remind> addRemindAndPush(Remind remind) {
		LoanResult<Remind> result = null;
		
		if(remind!=null){
			String remindId = NumUtils.createId();
			remind.setId(remindId);
			Integer count = remindMapper.insert(remind);
			if(count!=0){
				remind = remindMapper.selectByPrimaryKey(remindId);
				
				//推送
				String userId = remind.getUserId();
				if(userId!=null){
					User user = userMapper.selectByPrimaryKey(userId);
					DwrPush.ServerSend(user.getUsername(),remind.getRemindContent());
				}
				
				//更改缓存
				updateReidsOfRemindCount(remind.getUserId(),1);
				updateRedisReminds(remind.getUserId());//更新缓存列表
				
				
				result = new LoanResult<Remind>(true,remind);
			}else{
				result = new LoanResult<Remind>(false,"错误:消息插入错误");
			}
		}else{
			result = new LoanResult<Remind>(false,"错误:非法参数");
		}
		return result;
	}
	
	/**
	 * 更改缓存:未阅读的消息数量
	 * @param userId
	 * @param num
	 */
	private void updateReidsOfRemindCount(String userId,Integer num){
		System.out.println("更改缓存！！！！");
		String countKey =  userId+"RemindCount";
		Integer remindCount = redisDao.getRemindsCount(countKey);
		if(remindCount==null){
			remindCount = remindMapper.countByRemindState(0,countKey);
		}
		redisDao.putRemindsCount(remindCount+num,countKey);
	}
	
	/***
	 * 更改缓存:未阅读的消息列表
	 * @param userId
	 */
	private void updateRedisReminds(String userId){
		String remindKey = userId+"Reminds";
		List<Remind> reminds = getRemindByState((byte)0, userId);
		CacheEntry<Remind> ce = new CacheEntry<>(reminds);
		redisDao.putReminds(ce,remindKey);
	}

	@Override
	public List<Remind> getRemindsByUserId(String userId) {

		RemindExample example = new RemindExample();
		Criteria cri =example.createCriteria();
		cri.andUserIdEqualTo(userId);
		
		List<Remind> reminds = remindMapper.selectByExample(example);
		
		return reminds;
	}

}
