<%@page import="com.lec.ex.dao.BoardDao"%>
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
	<%
		int bid = Integer.parseInt(request.getParameter("bid"));
		String bpw = request.getParameter("bpw");
		BoardDao bDao = BoardDao.getInstance();
		int result = bDao.deleteBoard(bid, bpw);
		if(result == BoardDao.SUCCESS){
	%>	
			<script>
				alert('<%=bid%>번 글 삭제 완료');
				location.href='<%=conPath%>/board/list.jsp';
			</script>	
	<%	}else{ // bpw 오류%>
			<script>
				alert('<%=bid%>번 글 삭제되지 않았습니다. 비밀번호를 확인하세요');
				history.back();
				location.href='<%=conPath%>/board/deleteForm.jsp?bid=<%=bid%>';
			</script>
	<%	}%>
</body>
</html>