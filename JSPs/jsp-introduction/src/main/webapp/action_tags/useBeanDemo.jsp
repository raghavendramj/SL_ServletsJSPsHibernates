<html>
<head>
<title>Use Bean Demo</title>
</head>
<body>
	<h3> Use Bean Demo</h3>
	<!-- [id=0, name=null, city=null, email=null]  -->
	<jsp:useBean id="studentRaghav" class="com.simplilearn.model.Student" scope="session" />
	<jsp:setProperty name="studentRaghav" property="id" value="1"/>
	<jsp:setProperty name="studentRaghav" property="name" value="Raghavendra"/>
	<jsp:setProperty name="studentRaghav" property="city" value="Banglore"/>
	<jsp:setProperty name="studentRaghav" property="email" value="raghav@gmail.com"/>
	<%
		out.print("Student Info : "+ studentRaghav);
	%>
	
	<jsp:forward page="jspForwardDemo.jsp"></jsp:forward>
	
</body>
</html>