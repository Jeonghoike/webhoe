<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="<%=conPath %>/ex1_servlet" method="post">
		<p>ID <input type="text" name="id"></p>
		<p>PW <input type="password" name="pw"></p>
		<p>name <input type="text" name="name"></p>
		<p><input type="submit"></p>
	</form>	
</body>
</html>