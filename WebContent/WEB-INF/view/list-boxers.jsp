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
					<th>Cnd</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempBoxer" items="${Boxers}">
				
				<!--  construct an "update" link with boxer id -->
				<c:url var="updateLink" value="/boxers/showFormForUpdate">
					<c:param name="boxerId" value="${tempBoxer.ID}"/>
				</c:url>
				
				<c:url var = "deleteLink" value="/boxers/delete">
					<c:param name="boxerId" value="${tempBoxer.ID}"/>
				</c:url>
				
					<tr>
						<td>${tempBoxer.name}</td>
						<td>${tempBoxer.str}</td>
						<td>${tempBoxer.spd}</td>
						<td>${tempBoxer.agl}</td>
						<td>${tempBoxer.cnd}</td>
						<td>
						<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this boxer?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>

</html>