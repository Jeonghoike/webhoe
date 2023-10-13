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
	<h2>변수 선언 및 출력, 삭제</h2>
	<c:set var="varName" value="varValue" scope="page"/><!-- scope 생략시 page -->
	varName : ${varName }<br>
	<c:set var="varName" value="varValue <varValue>"/>
	varName : ${varName }(수정후)<br> <!-- 특수문자가 출력 못 함  -->
	<!-- escapeXml="true":특수문자 출력 -->
	varName : <c:out value="${varName }" escapeXml="true"/><br>
	<c:remove var="varName"/> <!-- varName 변수 삭제 -->
	varName : ${varName }(삭제 후에는 에러나지 않고 빈스트링으로 출력)<br>
	varName : ${empty varName ? "삭제되서 없음": varName }<br>
	varName : <c:out value="${varName }" default="삭제되서 없음"/>
</body>
</html>