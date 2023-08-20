<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Travel</title>
</head>
<body>
	<h1>Expense Details</h1>
	<p><a href="/expenses/">Go back</a></p>
	<table>
	    <tbody>
			<tr>
				<td>Expense Name:</td>
				<td><c:out value="${travels.expense}"></c:out></td>
			</tr>
			<tr>
				<td>Expense Description:</td>
				<td><c:out value="${travels.description}"></c:out></td>
			</tr>
			<tr>
				<td>Vendor:</td>
				<td><c:out value="${travels.vendor}"></c:out></td>
			</tr>
			<tr>
				<td>Amount Spent:</td>
				<td>$<c:out value="${travels.amount}"/></td>
			</tr>	
	    </tbody>
	</table>
</body>
</html>