<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>
</head>
<body>
	<%@ include file="link.jsp"%>
	<h3>Logout Page</h3>
	<%
		String username = (String) session.getAttribute("user");
		out.println("username "+ username);
		if (username != null && !username.isEmpty()) {
			session.removeAttribute("user");
			out.println("Successfully cleared the username");
			response.sendRedirect("index.jsp");
			return;
		}
	%>
</body>
</html>