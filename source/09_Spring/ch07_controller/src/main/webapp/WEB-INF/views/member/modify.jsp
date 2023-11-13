<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<h3>member의 modify.jsp입니다</h3>
	<form action="${conPath }/member?method=modify" method="post">
		<p>ID <input type="text" name="id" value="${member.id }"></p>
		<p>PW <input type="password" name="pw" value="${member.pw }"></p>
		<p><input type="submit" value="수정(POST)"></p>
	</form>
</body>
</html>