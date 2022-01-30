<%@page import="com.simplilearn.model.Student"%>
<html>
<head>
<title>Forwarded Here</title>
</head>
<body>
	<h3> This is the redirected JSP Page</h3>
	<jsp:useBean id="studentRaghav" class="com.simplilearn.model.Student" scope="session"/>
	<ul>
		<li>Id : <jsp:getProperty property="id" name="studentRaghav" /></p></li>
		<li>Name : <jsp:getProperty property="name" name="studentRaghav" /></p></li>
		<li>City : <jsp:getProperty property="city" name="studentRaghav" /></p></li>
		<li>Email : <jsp:getProperty property="email" name="studentRaghav" /></p></li>
	</ul>
	
	<%
	Student myStudent = studentRaghav;
	out.print("<br> myStudent is : "+ myStudent);
	out.print("<br> myStudent.getId is : "+ myStudent.getId());
	%>
</body>
</html>