<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!-- HTML 주석 -->
	<%-- JSP 주석 --%>
	<% // 스크립트릿 내의 자바주석 
		int j=0; // 초기화하지 않으면 쓰리기 데이터
		String localStr = "몰라요";
		i++; j++;
		globalStr += "<span>★</span>";
		localStr += "<span>@</span>";
		out.println("전역변수 i = " + i + "<br>");
		out.println("전역변수 globalStr = " + globalStr + "<br>");
		out.println("지역변수 j = " + j + "<br>");
		out.println("지역변수 localStr = " + localStr + "<br>");
	%>
	<%-- 전역변수 i : <%=i %><br> --%>
	
	<%!  // 선언부가 맨 처음 실행
		int i; // 선언부의 변수는 초기화하지 않아도 자동 초기화(0, null)
		String globalStr ="Good";
	%>
</body>
</html>