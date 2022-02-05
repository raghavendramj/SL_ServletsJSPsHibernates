<%@page import="com.simplilearn.entity.ClassRoom"%>
<%@page import="com.simplilearn.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Student</title>
</head>
<body>
	<center>
		<h1>Class Room Management</h1>
		<h2>
			<a href="pages/logout.jsp">Logout</a> 
			<a href="pages/createClass.jsp">Add New Class Room</a>
			<table border="1" cellpadding="5">
				<caption>
					<h2>List of Students</h2>
				</caption>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Actions</th>
				</tr>
					classRooms : <c:out value="${classRooms}" />
	
			</table>
		</h2>
	</center>

</body>
</html>