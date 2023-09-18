<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="../member/header.jsp"/>
	<div id="mainForm_wrap">
		main 화면
	</div>
	<jsp:include page="../member/footer.jsp"/>
</body>
</html>