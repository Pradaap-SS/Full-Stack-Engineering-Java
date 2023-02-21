<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body style="background-color:lavender">
<h1><center> Welcome to Online Help Services </center></h1>
<center>
<form:form modelAttribute="helper" action="/helpDesk" method="POST">
	<form:label path="serviceType">Choose Service:</form:label>
    <form:select id="serviceType" path="serviceType" items="${serviceList}"></form:select><br>
    <form:label path="noOfHours">Total Hours Service Required</form:label>
	<form:input id="noOfHours" path="noOfHours"/><br>
	
	<input type="submit" name="submit" value="TotalCost">
	<input type="reset" name="cancel" value="Cancel">
	
</form:form>
</center>

</body>
</html>	 	  	    	    	     	      	 	
