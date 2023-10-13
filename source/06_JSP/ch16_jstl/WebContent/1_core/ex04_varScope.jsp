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
	<c:set var="code" value="80012" scope="page"/>
	<c:set var="name" value="온도계" scope="request"/>
	<c:set var="price" value="10000" scope="request"/>
	<h2>물품정보(ex04_varScope.jsp입니다)</h2>
	<h3>code : ${code }</h3>
	<h3>name : ${name }</h3>
	<h3>price : ${price }</h3>
	<%-- <jsp:forward page="ex05_varScope.jsp"/> --%>
	<c:redirect url="ex05_varScope.jsp"/>
</body>
</html>