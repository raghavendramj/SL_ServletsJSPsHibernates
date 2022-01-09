package com.simplilearn.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Init Method : "+ filterConfig.toString());
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String username = request.getParameter("username");
		System.out.println("User Id :- "+ username);
		
		if(username != null && !username.isEmpty()) {
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
		System.out.println("Destroy Method ");
	}

}
