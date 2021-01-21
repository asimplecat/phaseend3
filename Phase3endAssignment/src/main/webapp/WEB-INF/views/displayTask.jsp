<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Look at your tasks</title>
</head>
<body>
		
		
			
			<table border='1' style="width: 40%">
		<tr>
			<th>Task name</th>
			<th>Start Date</th>
			<th>End date</th>
			<th>Description</th>
			<th>Email</th>
			<th>Severity</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${Tasklist}" var="result">
			<tr>
				<td>${result.taskName}</td>
				<td>${result.startDate}</td>
				<td>${result.endDate}</td>
				<td>${result.description}</td>
				<td>${result.email}</td>
				<td>${result.severity}</td>
				<td><a type="button" class="btn btn-warning"
			href="/updateTask/${result.id}">Update</a></td>
			<td><a type="button" class="btn btn-danger"
			href="/deleteTask/${result.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
		<br>
		<br>
		<br>
		
		<a href="/createTask">create more tasks</a>
		
		<a href="/deleteTasks">delete all your tasks</a>
	
</body>
</html>
