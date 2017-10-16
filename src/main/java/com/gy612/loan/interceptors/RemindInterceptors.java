package com.gy612.loan.interceptors;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.gy612.loan.dao.cache.CacheEntry;
import com.gy612.loan.dao.cache.RedisDao;
import com.gy612.loan.dto.UserIntegration;
import com.gy612.loan.entity.Remind;
import com.gy612.loan.service.RemindService;

public class RemindInterceptors implements HandlerInterceptor {
	
	@Autowired
	private RemindService remindService;
	
	@Autowired
	private RedisDao redisDao;

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		
		HttpSession session = request.getSession();
		UserIntegration userIntegration = (UserIntegration)session.getAttribute("user");
		if(userIntegration!=null){
			//TODO 存在redis中
			String userId = userIntegration.getUser().getId();
			
			String countKey = userId+"RemindCount";
			Integer count = redisDao.getRemindsCount(countKey);
			if(count==null){
				System.out.println("no cache,in sql");
				count = remindService.getCountByState(0, userId);//获得未查看的通知数
				redisDao.putRemindsCount(count, countKey);
			}
			
			String remindKey = userId+"Reminds";
			List<Remind> reminds = null;
			CacheEntry<Remind> ce = redisDao.getReminds(remindKey);
			if(ce==null){
				System.out.println("缓存没有");
				reminds = remindService.getRemindByState((byte)0, userId);
				ce = new CacheEntry<Remind>(reminds);
				redisDao.putReminds(ce,remindKey);
			}else{
				System.out.println("缓存拿出");
				reminds = ce.getData();
			}
			//reminds = remindService.getRemindByState((byte)0, userId);
			//System.out.println("size:"+reminds.size());
			
			request.setAttribute("unreadRemind",reminds);
			request.setAttribute("unreadRemindCount", count);
			System.out.println("未查看的通知数:"+count);
		}
		
		return true;
	}

}
