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
	<c:set var="salary" scope="session" value="${2000*2}" />
	<c:if test="${salary > 2000}">
		<p>
			My salary is:
			<c:out value="${salary}" />
		<p>
	</c:if>
</body>
</html>