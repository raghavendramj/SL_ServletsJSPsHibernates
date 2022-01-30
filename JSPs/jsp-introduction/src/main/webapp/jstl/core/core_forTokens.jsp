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
	<c:forTokens items="Virat,Rohith,Rahul,Rishah,Bumrah" delims="," var="name">
		Name : <c:out value="${name}" />
		<p>
	</c:forTokens>

</body>
</html>