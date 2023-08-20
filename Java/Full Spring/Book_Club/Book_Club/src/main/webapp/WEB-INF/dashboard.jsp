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
<title>Dashboard</title>
</head>
<body>
	<div class="container">
		<div class="left">
			<h1>Welcome, <c:out value="${user.username}"/></h1>
			<p>Books from everyone's shelves:</p>
		</div>
		<div class="right">
			<a href="/logout">logout</a>
			<a href="/books/new">+ Add a to my shelf!</a>
		</div>
	</div>
	<table class="table">
		<thead>
		    <tr>
		       	<th>ID</th>
		        <th>Title</th>
		        <th>Author Name</th>
		        <th>Posted By</th>
		    </tr>
		</thead>
		<tbody>
		<c:forEach var="book" items="${books}">
			<tr>
				<td><c:out value="${book.id}"/>
				<td><a href="/books/${book.id}"><c:out value="${book.title}"/></a>
				<td><c:out value="${book.authorName}"/>
				<td><c:out value="${user.username}"/>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>