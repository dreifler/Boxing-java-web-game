<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Boxers</title>
	
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Boxer Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
		<!-- button calls a spring controller mapping showFormForAdd -->
			<input type="button" value="Add Boxer"
				onclick="window.location.href='showFormForAdd'; return false"
			/>
		
			<table>
				<tr>
					<th>Name</th>
					<th>Str</th>
					<th>Spd</th>
					<th>Agl</th>
					<th>cnd</th>
				</tr>
				
				<c:forEach var="tempBoxer" items="${Boxers}">
					<tr>
						<td>${tempBoxer.name}</td>
						<td>${tempBoxer.str}</td>
						<td>${tempBoxer.spd}</td>
						<td>${tempBoxer.agl}</td>
						<td>${tempBoxer.cnd}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>

</html>