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
	<h3><b>"현재 총 ${cnt }명"</b></h3><br>
	<h3>결과는 다음과 같습니다</h3><br>
	<h3>이름 : ${student.name }</h3><br>
	<h3>국어 : ${student.kor }</h3><br>
	<h3>영어 : ${student.eng }</h3><br>
	<h3>수학 : ${student.eng }</h3><br>
	<h3>총점 : ${student.totscore }</h3><br>
	<h3>평균 : ${student.avg }</h3><br>
	<button onclick="history.back()">뒤로가기</button>
	<button onclick="location.href='${conPath}'">다시입력</button>
</body>
</html>