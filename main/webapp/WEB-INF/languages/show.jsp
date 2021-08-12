<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${language.name}"/></title>
</head>
<body>
	<a href="/languages">Dashboard</a>
	<div>
		<h1><c:out value="${language.name}"/></h1>
		<h1><c:out value="${language.creator}"/></h1>
		<h1><c:out value="${language.version}"/></h1>
	</div>
	<p>
		<a href="/languages/edit/${language.id}"> edit </a>
	</p>
	<form action="/delete/${language.id}" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input type="submit" value="Delete">
	</form>

	
</body>
</html>