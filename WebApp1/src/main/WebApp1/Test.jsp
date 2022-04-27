<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP</title>
</head>
<body>

	<h2>this is heading</h2>
	<br>
	<%
		int a = 1;
	int b = 2;
	int c = 10;
	out.print(c);
	%>
	<br>
	<%!public int addNum(int a, int b) {
		return a + b;
	}%>
	<br> Addtion is :<%=addNum(1, 2)%>
	<br>

	

</body>
</html>