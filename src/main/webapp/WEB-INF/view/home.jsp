<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>Boxing Game Home Page</title>
</head>

<body>
	<h2>Boxing Game Home Page</h2>
	<hr>
	
	<p>
	Welcome to the boxing game home page!
	</p>
	
	<!-- display user name and role -->
	
	<p>
		User: <security:authentication property="principal.username" />
		<br><br>
		Role: <security:authentication property="principal.authorities" />
	</p>
	
	<security:authorize access="hasRole('ADMIN')">
	<hr>
	<!-- Add a link to point to /leaders ... this is for the admin -->

	<p>
		<a href="${pageContext.request.contextPath}/boxers">Boxer List (Restricted Access)</a>
	</p>
	</security:authorize>
	
	<security:authorize access="hasRole('PROG')">
	<!-- Add a link to point to /systems ... this is only for programmers -->
	
	<p>
		<a href="${pageContext.request.contextPath}/systems">Game Systems (Restricted Access)</a>
	</p>
	</security:authorize>
	
	<hr>
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
	
</body>

</html>









