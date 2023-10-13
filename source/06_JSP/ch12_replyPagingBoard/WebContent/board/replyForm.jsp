<%@page import="com.lec.ex.dto.BoardDto"%>
<%@page import="com.lec.ex.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		// 넘어온 파라미터 : bid(원글의 글번호), pageNum
		String pageNum = request.getParameter("pageNum");
		int bid = Integer.parseInt(request.getParameter("bid"));
		BoardDao bDao = BoardDao.getInstance();
		BoardDto originalDto =bDao.getBoardNotHitUp(bid); //원글의 정보(bgroup, bstep, bindent)
		
	%>
	<form action="<%=conPath%>/board/replyPro.jsp" method="post">
		<input type="hidden" name="pageNum" value="<%=pageNum%>">
		<input type="hidden" name="bid" value="<%=originalDto.getBid()%>">
		<input type="hidden" name="bgroup" value="<%=originalDto.getBgroup()%>"><!-- 원글 -->
		<input type="hidden" name="bstep" value="<%=originalDto.getBstep()%>"><!-- 원글 -->
		<input type="hidden" name="bindent" value="<%=originalDto.getBindent()%>"><!-- 원글 -->
		<table>
			<caption><%=bid %>번 글의 답변글 쓰기</caption>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="bname" required="required" autofocus="autofocus"></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input type="text" name="btitle" required="required" value="re:<%=originalDto.getBtitle()%>"></td>
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
					<input type="submit" value="답변글쓰기" class="btn">
					<input type="reset" value="초기화" class="btn">
					<input type="button" value="목록" class="btn"
							onclick="location.href='<%=conPath%>/board/list.jsp?pageNum=<%=pageNum%>'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>