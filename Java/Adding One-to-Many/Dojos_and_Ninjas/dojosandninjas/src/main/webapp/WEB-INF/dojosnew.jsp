<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Dojo</title>
</head>
<body>
	<h1>New Dojo</h1>
	<div>
		<form:form action="/dojos/create" method="POST" modelAttribute="dojo">
		<form:label path="name">Name: </form:label>
		<form:errors path="name"/>
		<form:input type="text" path="name"/>
		<input type="submit" value="Create">
		</form:form>		
	</div>
</body>
</html>