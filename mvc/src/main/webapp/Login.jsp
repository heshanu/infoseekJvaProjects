<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<form action="LoginController" method="post">
<fieldset>
<legend>LogIn</legend>
	<label>UserName</label>	
	<input type="text" placeholder="username" name="username"><br>
	<label>Password</label>
	<input type="password" placeholder="password" name="password">
	
	<button type="button">submit</button>
</fieldset>
</form>

</body>
</html>