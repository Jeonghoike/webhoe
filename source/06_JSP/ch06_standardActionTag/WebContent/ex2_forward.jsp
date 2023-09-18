<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%-- ex1_forward.jsp?n=1을 요청할 때 페이지 --%>
	<h2>ex2_forward.jsp페이지입니다</h2>
	<%
		String n = request.getParameter("n");
	%>
	<h2>ex1에서 요청한n : <%=n %></h2>
	
</body>
</html>