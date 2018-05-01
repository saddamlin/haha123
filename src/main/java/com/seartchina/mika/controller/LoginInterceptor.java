package com.seartchina.mika.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.seartchina.mika.service.UserService;



@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private UserService userService;

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String authCode = request.getParameter("auth_code");
		String sessionId = request.getParameter("session_id");
		if(sessionId == null && authCode != null) {
			Pair<String,String> ret = userService.wxLogin(authCode);
			Pair<Integer,Integer> sessRet = userService.userLogin(ret.getLeft(), ret.getRight());
			request.setAttribute("user_id", sessRet.getLeft());
			request.setAttribute("session_id", sessRet.getRight());
		} else if (sessionId != null ) {
			Integer userId = userService.checkLogin(Integer.valueOf(sessionId));
			// still pass the user id even if it's null
			request.setAttribute("user_id", userId);
			request.setAttribute("session_id", sessionId);
		}
		
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		super.postHandle(request, response, handler, modelAndView);
	}

	
	
	

}
