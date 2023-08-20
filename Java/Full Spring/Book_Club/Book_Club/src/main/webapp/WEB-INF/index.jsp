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
<title>Welcome Page</title>
</head>
<body>
	<h1>Book Club</h1>
	<p>A place for friends to share thoughts on books.</p>
	<div class="container d-flex justify-content-between">
		<div class="register">
			<form:form class="form" action="/register" method="post" modelAttribute="newUser">
				<h2>Register</h2>
				<div class="form-row">
					<form:label path="username">Name: </form:label>
					<form:errors path="username"/>
					<form:input type="text" path="username"/>				
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
			<form:form class="form" action="/login" method="post" modelAttribute="newLogin">
				<h2>Login</h2>
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