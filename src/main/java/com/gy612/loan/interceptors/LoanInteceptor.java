package com.gy612.loan.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.gy612.loan.dto.UserIntegration;

/**
 * 借贷拦截器
 * @author K550J
 *
 */
public class LoanInteceptor implements HandlerInterceptor {

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
		
		System.out.println("借贷拦截");
		UserIntegration userIntegration = (UserIntegration)session.getAttribute("user");
		if(userIntegration!=null){
			String realname = userIntegration.getUserInfo().getUserRealname();
			String identity = userIntegration.getUserInfo().getUserIdentitynum();
			if(realname!=null&&identity!=null){
				request.setAttribute("userId",userIntegration.getUser().getId());///页面用这个字段，防止账号有其他地方登录
				return true;
			}else{
				//se.setAttribute("error","未进行实名验证，无法贷款");
				response.sendRedirect("/loan/index/toIndex");
				return false;
			}
		}else{
			response.sendRedirect("/loan/user/toLogin");
			return false;
		}
		
		
	}

}
