<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="styleshee" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h1>Welcome, <c:out value="${user.userName}"/>!</h1>
	<div>
		<a href="/logout">log out</a>
	</div>
	<table class="table">
		<thead>
		    <tr>
		       	<th>Address</th>
		        <th>Listed On</th>
		        <th>Added By</th>
		        <th>Price</th>
		    </tr>
		</thead>
		<tbody>
		<c:forEach var="house" items="${house}">
			<tr>
				<td><a href="/listings/${house.id}"><c:out value="${house.address}"/></a>
				<td><fmt:formatDate value="${house.createdAt}" pattern="yyyy/MM/dd"/>
				<td><c:out value="${house.user.userName}"/>
				<td>$<c:out value="${house.price}"/>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<a href="/listings/new" class="btn btn-light" role="button">Add Listing</a>
</body>
</html>