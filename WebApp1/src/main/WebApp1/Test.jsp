<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date"%>
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

	<br>
	<%
		for (int i = 1; i <= 10; i++) {
		out.println(i + "<br>");
	}
	%>
	<br>

	<%
		for (int i = 1; i <= 10; i++) {
	%>

	<br>a is<%=i%>

	<%
		}
	%>
	<br>
	<br>

	<%
	List<String> names = new ArrayList<String>();
	names.add("a");
	names.add("b");
	names.add("c");
	%>

	<%
		for (String name : names) {
		out.println(name + "<br>");
	}
	%>

	<br> Date d=new Date();
	<br> Date and time=
	<%=new Date()%>
	<br>
	<br> Req,Res,Application/Context
	<%
		String name = request.getParameter("name");
	if (name != null) {
		session.setAttribute("sessionName", name);
		application.setAttribute("applicationName", name);
	}
	%>

	<br>
	<br> 
	Name of the request Scope = <%=name%><br> 
	Name of the session Scope = <% session.getAttribute("sessionName");%><br>
	Name of the	Application Scope= <%=application.getAttribute("applicationName")%>
</body>
</html>

<!-- insert web page using include -->
<%@ include file="/Test1.jsp" %>