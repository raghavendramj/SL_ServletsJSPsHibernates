<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simplilearn</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container fluid">
		<%@ include file="link.jsp"%>

		<h3>Login Form</h3>  
		<form action="dashboard.jsp">
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
	</div>

</body>
</html>