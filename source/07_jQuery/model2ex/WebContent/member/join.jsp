<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<script>
		$(document).ready(function() {
			$('input[name="mid"]').keyup(function() {
				var mid = $(this).val();
				if(mid.length < 2){
					$('#midConfirmResult').text('id는 2글자 이상입니다');
				}else{
					$.ajax({
						url : '${conPath}/midConfirm.do',
						type : 'get',
						data : 'mid=' + mid,
						dataType : 'html',
						success : function(data) {
							$('#midConfirmResult').html(data);
						}
					});
				}
			});
		});
	</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<form action="${conPath }/join.do" method="post" enctype="multipart/form-data">
			<table>
				<caption>회원가입</caption>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="mid" required="required" autofocus="autofocus" autocomplete="off">
						<div id="midConfirmResult"> &nbsp; </div>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="mpw" required="required"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="mpwChk" required="required">
						<div id="mpwChkResult"> &nbsp; </div>
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="mname" required="required"></td>
				</tr>
				<tr>
					<th>메일</th>
					<td>
						<input type="text" name="memail" autocomplete="off">
						<div id="memailConfirmResult"> &nbsp; </div>
					</td>
				</tr>
				<tr>
					<th>사진</th>
					<td><input type="file" name="mphoto"></td>
				</tr>
				<tr>
					<th>생년월일</th><td><input type="text" name="mbirth" id="datepicker" autocomplete="off"></td>
				</tr>
				<tr>
					<th>주소</th><td><input type="text" name="maddress"></td>
				</tr>
				<tr>
					<td colspan="2">
						<p>
							<input type="submit" value="회원가입" class="btn">
							<input type="button" value="로그인" class="btn" onclick="location='${conPath}/loginView.do'">
						</p>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>