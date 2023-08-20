<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tables</title>
</head>
<body>
		<div class="container">
		<div class="left">
			<h1>All Tables</h1>
			<h3>Tables</h3>
		</div>
		<div class="right">
			<a href="home">home</a>
		</div>
	</div>
	<table class="table">
		<thead>
		    <tr>
		       	<th>Guest Name</th>
		        <th># Guests</th>
		        <th>Arrived At</th>
		        <th>Server</th>
		    </tr>
		</thead>
		<tbody>
		<c:forEach var="guest" items="${guests}">
			<tr>
				<td><c:out value="${guest.guestName}"/>
				<td><c:out value="${guest.numberOfGuests}"/>
				<td><c:out value="${guest.createdAt}"/>
				<td><c:out value="${guest.server.name}"/>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>