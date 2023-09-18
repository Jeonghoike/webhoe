<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../member/header.jsp"/>
	<%
		request.setCharacterEncoding("utf-8"); // post방식일 때만
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(id==null || !id.equals("aaa") || pw==null || !pw.equals("111")){
			response.sendRedirect(conPath+"/member/login.jsp?msg=");
		}else{
			session.setAttribute("id", id);
			session.setAttribute("name", "홍길동");
			response.sendRedirect("main.jsp");
		}
	%>
</body>
</html>















