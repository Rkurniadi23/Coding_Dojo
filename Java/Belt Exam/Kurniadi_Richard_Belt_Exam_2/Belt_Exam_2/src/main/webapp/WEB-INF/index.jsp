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
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="styleshee" type="text/css" href="/css/style.css">
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1>Welcome, House Hunter!</h1>
	<form:form class="form" action="/register" modelAttribute="newUser">
		<table>
			<thead>
		    	<tr>
		            <td colspan="2">Register</td>
		        </tr>
		    </thead>
		    <thead>
		    	<tr>
		            <td class="float-left">User Name:</td>
		            <td class="float-left">
		            	<form:errors path="userName" class="text-danger"/>
						<form:input class="input" path="userName"/>
		            </td>
		        </tr>
		        <tr>
		            <td class="float-left">Email:</td>
		            <td class="float-left">
		            	<form:errors path="email" class="text-danger"/>
						<form:input class="input" path="email"/>
		            </td>
		        </tr>
		        <tr>
		            <td class="float-left">Password:</td>
		            <td class="float-left">
		            	<form:errors path="password" class="text-danger"/>
						<form:input type ="password" class="input" path="password"/>
		            </td>
		        </tr>
		        <tr>
		            <td class="float-left">Confirm PW:</td>
		            <td class="float-left">
		            	<form:errors path="confirm" class="text-danger"/>
						<form:input type ="password" class="input" path="confirm"/>
		            </td>
		        </tr>
		        <tr>
		        	<td colspan=2><input class="input" type="submit" value="Register"/></td>
		        </tr>
		    </thead>
		</table>
	</form:form>
	<hr>
	<form:form class="form" action="/login" modelAttribute="newLogin">
				<table>
			<thead>
		    	<tr>
		            <td colspan="2">Register</td>
		        </tr>
		    </thead>
		    <thead>
		        <tr>
		            <td class="float-left">Email:</td>
		            <td class="float-left">
		            	<form:errors path="email" class="text-danger"/>
						<form:input class="input" path="email"/>
		            </td>
		        </tr>
		        <tr>
		            <td class="float-left">Password:</td>
		            <td class="float-left">
		            	<form:errors path="password" class="text-danger"/>
						<form:input type ="password" class="input" path="password"/>
		            </td>
		        </tr>
		        <tr>
		        	<td colspan=2><input class="input" type="submit" value="Log in"/></td>
		        </tr>
		    </thead>
		</table>
	</form:form>
</body>
</html>