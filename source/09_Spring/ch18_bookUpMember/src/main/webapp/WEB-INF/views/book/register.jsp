<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<style>
		#content {
			width: 800px; height:350px;
			margin: 50px auto;
		}
	</style>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<!-- jquery-ui 이용한 캘런더api -->
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
	  $( function() {
		  $("#datepicker").datepicker({
			  dateFormat : 'yy-mm-dd',
				monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
				dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토'],
				showMonthAfterYear : true,
				showOtherMonths : true,
				selectOtherMonths : false,
				yearSuffix : '년',
		  });
	  } );
	</script>
</head>
<body>
	<c:if test="${empty member }">
		<script>
			alert('로그인 후 책등록이 가능합니다');
			location.href = '${conPath}/member/login.do?after=book/register.do';
		</script>
	</c:if>
	<c:set var="SUCCESS" value="1"/>
	<c:if test="${registerResult == SUCCESS }">
		<script>
			alert('책등록 완료');
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<form action="${conPath }/book/register.do" method="post" enctype="multipart/form-data">
			<table>
				<caption>도서 등록</caption>
				<tr><th>책이름</th>
					<td><input type="text" name="btitle" required="required"></td>
				</tr>
				<tr><th>저자</th>
					<td><input type="text" name="bwriter" required="required"></td>
				</tr>
				<tr><th>출판일</th>
					<td><input type="text" name="brdate" id="datepicker" required="required"></td>
				</tr>
				<tr><th>책이미지</th>
					<td><input type="file" name="tempBimg1"></td>
				</tr>
				<tr><th>책이미지</th>
					<td><input type="file" name="tempBimg2"></td>
				</tr>
				<tr><th>책소개</th>
					<td><textarea rows="5" cols="10" name="binfo"></textarea> </td>
				</tr>
				<tr><td colspan="2">
					<input type="submit" value="책등록">
				</td></tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>