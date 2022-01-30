<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<%@ include file="link.jsp"%>

	<%@ page import="com.simplilearn.model.LoginUser"%>
	<%@page import="com.simplilearn.model.LoginDao"%>
	
	<jsp:useBean id="user" class="com.simplilearn.model.LoginUser" />
	<jsp:setProperty property="email" name="raghav" />
	<jsp:setProperty property="password" name="admin@123" />

	<%
		boolean isValidUser = LoginDao.validate(user);
		if (isValidUser) {
			out.println("Logged Successfully!");
			String username = request.getParameter("username");
			session.setAttribute("username", username);
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				out.println("Exception Occurred");
			}
			response.sendRedirect("dashboard.jsp");
		} else {
			out.println("Invalid Credentials");
		}
	%>
</body>
</html>