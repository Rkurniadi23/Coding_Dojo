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
<title>Create Book</title>
</head>
<body>
	<h1>Add a Book To Your Shelf</h1><a href="/dashboard">Back To The Shelves</a>
	<br>
	<div>
		<form:form action="/books/create" method="post" modelAttribute="book">
			<div>
				<form:label path="title">Title: </form:label><br />
				<form:errors path="title" class="text-danger"/>
				<form:input style="width:250px;" path="title"/>
			</div>
		
			<div>
				<form:label path="authorName">Author: </form:label><br />
				<form:errors path="authorName" class="text-danger"/>
				<form:input style="width:250px;" path="authorName"/>
			</div>
			
			<div>
				<form:label path="myThoughts">My Thoughts: </form:label><br />
				<form:errors path="myThoughts" class="text-danger"/>
				<form:input style="width:250px;" path="myThoughts"/>
			</div>
			
			<div>
				<input type="submit" value="Submit"/>
			</div>

		</form:form>
	</div>
</body>
</html>