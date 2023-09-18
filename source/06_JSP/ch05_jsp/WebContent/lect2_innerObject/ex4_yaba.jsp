<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex4.css" rel="stylesheet">
	<script>
		const position = su => {
			location.href = 'ex4_yabaPro.jsp?su='+su;
		};
	</script>
</head>
<body>
	<div id="wrap">
		<button onclick="position(1)">1번</button>
		<button onclick="position(2)">2번</button>
		<button onclick="position(3)">3번</button>
	<%
		String msg = request.getParameter("msg");
		if(msg!=null){
			out.println(msg);
		}
	%>
	</div>
	
</body>
</html>