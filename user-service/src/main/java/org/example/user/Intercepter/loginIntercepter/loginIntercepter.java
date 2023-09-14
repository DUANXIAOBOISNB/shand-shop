package org.example.user.Intercepter.loginIntercepter;

import org.example.user.Utils.JwtUtil;
import org.example.user.Vo.TokenVo;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class loginIntercepter implements HandlerInterceptor {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		TokenVo tokenVo= JwtUtil.getuserInfoBytoken(request);
		if(tokenVo != null)
		{
			return true;
		}
		response.getWriter().print("Access denied");
		return false;

	}
}
