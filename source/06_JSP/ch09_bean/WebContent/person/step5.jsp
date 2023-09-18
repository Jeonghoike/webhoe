<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!-- 프로세스단 -->
	<jsp:useBean id="p" class="com.lec.ex.Person" scope="request"/>
	<jsp:setProperty property="*" name="p"/>
	<jsp:forward page="personView.jsp"/>
</body>
</html>