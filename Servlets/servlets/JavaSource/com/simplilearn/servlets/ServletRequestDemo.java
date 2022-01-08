package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletRequestDemo extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		String firstNameValue = request.getParameter("firstName");
		String lastNameValue = request.getParameter("lastName");
		String addressValue = request.getParameter("address");

		PrintWriter out = response.getWriter();
		out.println("\n ******** Case : 01 Directly fecthing from known key names..");
		out.println("Key : firstName and  value is : " + firstNameValue);
		out.println("Key : lastName and  value is : " + lastNameValue);
		out.println("Key : address and  value is : " + addressValue);

		out.println("\n ******** Case : 02 From Enumeration..");

		Enumeration<String> requestParamNames = request.getParameterNames();

		while (requestParamNames.hasMoreElements()) {
			String key = requestParamNames.nextElement();
			String value = request.getParameter(key);
			out.println("From Enumeration... Key : " + key + " and  value is : " + value);
		}
	}
}
