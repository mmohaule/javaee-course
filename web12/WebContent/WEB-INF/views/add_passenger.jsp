<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>World Adventures Airlines</title>
<link rel="stylesheet" href="resources/css/normalize.css" />
<link rel="stylesheet" href="resources/css/theme.css" />
</head>

<body>
	<div class="container">

		<%
			if (request.getAttribute("errors") != null) {
		%>
		<fieldset>
			<legend>Errors</legend>
			<ul>

				<%
					if (request.getAttribute("firstname_error") != null) {
				%>
				<li class="error">Firstname Error</li>
				<%
					}
				%>

				<%
					if (request.getAttribute("lastname_error") != null) {
				%>
				<li class="error">Lastname Error</li>
				<%
					}
				%>

				<%
					if (request.getAttribute("date_error") != null) {
				%>
				<li class="error">Invalid Date Error</li>
				<%
					}
				%>
			</ul>
		</fieldset>
		<%
			}
		%>
		<div class="title">Add Passenger</div>
		<fieldset>
			<legend>Passenger Details</legend>
			<form action="AddPassenger" method="post">
				<div class="inputfield">
					<label for="firstname" class="inpulabel">First Name: </label> <input
						name="firstname" type="text"
						value="<%=request.getAttribute("firstname")%>"></input>
				</div>
				<div class="inputfield">
					<label for="lastname" class="inpulabel">Last Name: </label> <input
						name="lastname" type="text"></input>
				</div>
				<div class="inputfield">
					<label for="dob" class="inpulabel">Date of Birth: </label> <input
						name="dob" type="text"></input>
				</div>
				<div class="inputfield">
					<label for="gender" class="inpulabel">Gender: </label> <select
						name="gender">
						<option value="Male">Male</option>
						<option value="Female">Female</option>
					</select>
				</div>
				<div class="inputfield">
					<input name="submit" type="submit" value="Add Passenger"></input>
				</div>

			</form>
		</fieldset>
	</div>
</body>

</html>