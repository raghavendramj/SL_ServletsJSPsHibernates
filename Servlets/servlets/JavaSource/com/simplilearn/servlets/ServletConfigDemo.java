package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletConfigDemo extends GenericServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		ServletConfig configuration = getServletConfig();
		String userNameFromInitParam = configuration.getInitParameter("username");
		String passwordFromInitPram = configuration.getInitParameter("password");

		PrintWriter out = response.getWriter();
		out.println("\n ******** Case : 01 Directly fecthing from known key names..");
		out.println("Key : username and  value is : " + userNameFromInitParam);
		out.println("Key : password and  value is : " + passwordFromInitPram);

		out.println("\n ******** Case : 02 Fecthing with the help of Enumeration...");
		Enumeration<String> parameterNames = configuration.getInitParameterNames();
		while (parameterNames.hasMoreElements()) {
			String key = parameterNames.nextElement();
			String value = configuration.getInitParameter(key);
			out.println("Fetched using Enumeration Key : " + key + " and  value is : " + value);
		}

		out.println("\n ********Name of the Servlet :-" + getServletName());

	}
}
