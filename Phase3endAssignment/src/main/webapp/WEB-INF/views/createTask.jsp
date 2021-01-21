<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit your entry</title>
</head>
<body>
	<h1>Hello please create a task</h1>
	<br>
	<br>
	
	<form action="createTask" method="post">
		<!-- to do: make it so that the userID is passed somehow to the method -->
		Task name: <input type=" text" name="taskname"> <br>
		Start Date: <input type="date" name="startdate"> <br>
		End Date: <input type="date" name="enddate"> <br>
		Description: <input type="text" name="description"> <br>
		Email: <input type="text" name="email"> <br>
		Severity: <input list="severity" name="severity"> 
		    <datalist  id="severity">
		    <option value="High" selected="selected">
		    <option value="Medium">
		    <option value="Low">
		    </datalist>
		<br><br>
		<button>Create Task</button>
	</form>
	
	
	


</body>
</html>
