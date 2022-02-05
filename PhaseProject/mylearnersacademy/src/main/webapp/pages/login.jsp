<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<center>
		<h1>Learner's Academy</h1>
		<h2>
			<form action="/mylearnersacademy/login" method="post">
				<table border="1" cellpadding="10">
					<tr>
						<th>Username</th>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<th>Password</th>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
						<input type="submit" value="Login" /></td>
					</tr>
				</table>
			</form>
		</h2>
	</center>
</body>
</html>