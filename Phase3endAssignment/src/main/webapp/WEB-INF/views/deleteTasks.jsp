<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit your entry</title>
</head>
<body>
	
		<h1>Are you sure that you want to delete all your tasks?</h1>
		<br>
		<h3>Remember this is not reversible</h3>
		
		<form action = "deleteTasks" method = "post">
			Enter email to confirm: <input type="text" name = "email">
			<button type = submit>Submit</button>
		</form>
</body>
</html>
