package com.pethotel.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		
		if (request.getSession().getAttribute("member_id") == null) {
            
			response.sendRedirect("/user/login");
            
			return false;
        }
        return true; 
	}
	
}
