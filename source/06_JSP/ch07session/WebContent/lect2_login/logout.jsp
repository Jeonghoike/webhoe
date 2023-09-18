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
	<%
		String name = (String)session.getAttribute("name");
		if(name!=null){ // 로그인 상태
			// session.removeAttribute("name");
			// session.removeAttribute("id");
			session.invalidate();
			out.println("<h1>성공적으로 로그아웃되었습니다</h1>");
		}else{ // 비 로그인 상태
			out.println("<h1>로그인 상태가 아닙니다</h1>");
		}
	%>
	<button onclick="location.href='login.jsp'">로그인</button>
	<button onclick="location.href='welcome.jsp'">메인페이지</button>
	<button onclick="location.href='sessionList.jsp'">세션 들여다 보기</button>
</body>
</html>