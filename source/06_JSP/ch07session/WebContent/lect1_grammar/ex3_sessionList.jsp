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
		// 세션의 추가힌 모든 데이터 list
		out.println("<h1>모든 세션 속성들</h1>");
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
	<hr>
	<h2>세션 ID : <%=session.getId() %></h2>
	<h2>세션 유효기간 : <%=session.getMaxInactiveInterval() %></h2>
	<hr>
	<a href="ex1_sessionAddAttr.jsp">1. 세션 데이터 추가</a><br>
	<a href="ex2_sessionGet.jsp">2. 특정세션 get</a><br>
	<a href="ex3_sessionList.jsp">3. 세션의 모든 데이터 리스트</a><br>
	<a href="ex4_sessionRemove.jsp">4. 세션 삭제(특정 세션 데이터나 모든 세션데이터)</a>
</body>
</html>