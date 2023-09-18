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
		// 세션삭제(로그아웃 시 사용)
		// 특정 세션 삭제하기(세션의 특정 속성을 삭제하기)
		session.removeAttribute("sessionName"); // sessionName 세션(속성) 삭제
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
		// 모든세션 삭제하기
		session.invalidate(); // setAttribute()했던 모든 세션 속성 다 제거. ID도 제거. setAttribute시 세션 ID 새로 발부
		if(request.isRequestedSessionIdValid()){
			out.println("<h2>유효한 세션이 있음</h2>");
		}else{
			out.println("<h3>유효한 세션이 없습니다</h3>");
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