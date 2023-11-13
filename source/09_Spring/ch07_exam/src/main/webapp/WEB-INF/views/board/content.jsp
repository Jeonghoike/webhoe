<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>board의 content.jsp페이지 입니다</h4>
	<h3>ID : ${id }</h3>
	<h3>PW : ${pw }</h3>
	<h3>member.id : ${member.id }</h3>
	<h3>member.pw : ${member.pw }</h3>
	<hr>
	<button onclick="history.go(-1)">뒤로가기</button>
</body>
</html>