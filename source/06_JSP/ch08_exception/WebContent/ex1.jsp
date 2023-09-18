<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		int num1 = Integer.parseInt(request.getParameter("num1")); // "5"
		int num2 = Integer.parseInt(request.getParameter("num2"));
		out.println("<h2>num1 = " + num1 + "</h2>");
		out.println("<h2>num2 = " + num1 + "</h2>");
		out.println("<h2>num1+num2 = " + (num1+num2) + "</h2>");
		try{ // 예외처리
			out.println("<h2>num1/num2 = " + (num1/num2) + "</h2>");
		}catch(Exception e){
			out.println("<h2>num1/num2 = 0으로 나누면 안되요</h2>");
			System.out.println(e.getMessage());
			%>
				<script>
					console.log('<%=e.getMessage()%>');
				</script>
			<%
		}
		out.println("<h2>num1*num2 = " + (num1*num2) + "</h2>");
		out.println("<h2>num1-num2 = " + (num1-num2) + "</h2>");
	%>
</body>
</html>