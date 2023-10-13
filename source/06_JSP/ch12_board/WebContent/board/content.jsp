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
		String bid = request.getParameter("bid"); // null이거나 "1"
		BoardDao bDao = BoardDao.getInstance();
		// list.jsp를 통해서 상세보기 페이지를 올 때만 조회수 1Up
		// list.jsp를 통해서 상세보기 페이지로 올 때 url : content.jsp?bid=2
		// 수정성공 후 상세페이지로 올 때 url : content.jsp?bid=2&after=u
		if(request.getParameter("after")==null){
			bDao.hitUp(bid);
		}
		BoardDto dto = bDao.getBoardNotHitUp(bid); // dto가져오기
		if(dto == null){
			response.sendRedirect(conPath + "/board/list.jsp");
		}else{
	%>	
		<table>
			<caption><%=bid %>번 글 상세보기</caption>
			<tr>
				<th>글번호</th> <td><%=dto.getBid() %></td>
			</tr>
			<tr>
				<th>글제목</th> <td><%=dto.getBtitle() %></td>
			</tr>
			<tr>
				<th>글본문</th> <td><pre><%=dto.getBcontent()==null? "":dto.getBcontent()%></pre></td>
			</tr>
			<tr>
				<th>이메일</th> <td><%=dto.getBemail()==null? "":dto.getBemail() %></td>
			</tr>
			<tr>
				<th>조회수</th> <td><%=dto.getBhit() %></td>
			</tr>
			<tr>
				<th>IP</th> <td><%=dto.getBip() %></td>
			</tr>
			<tr>
				<th>작성</th> <td><%=dto.getBdate() %></td>
			</tr>
			<tr>
				<td colspan="2">
					<button onclick="location='<%=conPath%>/board/updateForm.jsp?bid=<%=bid%>'">수정</button>
					<button onclick="location='<%=conPath%>/board/deleteForm.jsp?bid=<%=bid%>'">삭제</button>
					<button>답변</button>
					<button onclick="location.href='<%=conPath%>/board/list.jsp'">목록</button>
				</td>
			</tr>
		</table>
	<%	}%>
</body>
</html>