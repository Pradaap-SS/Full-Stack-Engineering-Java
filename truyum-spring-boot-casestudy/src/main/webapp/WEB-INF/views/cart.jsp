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
			<a href="/show-menu-list-customer">Menu</a> | <a href="/show-cart">Cart</a>
			| <a href="/logout">Logout</a>
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
							<td>Action</td>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${cartItems}" var="menuItem">
							<tr>
								<td>${menuItem.itemName}</td>
								<td>${menuItem.freeDelivery}</td>
								<td>${menuItem.itemPrice}</td>
								<td><a href="delete-cart-item?itemId=${menuItem.itemId}">Delete from Cart</a></td>

							</tr>
						</c:forEach>

						<tr>
							<td></td>
							<td><b>Total</b></td>
							<td><b>${total} </b></td>

							<td></td>
						</tr>
					</tbody>
				</table>


			</div>
		</div>


	</section>





	<!--Footer-->
	<footer> Copyright &copy 2020 </footer>



</body>
</html>