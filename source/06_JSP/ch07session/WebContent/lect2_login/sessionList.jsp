<%@page import="java.util.Enumeration"%>
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
	Enumeration<String> sAttrNames =  session.getAttributeNames();
	int cnt =0;
	while(sAttrNames.hasMoreElements()){
		cnt++;
		String sname = sAttrNames.nextElement();
		String svalue = session.getAttribute(sname).toString();
		out.println("<h2>" + cnt + "." + sname + "(세션속성이름) : " + svalue +  "(세션값)</h2>");
	} // while
	if(cnt==0){
		out.println("<h2>세션 속성이 없습니다</h2>");
	}
	%>
	<button onclick="history.go(-1)">이전페이지</button>
	<button onclick="location.href='login.jsp'">로그인</button>
	<button onclick="location.href='logout.jsp'">로그아웃</button>
	<button onclick="location.href='welcome.jsp'">메인페이지</button>
	<button onclick="location.href='sessionList.jsp'">세션 들여다 보기</button>
</body>
</html>