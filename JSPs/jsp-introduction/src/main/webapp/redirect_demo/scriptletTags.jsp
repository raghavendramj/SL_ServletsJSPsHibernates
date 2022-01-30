<%@page import="java.util.Calendar" info="This will import calender library"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scriptlet tags Demo</title>
</head>
<body>
	<h3>JSP scriptlet tag!</h3>
	<%
		String myName = "Raghav";
		out.print("Name is : " + myName);
		out.print("<br />This is just like System.out.println('IN Java'); ");
	%>

	<h3>JSP expression tag!</h3>
	Current Time :
	<%=Calendar.getInstance().getTime() %>
	<br />
	<br />
	<form action="welcome">
		<table>
			<tr>
				<td><label for="username">Username : </label></td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td><label for="password">Password : </label></td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="reset" value="Clear"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>

	<h3>JSP Declaration Tag</h3>

	<%!int currentValue = 50;%>
	<%
		out.print("<br> The Value of current is : " + currentValue);
	%>

</body>
</html>