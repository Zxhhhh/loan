package com.gy612.loan.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.gy612.loan.service.UserService;

/**
 * 登录拦截器
 * @author K550J
 *
 */
public class LoginInteceptor implements HandlerInterceptor {
	

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2, ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 登录拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null){
			System.out.println("未登录");
			//request.getRequestDispatcher("/user/toLogin").forward(request,response);
			response.sendRedirect("/loan/user/toLogin");
			return false;
		}else{
			System.out.println("已登录");
			return true;
		}
	}

}
