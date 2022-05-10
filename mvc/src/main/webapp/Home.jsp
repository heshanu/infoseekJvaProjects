<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home page</title>
</head>
<body>

	<c:forEach var="i" begin="1" end="10" step="1">
		<li>${i}
	</c:forEach>
	<br>
	<c:out value="test message"></c:out>
	<div></div>
	
	Welcome 1 <%=session.getAttribute("fullName") %>! <br>
	<br>
	Welcome 1:<jsp:useBean id="fullName" class=java.lang.String" scope="session"></jsp:useBean>
	<c:out value="${sessionScope.fullName}"></c:out>

<% %>
<% %>
	Welcome
	<%=session.getAttribute("fullName")%>!

	<%
		UserDTO userdto = (UserDTO) session.getAttribute("userDTO");
	%>

	user details user Id-
	<%=userdto.getUserId()%>
	Address-
	<%=userdto.getAddress()%>
	Contact No-<%=userdto.getContactNo()%>


</body>
</html>