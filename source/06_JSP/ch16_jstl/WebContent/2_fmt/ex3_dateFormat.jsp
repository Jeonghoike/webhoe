<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
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
	<c:set var="nowDate" value="<%=new Date(System.currentTimeMillis()) %>"/>
	<c:set var="nowTimes" value="<%=new Timestamp(System.currentTimeMillis()) %>"/>
	<c:set var="nowDateUtil" value="<%=new java.util.Date() %>"/>
	${nowDate }<br>
	${nowTimes }<br>
	${nowDateUtil }<br>
	<hr>
	<h4>날짜만 출력(short, medium, long, full)</h4>
	short : <fmt:formatDate value="${nowDate }" type="date" dateStyle="short"/><br>
	short : <fmt:formatDate value="${nowTimes }" type="date" dateStyle="short"/><br>
	short : <fmt:formatDate value="${nowDateUtil }" type="date" dateStyle="short"/><br>
	medium : <fmt:formatDate value="${nowDate }" type="date" dateStyle="medium"/><br>
	long : <fmt:formatDate value="${nowDate }" type="date" dateStyle="long"/><br>
	full : <fmt:formatDate value="${nowDate }" type="date" dateStyle="full"/><br>
	<hr>
	<h4>시간만 출력(short, medium, long, full)</h4>
	short : <fmt:formatDate value="${nowTimes }" type="time" timeStyle="short"/><br>
	medium : <fmt:formatDate value="${nowTimes }" type="time" timeStyle="medium"/><br>
	long : <fmt:formatDate value="${nowTimes }" type="time" timeStyle="long"/><br>
	full : <fmt:formatDate value="${nowTimes }" type="time" timeStyle="full"/><br>
	<hr>
	<h4>날짜와 시간 모두 출력</h4>
	<fmt:formatDate value="${nowDate }" type="both" dateStyle="long" timeStyle="short"/><br>
	<fmt:formatDate value="${nowDate }" pattern="yy년 MM월 dd일(E요일) HH:mm:ss:SSS"/><br>
	<fmt:formatDate value="${nowDate }" pattern="yy년 MM월 dd일(E요일) a hh:mm:ss:SSS"/><br>
	<fmt:formatDate value="${nowTimes }" pattern="MM월dd일"/><br>
	<fmt:formatDate value="${nowTimes }" pattern="M월d일"/>
</body>
</html>