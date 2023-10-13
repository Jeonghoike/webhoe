<%@page import="com.lec.friend.FriendDao"%>
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
	<jsp:useBean id="dto" class="com.lec.friend.FriendDto"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		FriendDao friendDao = FriendDao.getInstance();
		int insertResult = friendDao.insertFriend(dto);	
		if(insertResult == FriendDao.SUCCESS){
	%>		
			<script>
				alert('친구추가 성공');
				location.href='friendInputList.jsp';
			</script>
	<%	}else{%>
			<script>
				alert('친구추가 실해');
				location.href='friendInputList.jsp';
			</script>
	<%	}%>
</body>
</html>