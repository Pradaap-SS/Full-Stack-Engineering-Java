<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BMI Calculator</title>
</head>
<body>
	<br>
	<br>
	<h1>BMI Calculator</h1>
	<table>
	<caption style="font-weight: bolder;">Body Mass Index Calculator Form</caption>
	
	<sf:form action="getBMI" modelAttribute="user" method="GET" name="form">
			<tr>
				<td>Enter Name:</td>
			
			</tr>
				<tr>
				<td>Phone Number:</td>
				
			</tr>
				<tr>
				<td>Height in CM:</td>
			
			</tr>
				
				<tr>
				<td>Weight in KG:</td>
				
			</tr>
			
			<tr>
				<td>Gender:</td>
				
			</tr>
			<tr>
			
			</tr>
		</sf:form>
	</table>

</body>
</html>