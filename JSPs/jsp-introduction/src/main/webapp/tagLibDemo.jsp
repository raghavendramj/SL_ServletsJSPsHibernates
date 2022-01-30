<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tag Lib Example</title>
</head>
<body>
	<p>
		<c:out value="${'Welcome to JSP Simplilearn Class'}"></c:out>
	</p>
	<p>
		<c:import var="posts" url="https://jsonplaceholder.typicode.com/posts/" />
		<c:forEach var="eachPost" items="${posts}" begin="1" end="5">
			<p>
				Each Post : <c:out value="${eachPost}"></c:out>
			</p>
		</c:forEach>
	</p>
</body>
</html>