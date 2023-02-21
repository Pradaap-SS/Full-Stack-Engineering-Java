<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body style="background-color:lavender">
<h1><center> Welcome to Online Help Services </center></h1>
<form:form modelAttribute="register" method="post" action="register">
<table>
<tr>
				<td><form:label path="userName">UserName:</form:label></td>
                <td><form:input type="text" name="userName" path="userName" id="userName" /></td>
                <td><form:errors path="userName"></form:errors>
			</tr>

			<tr>
				<td><label path="contactNumber">Contact Number</label></td>
				<td><form:input path="contactNumber" name="contactNumber" id="contactNumber" /></td>
				<td><form:errors path="contactNumber"></form:errors>
			</tr>

			<tr>
				<td><label path="emailId">Email Id</label></td>
				<td><sf:input path="emailId" name="emailId" id="emailId" /></td>
				<td><form:errors path="emailId"></form:errors>
			</tr>
			<tr>
				<td><label path="confirmEmailId">Confirm Email Id</label></td>
				<td><form:input path="confirmEmailId" name="confirmEmailId" id="confirmEmailId" /></td>
				<td><form:errors path="confirmEmailId"></form:errors>
			</tr>
			<tr>

				<td><form:checkbox path="status" id="status" name="status" /></td>
				<td><label path="status">I agree</label></td>
				<td><form:errors path="status"></form:errors>
			</tr>
			<tr>
				<td><input type="submit" value="Register" name="submit" /></td>
				<td><input type="reset" value="Cancel" name="cancel" /></td>
				<td></td>
			</tr>
	
</table>
</form:form>


</body>
</html>	 	  	    	    	     	      	 	
