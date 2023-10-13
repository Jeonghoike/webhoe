<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<c:if test="${insertResult eq SUCCESS }">
		<script>alert('입력성공');</script>
	</c:if>
	<c:if test="${insertResult eq FAIL }">
		<script>alert('입력실패');</script>
	</c:if>
	<c:if test="${updateResult eq SUCCESS }">
		<script>alert('수정성공');</script>
	</c:if>
	<c:if test="${updateResult eq FAIL }">
		<script>alert('수정실패');</script>
	</c:if>
	<c:if test="${not empty deleteResult }">
		<script>alert('${deleteResult}');</script>
	</c:if>
	<h1>select.jsp입니다</h1>
	<h2>select 결과 : ${list }(내일은 forEach이용해서 테이블에 출력)</h2>
</body>
</html>