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
		img{width: 100px;}
	</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<table>
			<caption>${book.bnum }번 도서 상세보기</caption>
			<tr><th>책이름</th><td colspan="2">${book.btitle }</td></tr>
			<tr><th>저자</th><td colspan="2">${book.bwriter }</td></tr>
			<tr><th>출판일</th><td colspan="2">${book.brdate }</td></tr>
			<tr><th>책이미지</th><td><img src="${conPath }/bookImgFileUpload/${book.bimg1 }"></td>
								<td><img src="${conPath }/bookImgFileUpload/${book.bimg2 }"></td></tr>
			<tr><th>책소개</th><td colspan="2">${book.binfo }</td></tr>
			<tr><td colspan="3">
				<button onclick="location='${conPath }/book/modify.do?bnum=${book.bnum}&pageNum=${param.pageNum}'">수정</button>
				<button onclick="location='${conPath }/book/list.do?pageNum=${param.pageNum}'">목록</button>
		</table>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>