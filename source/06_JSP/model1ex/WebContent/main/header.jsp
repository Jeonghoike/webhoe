<%@page import="com.lec.dto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/header.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
		<div class="gnb">
		<% CustomerDto customer = (CustomerDto)session.getAttribute("customer"); %>
		<%if(customer==null){  // 로그인전 메뉴(우측부터) : 고객센터, 회원가입, 로그인  %>
				<ul>
					<li><a href="<%=conPath %>/fileboard/fboardList.jsp">고객센터</a></li>
					<li><a href="<%=conPath %>/customer/joinForm.jsp">회원가입</a></li>
					<li><a href="<%=conPath%>/customer/loginForm.jsp">로그인</a></li>
				</ul>
		<%}else{ // 로그인 후 메뉴(우측부터) : 고객센터, 로그아웃, 정보수정, 고객이름%>
				<ul>
					<li><a href="<%=conPath %>/fileboard/fboardList.jsp">고객센터</a></li>
					<li><a href="<%=conPath%>/customer/logout.jsp">로그아웃</a></li>
					<li><a href="<%=conPath %>/customer/modifyForm.jsp">정보수정</a></li>
					<li><a href="<%=conPath%>/main/main.jsp"><%=customer.getCname() %>님</a></li>
				</ul>
		<%}%>		
		</div>
		<div class="logo" onclick="location.href='<%=conPath%>/main/main.jsp'">
			<img src="http://www.moel.go.kr/images/layout/logo.png" alt="로고">
		</div>
		<div class="lnb">
			<!-- 우측부터 메뉴 : 도서보기, 도서등록(로그인후) -->
			<ul>
				<li><a href="<%=conPath %>/book/bookList.jsp">도서보기</a></li>
				<%if(customer!=null){ %>
					<li><a href="<%=conPath%>/book/bookRegister.jsp">도서등록</a></li>
				<%} %>
			</ul>
		</div>
	</header>
</body>
</html>