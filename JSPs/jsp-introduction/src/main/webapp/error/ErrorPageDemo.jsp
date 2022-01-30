<%@ page errorPage="CustomError.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page Demo</title>
</head>
<body>
	<h1>This is the page where error occurred!</h1>
	<%= 100/0 %>
</body>
</html>