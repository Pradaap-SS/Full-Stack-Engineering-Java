<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Cake Form</title>
<style>
#wrap {
	width: 400px;
	margin: 0 auto;
	text-align: left;
	margin-top: 8px;
	padding: 5px;
	background: #fff;
	font-family: AvenirLTStd, Arial, Helvetica, sans-serif;
	font-size: 13px;
	line-height: 16px;
}

#wrap .cont_details fieldset, .cont_order fieldset {
	margin: 10px;
	padding: 10px;
	-moz-border-radius: 10px;
	-webkit-border-radius: 10px;
	-khtml-border-radius: 10px;
	border-radius: 10px;
}

#wrap legend {
	font-size: 16px;
	font-family: Georgia, 'Times New Roman', Times, serif;
	color: #000;
	font-weight: bold;
	font-style: italic;
	padding-bottom: 8px;
}

#wrap .cont_details input {
	margin-bottom: 8px;
	color: #000;
}

#wrap .input1:hover, .input1:active {
	
}

#wrap label {
	display: block;
	font-size: 12px;
	color: #000;
	font-weight: bold;
}

#wrap label.inlinelabel {
	display: inline;
}

#wrap .cont_order input {
	margin-bottom: 3px;
}

#wrap .cont_order p {
	padding-top: 5px;
}

#wrap input[type='radio'] {
	margin-top: 8px;
	margin-bottom: 8px;
}

#wrap input[type='text']:hover, #wrap input[type='text']:active {
	background-color: #faf398;
}

#wrap input#submit {
	margin: 10px;
	padding-left: 20px;
	padding-right: 20px;
	padding-top: 10px;
	padding-bottom: 10px;
}

#wrap label.radiolabel {
	font-weight: normal;
	display: inline;
}

.error {
	color: red;
}
</style>
</head>
<body>
	<div id="wrap">
		<sf:form action="orderStatus" name="form" modelAttribute="cake" method="POST">
			<div class="cont_order">
				<fieldset>
					<legend>Make your cake!</legend>
					<label>Size Of the Cake</label>
					<sf:radiobutton id="selectedcake1" name="selectedCake" value="10" path="selectedcake" />
					<label class="radiolabel" for="selectedcake1">Round cake 6" - serves 8 people ($10)</label><br />
					<sf:radiobutton id="selectedcake2" name="selectedCake" value="15" path="selectedcake" />
					<label class="radiolabel" for="selectedcake2">Round cake 8" - serves 12 people ($15)</label><br />
					<sf:radiobutton id="selectedcake3" name="selectedCake" value="25" path="selectedcake" />
					<label class="radiolabel" for="selectedcake3">Round cake 10" - serves 16 people ($25)</label><br />
					<sf:radiobutton id="selectedcake4" name="selectedCake" value="30" path="selectedcake" />
					<label class="radiolabel" for="selectedcake4">Round cake 12" - serves 30 people ($30)</label><br />
					<sf:errors class="error" path="selectedcake" />
					<br /> <label>Filling Flavor</label>
					<sf:select id="flavor" name="flavor" path="flavor" items="${flavorList }">
					</sf:select>
					<sf:errors path="flavor" class="error"></sf:errors>
					<p>
						<label for="includecandles" class="inlinelabel">Include Candles($5)</label>
						<sf:checkbox id="includecandles" name="includecandles" value="5" path="includeCandles" />
					</p>
					<p>
						<label class="inlinelabel" for="includeinscription">Include Inscription($5)</label>
						<sf:checkbox id="includeinscription" name="includeinscription" value="5" path="includeinscription" />
						<sf:input type="text" name="theinscription" id="theinscription" placeholder="Enter Inscription" path="theinscription" />
					</p>
				</fieldset>
			</div>
			<div class="cont_details">
				<fieldset>
					<legend>Contact Details</legend>
					<label for="name">Name</label>
					<sf:input  name="name" id="name" path="name" />
					<sf:errors class="error" path="name" />

					<br /> <label for="address">Address</label>
					<sf:input  name="address" id="address" path="address" />
					<sf:errors class="error" path="address" />
					<br /> <label for="phonenumber">Phone Number</label>
					<sf:input  name="phonenumber" id="phonenumber" path="phonenumber" />
					<sf:errors class="error" path="phonenumber" />

					<br />
				</fieldset>
			</div>
			<input type="submit" name="submit" value="Place Order" id="submit" />
		</sf:form>
	</div>
	<!--End of wrap-->
</body>
</html>
