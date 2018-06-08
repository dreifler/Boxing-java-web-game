<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- Spring MVC form tags added above -->

<!DOCTYPE html>
<html>

<head>
	<title>Save Boxer</title>
	
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-boxer-style.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Boxer Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Boxer</h3>
		
		<!-- Sends spring to mvc mapping and binds to boxer -->
		<form:form action="saveBoxer" modelAttribute="boxer" method="POST">
		
		<!-- need to associate this data with boxer id -->
		<form:hidden path="ID" />
		
			<table>
				<tbody>
					<tr>
						<td><label>ID:</label></td>
						<td><form:input path="ID"></form:input>
					</tr>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name"></form:input></td>
					</tr>
					<tr>
						<td><label>Str:</label></td>
						<td><form:input path="str"></form:input></td>
					</tr>
					<tr>
						<td><label>Spd:</label></td>
						<td><form:input path="spd"></form:input></td>
					</tr>
					<tr>
						<td><label>Agl:</label></td>
						<td><form:input path="agl"></form:input></td>
					</tr>
					<tr>
						<td><label>Cnd:</label></td>
						<td><form:input path="cnd"></form:input></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>
			</table>
			
		</form:form>
		
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/boxers/list">Back to List</a>
		</p>
	</div>
	
</body>

</html>