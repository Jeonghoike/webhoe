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
	<c:set var="n1" value="${param.n1 }"/>
	<c:set var="n2" value="${param.n2 }"/>
	<c:set var="result" value="${param.result }"/>
	<p>
		${n1 } * ${n2 } = ${result }은
		<c:if test="${n1*n2 eq result }">
			정답입니다
		</c:if>
		<c:if test="${n1*n2 != result }" var="conditionResult">
			오답입니다
		</c:if>
	</p>
	<p>두번째 if문의 조건에 대한 결과 conditionResult : ${conditionResult }</p>
</body>
</html>