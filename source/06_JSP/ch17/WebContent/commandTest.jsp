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
	<%
		StringBuffer url = request.getRequestURL();
		String uri = request.getRequestURI(); // "/ch17/commandTest.jsp"
		String conPath = request.getContextPath(); // "/ch17"
		String command = uri.substring(conPath.length()); // "/commandTest.jsp"
	%>
	URL : <%=url %><br>
	URI : <%=uri %><br>
	conPath : <%=conPath %><br>
	command : <%=command %>
</body>
</html>