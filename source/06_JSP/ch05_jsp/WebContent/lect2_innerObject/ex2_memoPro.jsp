<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
	// post 요청시 request 파라미터 한글처리
		request.setCharacterEncoding("utf-8");
		String writer = request.getParameter("writer");
		String memo   = request.getParameter("memo");
		String ip     = request.getRemoteAddr(); // 요청한 클라이언트의 ip주소
		Date   date   = new Date(System.currentTimeMillis()); //요청한 날짜
		Timestamp now = new Timestamp(System.currentTimeMillis()); // 요청한 시점
	%>
	<h2>글쓴이 : <%=writer %></h2>
	<h2>한줄메모 : <%=memo %></h2>
	<h2>글쓴이 IP : <%=ip %></h2>
	<h2>글쓴날짜 : <%=date %></h2>
	<h2>글쓴시점 : <%=now %></h2>
</body>
</html>