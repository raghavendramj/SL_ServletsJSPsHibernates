package com.simplilearn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
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
	}

}
