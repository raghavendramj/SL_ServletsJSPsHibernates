<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Request Prameters Demo</title>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<form action="requestparamsdemo" method="GET">
		<table>
			<tr>
				<td><label> Enter Firstname </label></td>
				<td><input name="firstName" type="text" /></td>
			</tr>
			<tr>
				<td><label> Enter Lastname </label></td>
				<td><input name="lastName" type="text" /></td>
			</tr>
			<tr>
				<td><label> Enter Address </label></td>
				<td><input name="address" type="text" /></td>
			</tr>
			<tr>
				<td></td>
				<td> <input name="submit" type="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>