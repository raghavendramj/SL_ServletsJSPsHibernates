<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DasbhBoard</title>
</head>
<body>
	<h3>Welcome to Dashboard page!</h3>
	<%
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		out.print("<br>Username : "+ username);
		out.print("<br>Password : "+ password);

		boolean validUser = username != null && !username.isEmpty() && password != null && !password.isEmpty();
		if (validUser && password.equals("admin@123")) {
			session.setAttribute("user", username);
			
			String sessionUsername = (String) session.getAttribute("user");
			out.println("<br>Current Value of user is :  " + sessionUsername);
			%>
			<br />
			<br />
			<a href="logout.jsp">Logout</a>
			<%
		}
	%>
</body>
</html>