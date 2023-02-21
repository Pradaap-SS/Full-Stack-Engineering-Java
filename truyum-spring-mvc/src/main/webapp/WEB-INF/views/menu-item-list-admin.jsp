<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<div class="main-container">
			<div id="tableID" class="table-container">
				<h1>Menu Items</h1>

				<table class="table-style">
					<thead>
						<tr>
							<td>Name</td>
							<td>Price</td>
							<td>Active</td>
							<td>Date of Launch</td>
							<td>Category</td>
							<td>Free Delivery</td>
							<td>Action</td>
						</tr>
					</thead>
					<tbody>
						<%-- <tr>
							<td>Sandwich</td>
							<td>Rs. 99.00</td>
							<td>Yes</td>
							<td>15/03/2017</td>
							<td>Main Course</td>
							<td>No</td>
							<td><a href="/edit-list/id=${id}">Edit
									</button></td>
						</tr> --%>
						<c:forEach items="${menuItemList}" var="menuItem">
							<tr>
								<td>${menuItem.itemName}</td>
								<td>${menuItem.itemPrice}</td>
								<td>${menuItem.itemActive}</td>
								<td>${menuItem.dateOfLaunch}</td>
								<td>${menuItem.category}</td>
								<td>${menuItem.freeDelivery}</td>
								<td><a href="show-edit-menu-item?itemId=${menuItem.itemId}">Edit ${menuItem.itemId}</a></td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div id="msgHere"></div>
		</div>

	</section>


	<!--Footer-->
	<footer> Copyright &copy 2020 </footer>

</body>


</html>