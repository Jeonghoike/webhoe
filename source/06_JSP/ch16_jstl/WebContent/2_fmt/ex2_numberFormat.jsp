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
	<c:set var="num" value="1234567.56"/>
	<p>num : ${num }</p>
	<p>세자리마다 , : <fmt:formatNumber value="${num }" groupingUsed="true"/></p>
	<p>num : <fmt:formatNumber value="${num }" pattern="#,###.###"/></p>
	<p>num : <fmt:formatNumber value="${num }" pattern="#,###.#"/></p>
	<p>num : <fmt:formatNumber value="${num }" pattern="00,000,000.000"/></p>
</body>
</html>