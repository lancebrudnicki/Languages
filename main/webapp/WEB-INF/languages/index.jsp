<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>action</th>
			</tr>
		</thead>
		<tbody>
		<!-- this is our for loop to display the languages in our table -->
			<c:forEach items="${languages}" var="langauge">
				<tr>
					<td><a href="/languages/${langauge.id}"><c:out value="${langauge.name}"/></a></td>
					<td><c:out value="${langauge.creator}"/></td>
					<td><c:out value="${langauge.version}"/></td>
					<td>
						<form action="/delete/${langauge.id}" method="post">
		    				<input type="hidden" name="_method" value="delete">
		    				<input type="submit" value="Delete">
						</form>
					</td>
					<td><a href="/languages/edit/${langauge.id}"> edit </a></td>
				</tr>
			</c:forEach>
			<!-- end the loop  -->
		</tbody>	
	</table>
	
	<!-- This is the form to create a new language Remember to make a form:form	-->
	<form:form action="/languages" method="post" modelAttribute="language">
	    <p>
	        <form:label path="name">Name</form:label>
	        <form:errors path="name"/>
	        <form:input path="name"/>
	    </p>
	    <p>
	        <form:label path="creator">Creator</form:label>
	        <form:errors path="creator"/>
	        <form:textarea path="creator"/>
	    </p>
	    <p>
	        <form:label path="version">Version</form:label>
	        <form:errors path="version"/>
	        <form:input path="version"/>
	    </p>  
	    <input type="submit" value="Submit"/>
	</form:form> 

</body>
</html>