package com.ktds.ssms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ktds.ssms.utilities.Session;

public class SessionCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		boolean wasLogin = request.getSession().getAttribute(Session.MEMBER) != null;
		
		if ( !wasLogin ) {
			response.sendRedirect("/SSMS/login");
		}
		
		return wasLogin;
	}
}
