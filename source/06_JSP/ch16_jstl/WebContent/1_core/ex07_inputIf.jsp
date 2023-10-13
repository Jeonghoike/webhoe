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
	<form action="ex07_resultIf.jsp">
		<p>
			<input type="text" size="1" name="n1" 
					value="<%=(int)(Math.random()*9) + 1 %>" readonly="readonly">
			*
			<input type="text" size="1" name="n2"
					value="<%=(int)(Math.random()*9) + 1 %>" readonly="readonly">
			=
			<input type="number" name="result" placeholder="정답">
		</p>
		<p>
			<input type="submit" value="확인">
		</p>
	</form>
</body>
</html>