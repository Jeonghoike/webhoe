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
	<h2>어떤 요청이 들어와도 cnt, list는 model에 add됨</h2>
	<h4>cnt : ${cnt }</h4>
	<h4>list : ${list }</h4>
	<h2>result1.jsp페이지 입니다(join2)</h2>
	<h4>이름 : ${name }</h4>
	<h4>아이디 : ${id }</h4>
	<h4>비밀번호 : ${pw }</h4>
	<h4>나이 : ${age }</h4>
	<h4>메일 : ${email }</h4>
	<h4>주소 : ${address }</h4>
	<button onclick="history.back()">뒤로가기</button>
	<button onclick="location.href='${conPath}'">다시입력</button>
</body>
</html>