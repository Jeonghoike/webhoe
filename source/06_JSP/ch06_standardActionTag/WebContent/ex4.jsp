<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%-- ex3_param.jsp?n=1을 요청할 때 올 페이지 --%>
	<h1>ex4.jsp페이지 입니다</h1>
	<h3>ex3의 request에서 넘어온n : <%=request.getParameter("n") %></h3>
	<h3>ex3의 param태그에서 넘어온 id : <%=request.getParameter("id") %></h3>
	<h3>ex3의 param태그에서 넘어온 pw : <%=request.getParameter("pw") %></h3>
</body>
</html>