<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Travel</title>
</head>
<body>
	<h1>Edit Expense</h1><a href="/expenses/">Go back</a>
	<div>
		<h1>Expense</h1>
		<form action="/expenses/edit/${travels.id}" method="post">
			<div>
				<label>Expense Name: </label>
				<input type="text" name="expense"/>
			</div>
		
			<div>
				<label>Vendor: </label>
				<input type="text" name="vendor"/>
			</div>
			
			<div>
				<label>Amount: </label><br />
				<input type="number" name="amount"/>
			</div>
			<div>
				<label>Description: </label><br />
				<input type="text" name="description"/>
			</div>
			<div>
				<input type="submit" value="Submit"/>
			</div>
		</form>
	</div>
</body>
</html>