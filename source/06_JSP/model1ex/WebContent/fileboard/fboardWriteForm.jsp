<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
	<style>
		#content_form{
			width:1000px; margin: 0px auto; height: 550px; 
			text-align: center;
			color: #003300;
			padding-top:50px;
		}
		#content_form input {height: 20px; padding:3px; margin: 10px 0;}
		#content_form .btn {height: 50px; padding:3px; margin: 5px 0;}
	</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<form action="<%=conPath%>/fileboard/fboardWritePro.jsp" method="post">
			<table>
				<caption>원글쓰기</caption>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="bname" required="required" autofocus="autofocus"></td>
				</tr>
				<tr>
					<th>글제목</th>
					<td><input type="text" name="btitle" required="required"></td>
				</tr>
				<tr>
					<th>본문</th>
					<td><textarea rows="5" name="bcontent"></textarea>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="email" name="bemail"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="bpw" required="required"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="글쓰기" class="btn">
						<input type="reset" value="초기화" class="btn">
						<input type="button" value="목록" class="btn"
								onclick="location.href='<%=conPath%>/fileboard/fboardList.jsp'">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>