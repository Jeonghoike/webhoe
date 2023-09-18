<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>ex5_include.jsp페이지입니다</h1>
	<%--  
	<%@ include file="includedPage.jsp" %> jsp파일의 원본 그대로 include (conPath 중복X)
	--%>
	<jsp:include page="includedPage.jsp"/> <%-- jsp파일의 결과 --%>
	<h1>ex5_include.jsp페이지입니다</h1>
</body>
</html>