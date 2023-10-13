<%@page import="com.lec.ex.dao.BoardDao"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%  // 전달받은 파라미터들
		// pageNum
		// bid, bgroup, bstep, bindent (원글정보)
		// bname, btitle, bcontent, bemail, bpw (답변글 입력한 정보)
		request.setCharacterEncoding("utf-8");
		String pageNum = request.getParameter("pageNum");
	%>
	<jsp:useBean id="dto" class="com.lec.ex.dto.BoardDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		dto.setBip(request.getRemoteAddr()); // 요청한 컴퓨터 ip
		// dto.setBhit(0);
		// dto.setBdate(new Timestamp(System.currentTimeMillis())); // 요청 들어온 시점
		BoardDao bDao = BoardDao.getInstance();
		int result = bDao.replyBoard(dto);
		if(result == BoardDao.SUCCESS){
	%>
			<script>
				alert('<%=dto.getBid()%>번 글에 대한 답변글 쓰기 완료');
				location.href= '<%=conPath%>/board/list.jsp?pageNum=<%=pageNum%>';
			</script>		
	<%	}else{%>
			<script>
				alert('답변글 쓰기 실패(길어)');
				history.go(-1);
			</script>
	<%	}%>
</body>
</html>