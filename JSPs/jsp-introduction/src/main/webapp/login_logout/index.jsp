<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simplilearn</title>
</head>
<body>
	<h3>Welcome to Simplilearn</h3>
	<%
		String username = (String) session.getAttribute("user");
		out.println("Current Value of user is :  " + username);
	%>
	<ul>
		<li><a href="login.jsp">Login</a></li>
		<li><a href="scriptletTags.jsp">Home</a></li>
	</ul>
</body>
</html>