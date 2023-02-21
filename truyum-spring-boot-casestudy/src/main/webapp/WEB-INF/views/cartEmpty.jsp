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
			<div id="tableID2" class="table-container">
				<h1>Menu Items</h1>
			</div>
			<div id="msgHere2">No Item in the cart. Use 'Add to Cart' option in <a href="/show-menu-list-customer">Menu Item List.</a></div>
		</div>


	</section>





	<!--Footer-->
	<footer> Copyright &copy 2020 </footer>



</body>
</html>