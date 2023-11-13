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
	<h4>board의 reply.jsp페이지입니다</h4>
	<h3>${member.id } / ${member.pw }</h3>
	<form action="${conPath }/board/reply" method="post">
		<input type="submit" value="reply(POST)">
	</form>
	
</body>
</html>