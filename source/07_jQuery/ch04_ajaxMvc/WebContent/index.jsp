<%@page import="java.net.URLEncoder"%>
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
		//String pname = URLEncoder.encode("공책","utf-8");
		//response.sendRedirect("productStock.do?pname=" + pname );
		response.sendRedirect("midConfirm.do?mid=son");
	%>
</body>
</html>