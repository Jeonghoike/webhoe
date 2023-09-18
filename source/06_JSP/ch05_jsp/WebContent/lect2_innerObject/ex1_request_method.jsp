<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); // "/ch05_jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/footer.css" rel="stylesheet">
</head>
<body>
	<%-- 127.0.0.1(내 서버의 가상주소 ) IPv4->IPv6 --%>
	<h2>요청항 곳의 주소 : ★ <%=request.getRemoteAddr() %></h2>
	<h2>컨텍스트 root : ch05_jsp </h2>
	<h2>컨텍스트path : ★ <%=request.getContextPath() %> </h2>
	<h2>세션 객체 : ★ <%=request.getSession() %></h2>
	<h2>요청 URL : <%=request.getRequestURL() %></h2>
	<h2>요청 URI : ★ <%= request.getRequestURI() %></h2>
	<h2>해당 프로토콜 : <%=request.getProtocol() %></h2>
	<h2>포트번호 : <%=request.getServerPort() %></h2>
</body>
</html>