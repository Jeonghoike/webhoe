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
	<h3>GET방식으로 보내기</h3>
	<form action="${conPath }/student.do" method="get">
		ID <input type="text" name="id">
		<input type="submit" value="get방식으로 보내기">
	</form>
	<h3>POST방식으로 보내기</h3>
	<form action="${conPath }/student.do" method="post">
		ID <input type="text" name="id">
		<input type="submit" value="post방식으로 보내기">
	</form>
	<h2>
		redirect, forward 키워드 예제
		<button onclick="location.href='${conPath}/studentOk.do?id=hong'">
			studentOk.do
		</button>
		<button onclick="location.href='${conPath}/studentNg.do'">
			studentNg.do
		</button>
	</h2>
	<form action="${conPath }/idConfirm.do" method="post">
		ID <input type="text" name="id">
		<input type="submit" value="id confirm">
	</form><br><br>
	<a href="${conPath }/fullPath.do">FullPath로 가기(redirect 키워드 예제)</a>
</body>
</html>