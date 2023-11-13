<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- model.Board(원글정보), param.bid, param.pageNum -->
	<form action="${conPath }/board/reply.do" method="post">
		<input type="hidden" name="pageNum" value="${param.pageNum }">
		<input type="hidden" name="bid" value="${param.bid }"> <!-- 원글 글번호 -->
		<input type="hidden" name="bgroup" value="${board.bgroup }"><!-- 원글 bgroup -->
		<input type="hidden" name="bstep" value="${board.bstep }"><!-- 원글 bgroup -->
		<input type="hidden" name="bindent" value="${board.bindent }"><!-- 원글 bgroup -->
		<table>
			<caption>${param.bid }번글의 답변글 쓰기</caption>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="bname" required="required" autofocus="autofocus"></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input type="text" name="btitle" required="required" value="[답]${board.btitle }"></td>
			</tr>
			<tr>
				<th>본문</th>
				<td><textarea rows="5" name="bcontent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="답글쓰기" class="btn">
					<input type="reset" value="초기화" class="btn">
					<input type="button" value="목록" class="btn" 
								onclick="location.href='${conPath}/board/list.do?pageNum=${param.pageNum }'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>













