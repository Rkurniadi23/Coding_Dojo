<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<h1>Send an Omikuji!</h1>
	<div class="container">
		<form action="/process" method="post">
			<div>
				<label>Pick any number from 5 to 25</label>
	        	<input type="number" name="num"/>
			</div>
			<div>
				<label>Enter the name of any city.</label>
	        	<input type="text" name="city"/>
			</div>
			<div>
				<label>Enter the name of any real person</label>
	        	<input type="text" name="person"/>
			</div>
			<div>
				<label>Enter professional endeavor or hobby:</label>
	        	<input type="text" name="hobby"/>
			</div>
			<div>
				<label>Enter any type of living thing.</label>
	        	<input type="text" name="thing"/>
			</div>
			<div>
				<label>Say something nice to someone:</label>
	        	<textarea name="comment" cols="20" rows="3"></textarea>
			</div>
			<div>
				<p><em>Send and show a friend</em></p>
			</div>
			<div>
				<input type="submit" value="Send"/>
			</div>
		</form>
	</div>
</body>
</html>