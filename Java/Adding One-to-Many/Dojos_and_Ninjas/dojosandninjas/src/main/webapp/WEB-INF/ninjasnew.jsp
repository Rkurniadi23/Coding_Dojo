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
<title>New Ninja</title>
</head>
<body>
	<h1>New Ninja</h1>
	<div>
		<form:form action="/ninjas/create" method="POST" modelAttribute="ninja">
		<form:select path="dojo">
			<c:forEach var="dojo" items="${dojos}">
				<option value="${dojo.id}">${dojo.name}</option>
			</c:forEach>
		</form:select>	
		<form:label path="firstName">First Name: </form:label>
		<form:errors path="firstName"/>
		<form:input type="text" path="firstName"/>
		<form:label path="lastName">Last Name: </form:label>
		<form:errors path="lastName"/>
		<form:input type="text" path="lastName"/>
		<form:label path="age">Age: </form:label>
		<form:errors path="age"/>
		<form:input type="number" path="age"/>
		<input type="submit" value="Create">
		</form:form>	
	</div>

</body>
</html>