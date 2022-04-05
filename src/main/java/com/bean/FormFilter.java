package com.bean;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;



@Component
class FormFilter extends OncePerRequestFilter{
//
//	public FormFilter() {
//		// TODO Auto-generated constructor stub
//	}
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.out.println("request In ");
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setHeader("Access-Control-Allow-Method","GET,PUT,POST,DELETE");
		response.setHeader("Access-control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "authorization,content-type,xsrf-token");
		filterChain.doFilter(request, response);
	}
	
 
 
}
