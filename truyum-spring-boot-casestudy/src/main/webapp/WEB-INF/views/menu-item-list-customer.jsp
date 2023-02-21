<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" />
</head>
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
			<a href="/show-menu-list-customer">Menu</a> | <a href="/show-cart">Cart</a> | <a href="/logout">Logout</a>
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
							<td>Free Delivery</td>
							<td>Price</td>
							<td>Category</td>
							
							<td>Action</td>
						</tr>
					</thead>
					<tbody>
						
						<c:forEach items="${menuItemListCustomer}" var="menuItem">
							<tr>
								<td>${menuItem.itemName}</td>
								<td>${menuItem.freeDelivery}</td>
								<td>${menuItem.itemPrice}</td>
								<td>${menuItem.category}</td>
								
								<td><a href="add-to-cart?itemId=${menuItem.itemId}">Add to cart </a></td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<h2 style="color:green;font-style:italics;"> ${message} </h2>
		</div>

	</section>


	<!--Footer-->
	<footer> Copyright &copy 2020 </footer>


</body>
</html>