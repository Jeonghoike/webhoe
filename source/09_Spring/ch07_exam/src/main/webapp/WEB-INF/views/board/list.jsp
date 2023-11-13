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
	<h4>board의 list.jsp페이지입니다</h4>
	<c:if test="${list.size() eq 0 }">
		<h3>추가된 member가 없습니다</h3>
	</c:if>
	<c:if test="${list.size() != 0 }">
		<c:forEach items="${list }" var="member">
			<h3>ID : ${member.id } / PW : ${member.pw }</h3>
		</c:forEach>
		<h4>이상 추가된 member는 ${list.size() }명 입니다.</h4>
	</c:if>
	<hr>
	<h4 onclick="history.go(-1)">이전 페이지로 가기</h4>
</body>
</html>