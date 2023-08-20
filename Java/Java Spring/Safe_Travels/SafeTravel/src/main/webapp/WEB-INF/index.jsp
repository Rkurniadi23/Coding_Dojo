<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Safe Travels</title>
</head>
<body>
	<h1>Save Travels</h1>
	<table class="table">
	    <thead>
	        <tr>
	            <th>Expense</th>
	            <th>Vendor</th>
	            <th>Amount</th>
	            <th>Actions</th>
	        </tr>
	    </thead>
	    <tbody>
			<c:forEach var="travel" items="${travels}">
				<tr>
					<td><a href="/expenses/<c:out value="${travel.id}"></c:out>"><c:out value="${travel.expense}"></c:out></a></td>
					<td><c:out value="${travel.vendor}"></c:out></td>
					<td>$<c:out value="${travel.amount}"></c:out></td>
					<td ><a href="/expenses/edit/${travel.id}">edit</a> <a href="/expenses/delete/${travel.id}">delete</a></td>
				</tr>	
			</c:forEach>
	    </tbody>
	</table>
	<h1>Add an expense:</h1>
	<form:form action="/expenses" method="post" modelAttribute="travel">
		<div>
			<form:label path="expense">Expense Name: </form:label>
			<form:errors path="expense"/>
			<form:input path="expense"/>
		</div>
		<div>
			<form:label path="vendor">Vendor: </form:label>
			<form:errors path="vendor"/>
			<form:input path="vendor"/>
		</div>
		<div>
			<form:label path="amount">Amount: </form:label>
			<form:errors path="amount"/>
			<form:input path="amount"/>
		</div>
		<div>
			<form:label path="description">Description: </form:label>
			<form:errors path="description"/>
			<form:input path="description"/>
		</div>
		<div>
			<input type="submit" value="Submit"/>
		</div>
	</form:form>
</body>
</html>