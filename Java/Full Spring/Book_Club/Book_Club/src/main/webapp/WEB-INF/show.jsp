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
<title>Show Book</title>
</head>
<body>
	<h1><c:out value="${book.title}"></c:out></h1>
	<p><a href="/books">Back To The Shelves</a></p>
	<p><c:out value="${user.username}"></c:out> read <c:out value="${book.title}"></c:out> by <c:out value="${book.authorName}"></c:out>.</p>
	<p>Here are <c:out value="${user.username}"></c:out>'s thoughts:</p>
	<p><c:out value="${book.myThoughts}"></c:out></p>
	<div>
		<a href="/books/${book.id}/edit">Edit</a>
	</div>
	<div>
		<a href="/books/delete/${book.id}">Delete</a>
	</div>
</body>
</html>