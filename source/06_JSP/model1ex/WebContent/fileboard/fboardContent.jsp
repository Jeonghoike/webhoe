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
		#content_form{padding: 40px;}
	</style>
	
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
	<%
		String pageNum = request.getParameter("pageNum");
		int fid = Integer.parseInt(request.getParameter("fid"));
		FileBoardDao fDao = FileBoardDao.getInstance();
		if(request.getParameter("after")==null){
			fDao.hitUp(fid);
		}
		FileBoardDto dto = fDao.getFileBoardNotHitUp(fid);
		if(dto == null){
			response.sendRedirect(conPath + "/fileboard/fboardList.jsp");
		}else{
	%>	
			<table>
				<caption><%=fid %>번 글 상세보기</caption>
				<tr>
					<th>글번호</th> <td><%=dto.getFid() %></td>
				</tr>
				<tr>
					<th>글제목</th> <td><%=dto.getFtitle() %></td>
				</tr>
				<tr>
					<th>글본문</th> <td><pre><%=dto.getFcontent()==null? "":dto.getFcontent()%></pre></td>
				</tr>
				<tr>
					<th>이메일</th> <td><%=dto.getCemail()==null? "":dto.getCemail() %></td>
				</tr>
				<tr>
					<th>조회수</th> <td><%=dto.getFhit() %></td>
				</tr>
				<tr>
					<th>IP</th> <td><%=dto.getFip() %></td>
				</tr>
				<tr>
					<th>작성</th> <td><%=dto.getFrdate() %></td>
				</tr>
				<tr>
					<td colspan="2">
						<button onclick="location='<%=conPath%>/fileboard/fboardUpdateForm.jsp?fid=<%=fid%>&pageNum=<%=pageNum%>'">수정</button>
						<button onclick="location='<%=conPath%>/fileboard/fboardDeleteForm.jsp?fid=<%=fid%>&pageNum=<%=pageNum%>'">삭제</button>
						<button onclick="location='<%=conPath%>/fileboard/fboardReplyForm.jsp?fid=<%=fid%>&pageNum=<%=pageNum%>'">답변</button>
						<button onclick="location.href='<%=conPath%>/fileboard/fboardList.jsp?pageNum=<%=pageNum%>'">목록</button>
					</td>
				</tr>
			</table>
	<%	}%>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>