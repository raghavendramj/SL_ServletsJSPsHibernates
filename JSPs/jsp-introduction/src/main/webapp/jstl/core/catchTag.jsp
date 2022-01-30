<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<title>Tag Example</title>
</head>
<body>
	<h1>Catch Example</h1>
	<c:catch var="catchException">
		<%
			int x = 5 / 0;
		%>
	</c:catch>

<p>Exception is : <c:out value="${catchException}" /> </p>
<p> Message is : <c:out value="${catchException.message}" /> </p>
	
	
</body>
</html>