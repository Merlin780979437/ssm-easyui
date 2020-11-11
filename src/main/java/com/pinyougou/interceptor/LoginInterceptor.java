package com.pinyougou.interceptor;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.pinyougou.entity.SysPermission;
import com.pinyougou.entity.SysUser;

public class LoginInterceptor implements HandlerInterceptor{

	private List<String> excludeUrls;
	
	
	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	/**
	 * 运行控制层之前拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//获得请求路径
		String requestURI = request.getRequestURI();
		//获得项目名
		String contextPath = request.getContextPath();
		//获得真实请求路径
		String servletPath = requestURI.substring(contextPath.length());
		
		//判断请求是否被放行
		if (excludeUrls.contains(servletPath)) {
			return true;
		}
		
		//从session中获得当前登录用户信息
		SysUser sysUser = (SysUser) request.getSession().getAttribute("sysUser");
		
		if (sysUser == null) {
			
			//判断是否ajax请求
			if(request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
				PrintWriter out = response.getWriter();  
				out.print("loseToken");//session失效
				out.flush();
				return false;
			}
			
			System.out.println("尚未登录，调到登录页面");
			response.sendRedirect(contextPath + "/login.jsp");//注意注意，再强调，得引入basePath
            return false;
		}
		
		//权限拦截
		if (!CollectionUtils.isEmpty(sysUser.getPermissionList()) || sysUser.getPermissionList().size() == 0) {
			//获得权限拥有的所有请求路径
			List<String> list = new ArrayList<String>();
			for (SysPermission perm : sysUser.getPermissionList()) {
				list.add(perm.getUrl());
			}
			
			if (!list.contains(servletPath)) {
				
				if(request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
					PrintWriter out = response.getWriter();  
					out.print("noSecurity");//session失效
					out.flush();
					return false;
				}
				
				
				
				request.getSession().setAttribute("msg", "当前用户没有权限！");
				//request.getRequestDispatcher("/error/noSecurity.jsp").forward(request, response);
				response.sendRedirect(request.getContextPath() + "/error/noSecurity.jsp");
				return false;
			}
			
			
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
 