<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Core Tags Demo</title>
</head>
<body>

	<h2>C Set Example</h2>
		<c:set var="salary" scope="session" value="${2000*4}" />
		Before Salary Value : <c:out value="${salary}" />
		
	<h2>C Remove Example</h2>
	<p>
	<c:remove var="salary" />
		After Salary Value :
		<c:out value="${salary}" />
	</p>
	
	<h2>C Catch Example</h2>
	<c:catch var ="catchException">
         <% int x = 5/0;%>
     </c:catch>
     
     <c:if test = "${catchException != null}">
         <p>The exception is : ${catchException} <br />
         There is an exception: ${catchException.message}</p>
      </c:if>



</body>
</html>