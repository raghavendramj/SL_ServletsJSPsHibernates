<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cookie- Sesssion Tracking Demo</title>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h3> Login Form</h3>
	<form action="loginServlet" method="GET">
		<table>
			<tr>
				<td><label> Enter Username </label></td>
				<td><input name="username" type="text" /></td>
			</tr>
			<tr>
				<td><label> Enter Password </label></td>
				<td><input name="password" type="password" /></td>
			</tr>
		</table>
		<br />
		<input name="submit" type="submit" value="Login" />
	</form>
</body>
</html>