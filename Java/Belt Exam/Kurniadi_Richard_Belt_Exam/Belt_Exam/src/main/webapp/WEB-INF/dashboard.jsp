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
<title>Home</title>
</head>
<body>
	<div class="container">
		<div class="left">
			<h1>Welcome back, <c:out value="${server.name}"/>.</h1>
		</div>
		<div class="right">
			<a href="/logout">log out</a>
		</div>
	</div>
	<table class="table">
		<h2>Your Tables</h2>
		<thead>
		    <tr>
		       	<th>Guest Name</th>
		        <th># Guests</th>
		        <th>Arrived At</th>
		        <th>Actions</th>
		    </tr>
		</thead>
		<tbody>
		<c:forEach var="guest" items="${guests}">
			<tr>
				<c:if test = "${server.id==guest.server.id}">
				<td><c:out value="${guest.guestName}"/>
				<td><c:out value="${guest.numberOfGuests}"/>
				<td><c:out value="${guest.createdAt}"/>
				<td><a href="/tables/delete/${guest.id}">finished</a> <a href="/tables/${guest.id}/edit">edit</a>
				</c:if>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<a href="/tables/new">+ new table</a>
	<a href="/tables">See Other Tables</a>
</body>
</html>