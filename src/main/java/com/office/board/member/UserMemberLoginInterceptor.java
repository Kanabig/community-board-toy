package com.office.board.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.office.board.config.Configs;

public class UserMemberLoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession(false);
		
		if (session != null) {
			if (session.getAttribute(Configs.LOGIN_USER_MEMBER_ID) != null) {
				return true;
			}
		}
		
		response.sendRedirect(request.getContextPath() + "/user/member/loginForm");
		return false;
	}
	
}
