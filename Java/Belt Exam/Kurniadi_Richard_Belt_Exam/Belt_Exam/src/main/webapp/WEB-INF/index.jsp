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
<title>Login Page</title>
</head>
<body>
	<h1>Table Master</h1>
	<div class="container d-flex justify-content-between">
		<div class="register">
			<form:form class="form" action="/register" modelAttribute="newServer">
				<h2>New Waitstaff</h2>
				<div class="form-row">
					<form:label path="name">Name: </form:label>
					<form:errors path="name"/>
					<form:input type="text" path="name"/>				
				</div>
				<div class="form-row">
					<form:label path="email">Email: </form:label>
					<form:errors path="email"/>
					<form:input type="text" path="email"/>
				</div>
				<div class="form-row">
					<form:label path="password">Password: </form:label>
					<form:errors path="password"/>
					<form:input type="password" path="password"/>
				</div>
				<div class="form-row">
					<form:label path="confirm">Confirm PW: </form:label>
					<form:errors path="confirm"/>
					<form:input class="input" type="password" path="confirm"/>
				</div>
				<div class="form-row">
					<input type="submit" value="register">
				</div>
			</form:form>
		</div>
		<div class="login">
			<form:form class="form" action="/login" modelAttribute="newLogin">
				<h2>Log in</h2>
				<div class="form-row">
					<form:label path="email">Email: </form:label>
					<form:errors path="email"/>
					<form:input type="text" path="email"/>
				</div>
				<div class="form-row">
					<form:label path="password">Password: </form:label>
					<form:errors path="password"/>
					<form:input type="password" path="password"/>
				</div>
				<div class="form-row">
					<input type="submit" value="Submit"/>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>