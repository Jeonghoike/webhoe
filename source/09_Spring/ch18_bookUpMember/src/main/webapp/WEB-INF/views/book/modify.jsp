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
			alert('로그인 후 책수정이 가능합니다');
			location.href = '${conPath}/member/login.do?after=book/modify.do?bnum=${param.bnum}&pageNum=${param.pageNum}';
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<form action="${conPath }/book/modify.do" method="post"  enctype="multipart/form-data">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<input type="hidden" name="bnum" value="${book.bnum }">
			<table>
				<caption>${book.bnum }번 도서 수정하기</caption>
				<tr><th>책이름</th><td><input type="text" name="btitle" value="${book.btitle }"></td></tr>
				<tr><th>저자</th><td><input type="text" name="bwriter" value="${book.bwriter }"></td></tr>
				<tr><th>출판일</th><td><input type="text" name="brdate"  id="datepicker" value="${book.brdate }"></td></tr>
				<tr><th>책이미지1</th><td><input type="file" name="tempBimg1">${book.bimg1 }</td></tr>
				<tr><th>책이미지2</th><td><input type="file" name="tempBimg2">${book.bimg2 }</td></tr>
				<tr><th>책소개</th><td><textarea rows="5" cols="20" name="binfo">${book.binfo}</textarea></td></tr>
				<tr><td colspan="2">
					<input type="submit" value="저장">
					<input type="button" value="목록" onclick="location='${conPath }/book/list.do?pageNum=${param.pageNum}'">
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>