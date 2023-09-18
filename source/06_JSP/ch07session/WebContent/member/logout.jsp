<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/main.css" rel="stylesheet" type="text/css">
	<script>
		let sec =3;
		setTimeout(() => {
			location.href='<%=conPath%>/member/main.jsp'
		}, 3000);
		let id = setInterval(() => {
			sec--;
			let mainTag = document.getElementById('mainForm_wrap');
			mainTag.innerHTML = '로그아웃완료. ' + sec + '초후 페이지 이동합니다;';
		}, 1000);
		setTimeout(() => {
			clearInterval(id);
		}, 2000);
	</script>
</head>
<body>
	<%session.invalidate(); %>
	<jsp:include page="../member/header.jsp"/>
	<div id="mainForm_wrap">
		로그아웃 되었습니다.잠시후 페이지 이동이 있겠습니다.
	</div>
	<jsp:include page="../member/footer.jsp"/>
</body>
</html>