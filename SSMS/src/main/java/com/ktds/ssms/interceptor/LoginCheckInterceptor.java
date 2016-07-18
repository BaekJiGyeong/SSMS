package com.ktds.ssms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ktds.ssms.utilities.Session;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
		boolean wasLogin = request.getSession().getAttribute(Session.MEMBER) != null;
		
		if ( wasLogin ) {
			
				response.sendRedirect("/SSMS/login");
				return;
			} else {
				request.getSession().invalidate();
				return;
			}
		}
	}
