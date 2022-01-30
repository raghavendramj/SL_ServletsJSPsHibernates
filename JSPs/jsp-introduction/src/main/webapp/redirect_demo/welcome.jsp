<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to the page</title>
</head>
<body>
	<h2>Welcome to the application</h2>

	<h3>These are read from config parameters</h3>
	<%
		String websiteName = config.getInitParameter("Website");
		out.print("Website name : " + websiteName);
	%>



	<%
		String paramName = request.getParameter("username");
		if ("google".equalsIgnoreCase(paramName)) {
			response.sendRedirect("https://www.google.com/");
		} else {
			Enumeration<String> paramNames = request.getParameterNames();
			while (paramNames.hasMoreElements()) {
				String key = paramNames.nextElement();
				String value = request.getParameter(key);
				out.println("<br /> Request Name : " + key + " and Value is : " + value);
			}
		}
	%>
</body>
</html>