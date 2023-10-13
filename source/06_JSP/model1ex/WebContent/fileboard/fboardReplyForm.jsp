<%@page import="com.lec.dto.FileBoardDto"%>
<%@page import="com.lec.dao.FileBoardDao"%>
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
		<%
			String pageNum = request.getParameter("pageNum");
			int fid = Integer.parseInt(request.getParameter("fid"));
			FileBoardDao bDao = FileBoardDao.getInstance();
			FileBoardDto originalDto = bDao.getFileBoardNotHitUp(fid);
		%>
		<form action="<%=conPath%>/fileboard/fboardReplyPro.jsp" method="post">
		<input type="hidden" name="pageNum" value="<%=pageNum%>">
		<input type="hidden" name="bid" value="<%=originalDto.getFid()%>">
		<input type="hidden" name="bgroup" value="<%=originalDto.getFgroup()%>"><!-- 원글 -->
		<input type="hidden" name="bstep" value="<%=originalDto.getFstep()%>"><!-- 원글 -->
		<input type="hidden" name="bindent" value="<%=originalDto.getFindent()%>"><!-- 원글 -->
		<table>
			<caption><%=fid %>번 글의 답변글 쓰기</caption>
			<tr>
				<th>글제목</th>
				<td><input type="text" name="ftitle" required="required" value="re:<%=originalDto.getFtitle()%>"></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type="file" name="filename">
			</tr>
			<tr>
				<th>본문</th>
				<td><textarea rows="5" name="fcontent"></textarea>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="fpw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="답변글쓰기" class="btn">
					<input type="reset" value="초기화" class="btn">
					<input type="button" value="목록" class="btn"
							onclick="location.href='<%=conPath%>/fileboard/fboardList.jsp?pageNum=<%=pageNum%>'">
				</td>
			</tr>
		</table>
	</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>	
</body>
</html>