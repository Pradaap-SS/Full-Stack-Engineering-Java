<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
				<h1>Edit Menu Item Status</h1>
				<h2 style="color:green;font-style:italics;">Menu Item details saved successfully</h2>
			</div>
		</div>
	</section>


	<!--Footer-->
	<footer> Copyright &copy 2020 </footer>

</body>


</html>