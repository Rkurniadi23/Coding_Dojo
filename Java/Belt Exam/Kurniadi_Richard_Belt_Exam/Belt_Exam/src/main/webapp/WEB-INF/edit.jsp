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
<title>Edit Table</title>
</head>
<body>
	<h1>Edit Table</h1><a href="/logout">log out</a>
	<br>
	<div>
		<form:form action="/tables/${guest.id}/edit/edit" method="put" modelAttribute="guest">
			<div>
				<form:label path="guestName">Guest Name: </form:label><br />
				<form:errors path="guestName" class="text-danger"/>
				<form:input style="width:250px;" path="guestName"/>
			</div>
		
			<div>
				<form:label path="numberOfGuests">Number of Guests: </form:label><br />
				<form:errors path="numberOfGuests" class="text-danger"/>
				<form:select path="numberOfGuests">
					<c:forEach var="i" begin="1" end="10">
            			<c:out value="${i}" />
            		</c:forEach>
            	</form:select>
			</div>
			
			<div>
				<form:label path="notes">Notes: </form:label><br />
				<form:errors path="notes" class="text-danger"/>
				<form:input style="width:250px;" path="notes"/>
			</div>
			
			<div>
				<a href="/tables/delete/${guest.id}">Delete Table</a>
				<a href="/home">Cancel</a>
				<input type="submit" value="Submit"/>
			</div>

		</form:form>
	</div>
</body>
</html>