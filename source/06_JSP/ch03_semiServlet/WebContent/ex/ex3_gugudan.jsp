<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>원하는 구구단을 선택하세요</h2>
	<!-- /ch03_semiServlet/ex/ex3_gugudan.jsp : 현재파일 url -->
	<!-- /ch03_semiServlet/Ex3 : 구구단 출력 서블릿 url -->
	<form action="../Ex3" method="get">
		<select name="num">
			<option value="2">2단</option>
			<option value="3">3단</option>
			<option value="4">4단</option>
			<option value="5">5단</option>
			<option value="6">6단</option>
			<option value="7">7단</option>
			<option value="8">8단</option>
			<option value="9">9단</option>
		</select>
		<input type="submit" value="구구단 출력">
	</form>
</body>
</html>