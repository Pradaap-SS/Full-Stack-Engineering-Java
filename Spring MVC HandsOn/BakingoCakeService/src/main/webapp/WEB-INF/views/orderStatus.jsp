<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Status</title>
</head>
<body>
<h2 id="status">
			Your order has been successfully placed, <br/>
			Order Id: ${orderId} <br/>
			Order Date: <%= new java.util.Date() %> <br/>
			Amount in dollar:$${cake.price} <br/>
			Amount in Rupees: Rs.${indianPrice}
		</h2>
</body>
</html>
