<%@page import="com.lec.friend.FriendDto"%>
<%@page import="java.util.ArrayList"%>
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
	<form action="friendInputListPro.jsp">
		<p>
			이름<input type="text" name="name" required="required">
			전화<input type="text" name="tel">
			<input type="submit" value="추가">
		</p>
	</form>
	<table>
		<tr>
			<th>순서</th><th>이름</th><th>전화</th>
		</tr>
		<%
			FriendDao friendDao = FriendDao.getInstance();
			ArrayList<FriendDto> friends = friendDao.listFriends();
			for(FriendDto friend : friends){
				String tel = friend.getTel();
				out.println("<tr>");
				out.println("<td>" + friend.getNo() + "</td>");
				out.println("<td>" + friend.getName() + "</td>");
				out.println("<td>" + (tel==null? "" :tel) + "</td>");
				out.println("</tr>");
			}
		%>
	</table>
</body>
</html>