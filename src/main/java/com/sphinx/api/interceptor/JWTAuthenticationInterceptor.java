package com.sphinx.api.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sphinx.api.service.AppUserService;

public class JWTAuthenticationInterceptor implements HandlerInterceptor {

	@Autowired
	AppUserService AppUserService;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object)
			throws Exception {
		// TODO Auto-generated method stub
		String authorization=request.getHeader("Authorization");
		 if(!(object instanceof HandlerMethod)){
	            return true;
	        }
	        HandlerMethod handlerMethod=(HandlerMethod)object;
	        Method method=handlerMethod.getMethod();
	        //检查是否有passtoken注释，有则跳过认证
	        if (method.isAnnotationPresent(PassToken.class)) {
	            PassToken passToken = method.getAnnotation(PassToken.class);
	            if (passToken.required()) {
	                return true;
	            }
	        }
	        
	        if (method.isAnnotationPresent(UserLoginToken.class)) {
	        	 UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
	             if (userLoginToken.required()) {
	            	 if(authorization==null) {
	            		 throw new RuntimeException("无权限登录，请先登录");
	            	 }
	             }
	             
	             try {
	            	 AppUserService.verifyToken(authorization, false);
	             }catch (Exception e) {
					// TODO: handle exception
	            	 throw new RuntimeException(e.getMessage());
				}
	        }
	        return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
