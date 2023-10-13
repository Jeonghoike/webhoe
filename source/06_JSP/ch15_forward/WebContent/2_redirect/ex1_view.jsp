<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="member" class="com.lec.ex.Member" scope="page"/>
	<jsp:setProperty property="*" name="member"/>
	<h1>회원정보</h1>
	<h3>ID :${member.id }</h3>
	<h3>PW :${member.pw }</h3>
	<h3>NAME :${member.name }</h3>
	<br>
	<h3>ID :${param.id }</h3>
	<h3>PW :${param.pw }</h3>
	<h3>NAME :${param.name }</h3>
</body>
</html>