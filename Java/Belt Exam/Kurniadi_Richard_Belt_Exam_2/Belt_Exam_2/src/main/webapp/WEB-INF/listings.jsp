<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Listing</title>
</head>
<body>
	<h1><c:out value="${house.address}"></c:out></h1>
	<a href="/home">dashboard</a>
	<div>
		<p>Address: <c:out value="${house.address}"/></p>
		<p>Listing Date: <fmt:formatDate value="${house.createdAt}" pattern="yyyy/MM/dd"/></p>
		<p>Price: $<c:out value="${house.price}"/></p>
	</div>
	<div>
	<c:if test = "${user.id==house.user.id}">
		<a href="/listings/${house.id}/edit">Edit</a>
		<a href="/house/delete/${house.id}">Delete</a>
	</c:if>
	</div>
</body>
</html>