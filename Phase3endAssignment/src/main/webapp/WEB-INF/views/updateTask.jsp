<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit your entry</title>
</head>
<body>
	
		<h1>Current Task is: </h1>
			<table border='1' style="width: 40%">
		<tr>
			<th>Task name</th>
			<th>Start Date</th>
			<th>End date</th>
			<th>Description</th>
			<th>Email</th>
			<th>Severity</th>
		</tr>
		
			<tr>
				<td>${task.taskName}</td>
				<td>${task.startDate}</td>
				<td>${task.endDate}</td>
				<td>${task.description}</td>
				<td>${task.email}</td>
				<td>${task.severity}</td>
			</tr>
	</table>
	<br>
	<br>
	<br>
	<form action = "/updateTask" method = "post">
		<input type = "text" name = "id" value=${task.id}><br>
		taskname: <input type = "text" name = "taskname"><br>
		start date: <input type = "date" name = "startdate"><br>
		end date: <input type = "date" name = "enddate"><br>
		description: <input type = "text" name = "description"><br>
		email: <input type = "text" name = "email"><br>
		severity: <input type = "text" name = "severity"><br><br>
		<button type = "submit">Submit</button>
	</form>
	
</body>
</html>
