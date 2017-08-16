package com.primary.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.primary.annotation.parser.RequestPermissionParser;
import com.primary.util.Log;

public class PermissionInterceptor extends HandlerInterceptorAdapter {
	RequestPermissionParser Parser = new RequestPermissionParser();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Log.info("");
		
		Log.info(handler.getClass().getName());
		
		Log.info(request.getRequestURI());
		
		if (!Parser.parse(handler, request)) {
			//401未授权访问
			Log.info("拦截未通过");
            response.setStatus(401);
            return false;
		}
		
		Log.info("拦截通过");
		
		return true;
	}
}
