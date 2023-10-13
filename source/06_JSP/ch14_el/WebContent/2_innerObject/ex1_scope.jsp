<%@page import="java.net.URLEncoder"%>
<%@page import="com.sun.javafx.collections.SetAdapterChange"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="ex2_scope.jsp">
		<p>ID<input type="text" name="id"></p>
		<p>PW<input type="text" name="pw"></p>
		<p><input type="submit"></p>
	</form>
	<%
		// 자바에서 할 로직
		pageContext.setAttribute("pageName", "pageValue");
		request.setAttribute("requestName", "requestValue"); // ★   
		session.setAttribute("sessionName", "sessionValue"); // ★
		application.setAttribute("applName", "applValue");
		// 자바에서 forward할 객체 생성후 forward
		RequestDispatcher dispatcher = request.getRequestDispatcher("ex2_scope.jsp?id="+
								URLEncoder.encode("한글아이디","utf-8")+"&pw=111");
		dispatcher.forward(request, response);
		
		// response.sendRedirect("ex2_scope.jsp");
	%>
	<%-- <jsp:forward page="ex2_scope.jsp"/> --%>
	<h3>페이지 내 attribute : <%=pageContext.getAttribute("pageName") %></h3>
	<h3>request 내 attribute : <%=request.getAttribute("requestName") %></h3>
	<h3>session 내 attribute<%=session.getAttribute("sessionName") %></h3>
	<h3>application 내 attribute<%=application.getAttribute("applName") %></h3>
	<hr>
	<h3>페이지 내 attribute ${pageScope.pageName }</h3>
	<h3>request 내 attribute ${requestScope.requestName }</h3>
	<h3>session 내 attribute ${sessionScope.sessionName }</h3>
	<h3>application 내 attribute ${applicationScope.applName }</h3>
	<hr>
	<h3>페이지 내 attribute ${pageName }</h3>
	<h3>request 내 attribute ${requestName }</h3>
	<h3>session 내 attribute ${sessionName }</h3>
	<h3>application 내 attribute ${applName }</h3>
</body>
</html>