<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css2?family=Peddana&display=swap"
	rel="stylesheet">
</head>
<body>
<body>
	<!-- header-->
	<header>
		<div id="logo">
			<a href="#">truYum</a>
		</div>
		<div id="logo-img">
			<img src="images/logo.png">
		</div>
		<div id="nav">
			<a href="/show-menu-list-admin">Menu</a> | <a href="/logout">Logout</a>
		</div>

	</header>

	<!--Section-->
	<section>
		
			

				<h1>Edit Data</h1>


				<form:form name="editForm" method="POST" action="edit-menu-item" modelAttribute="item">
					<table class="update-table">
						<tr>
							<td><form:hidden path="itemId" /> <form:label path="itemName">Name</form:label></td>
							<td><form:input path="itemName" id="itemName" name="itemName"  required="required"/></td>
							<td><form:errors path="itemName" class="text-warning" /></td>
						</tr>
						<tr>
							
							<td><form:label path="itemPrice">Price (Rs.)</form:label></td>
							<td><form:input path="itemPrice" id="itemPrice" name="itemPrice" required="required"/></td>
							<td><form:errors path="itemPrice" class="text-warning" /></td>
						</tr>
						<tr>
							<td><form:label path="itemActive">Active</form:label></td>
							<td><form:radiobutton path="itemActive" value="true" /> Yes
								<form:radiobutton path="itemActive" value="false" /> No</td>
							<td></td>
`						</tr>
						<tr>
					        <td><form:label path="dateOfLaunch">Date of launch (yyyy-MM-dd)</form:label></td>
							<td>
								<form:input type="date" path="dateOfLaunch" id="dateOfLaunch" name="dateOfLaunch" required="required" /> 
								<%-- <form:input path="dateOfLaunch" id="dateOfLaunch" name="dateOfLaunch" required="required"/> --%>
							</td>
							<td></td>
						</tr>
						<tr>
					        <td><form:label path="category">Category</form:label></td>
							<td><form:select path="category" id="category" name="category" items="${categoryList}" /></td>
							<td></td>

						</tr>
						<tr>					        
							<td><form:label path="freeDelivery">free Delivery</form:label></td>
							<td><form:radiobutton path="freeDelivery" value="true" /> Yes
							<form:radiobutton path="freeDelivery" value="false" /> No</td>
							<td></td>
						</tr>
						<tr>
						<td>
							<input type="submit" value="Update" class="update-btn" />
						</td>
						<td></td>
						<td></td>
						</tr>
					</table>
				</form:form>
		
	</section>


	<!--Footer-->
	<footer> Copyright &copy 2020 </footer>

</body>


</html>