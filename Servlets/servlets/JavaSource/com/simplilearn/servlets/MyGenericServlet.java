package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyGenericServlet extends GenericServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String driverInfo = getServletConfig().getInitParameter("driver");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Generic Servlet Example!</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<b> Welcome to the class, we are learning about Generic Servlet </b><br />");
		out.println("<b> Driver Information : </b><br />" + driverInfo);
		out.println("</body>");
		out.println("</html>");
		
		ServletContext servletContext = getServletContext();

		String emailValue = servletContext.getInitParameter("email");
		String cityValue = servletContext.getInitParameter("city");

		out.println("\n ******** Case : 01 Directly fecthing from known key names..");
		out.println("Key : email and  value is : " + emailValue);
		out.println("Key : city and  value is : " + cityValue);

		out.println("\n ******** Case : 02 Fecthing with the help of Enumeration...");
		Enumeration<String> parameterNames = servletContext.getInitParameterNames();
		while (parameterNames.hasMoreElements()) {
			String key = parameterNames.nextElement();
			String value = servletContext.getInitParameter(key);
			out.println("Fetched using Enumeration Key : " + key + " and  value is : " + value);
		}
	}

}
