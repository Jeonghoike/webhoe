<%@page import="com.lec.ex.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
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
	<%-- // writeBoard 수행후 list로 오면 result 파라미터 존재
		String result = request.getParameter("result");
		if(result!=null && result.equals("1")){
			out.print("<script>alert('글쓰기 성공');</script>");
		}else if(result!=null && result.equals("0")){
			out.print("<script>alert('글쓰기 실패(길어)');history.back();</script>");
		}
	--%>
	<table>
		<caption>게시판</caption>
		<tr><td><a href="<%=conPath %>/board/writeForm.jsp">글쓰기</a></tr>
	</table>
	<table>
		<tr><th>글번호</th><th>작성자</th><th>글제목</th><th>메일</th><th>조회수</th></tr>
		<%
			BoardDao bDao = BoardDao.getInstance();
			int totalCnt = bDao.getBoardTotalCnt(); // 글전체 갯수
			if(totalCnt == 0){
				out.print("<tr><td colspan='5'>등록된 글이 없습니다</td></tr>");
			}else{
				ArrayList<BoardDto> dtos = bDao.listBoard();
				for(BoardDto dto : dtos){
					// 글번호
					out.print("<tr><td>" + dto.getBid() + "</td>");
					// 작성자
					out.print("<td>" + dto.getBname() + "</td>");
					// 제목(왼쪽 정렬. 조회수가 10초과시 hot이미지 출력. 제목 클릭시 상세보기 페이지로)
					out.print("<td class='left'>");
					if(dto.getBhit() > 10){
						out.print("<img src='" + conPath + "/img/hot.gif'>");
					}
					out.print("<a href='" + conPath + "/board/content.jsp?bid=" + dto.getBid() + "'>");
					out.print(dto.getBtitle());
					out.print("</a>");
					out.print("</td>");
					// 메일
					String email = dto.getBemail();
					out.print("<td>" + (email==null? "-":email) + "</td>");
					// 조회수
					out.print("<td>" + dto.getBhit() + "</td></tr>");
				}
			}
		%>
	</table>
</body>
</html>