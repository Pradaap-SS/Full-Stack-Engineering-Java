<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br><br>
<form name="form" action="AgeCalculator" method="get">
		<table border="1" cellpadding="1">
			<caption>Age Calculator</caption>
			<tr>
				<td>Enter Name :</td>
				<td><input type="text" id="name" name="name" required="required" pattern="[A-z][a-z]*"/></td>
			</tr>
			<tr>
				<td>Select Birth Date :</td>
				<td><input type="date" id="dob" name="dob" required="required" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="calculateAge"
					value="Calculate Age" /></td>
				<td><input type="reset" value="Cancel" /></td>
			</tr>
		</table>
	</form>
<br><br>
<h2 id="result">
${name} ${message}
</h2>

</body>
</html>