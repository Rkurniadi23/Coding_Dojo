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
<title>Edit Listing</title>
</head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="styleshee" type="text/css" href="/css/style.css">
<body>
	<h1>Edit Listing</h1>
	<a href="/home">dashboard</a>
	<br>
	<div>
		<form:form action="/listings/${house.id}/edit/edit" method="put" modelAttribute="house">
			<table>
		    <thead>
		    	<tr>
		            <td class="float-left">Address:</td>
		            <td class="float-left">
		            	<form:errors path="address" class="text-danger"/>
						<form:input class="input" path="address"/>
		            </td>
		        </tr>
		        <tr>
		            <td class="float-left">Price:</td>
		            <td class="float-left">
		            	<form:errors path="price" class="text-danger"/>
						<form:input type="number" class="input" path="price"/>
		            </td>
		        </tr>	
		        <tr>
		            <td class="float-left">Listing Date:</td>
		            <td class="float-left">
		            	<form:errors path="createdAt" class="text-danger"/>
						<form:input type="date" class="input" path="createdAt"/>
		            </td>
		        </tr>	
				<tr>
		        	<td colspan=2><input class="input" type="submit" value="Submit"/></td>
		        </tr>
		    </thead>
		</table>
		<div>
				<a href="/house/delete/${house.id}">Delete</a>
		</div>

		</form:form>
	</div>
</body>
</html>