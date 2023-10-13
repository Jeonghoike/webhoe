<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		form{text-align: center;}
	</style>
</head>
<body>
	<form action="">
		<p>
			<input type="text" name="su1" value="<%=(int)(Math.random()*9)+1 %>" readonly="readonly"> *
			<input type="text" name="su2" value="<%=(int)(Math.random()*9)+1 %>" readonly="readonly"> =
			<input type="number" name="result">
		</p>
		<p><input type="submit" value="확인"></p>
	</form>
	<p>
		${param.su1 } * ${param.su2 } = ${param.result }는
		${param.su1*param.su2 eq param.result }
		${not empty param.result ? (param.su1*param.su2 eq param.result ? "정답":"오답") : "" }
	</p> 
</body>
</html>