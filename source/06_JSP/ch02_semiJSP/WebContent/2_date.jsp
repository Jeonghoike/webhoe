<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
		Date now = new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("yy년 MM월 dd일");
		String strNow = sdf.format(now) + "JSP 진도 시작";
	%>
	<p>strNow : <%=strNow %></p>
	<hr>
	<%@ include file="1_hello.jsp"%> <%--@지시자 --%>
</body>
</html>