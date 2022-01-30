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
	<c:set var="salary" scope="session" value="${0}" />
	<p>
		Your salary is :
		<c:out value="${salary}" />
	</p>
	<c:choose>
		<c:when test="${salary <= 0}">
            Salary is very low to survive.
         </c:when>

		<c:when test="${salary > 1000}">
            Salary is very good.
         </c:when>

		<c:otherwise>
            No comment sir...
         </c:otherwise>
	</c:choose>
</body>
</html>