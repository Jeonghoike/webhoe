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
</head>
<body>
	<%
		String pageNum = request.getParameter("pageNum");
		int fid = Integer.parseInt(request.getParameter("fid"));
		String fpw = request.getParameter("fpw");
		FileBoardDao bDao = FileBoardDao.getInstance();
		int result = bDao.deleteFileBoard(fid, fpw);
		if(result == FileBoardDao.SUCCESS){
	%>	
			<script>
				alert('<%=fid%>번 글 삭제 완료');
				location.href='<%=conPath%>/fileboard/fboardList.jsp?pageNum=<%=pageNum%>';
			</script>	
	<%	}else{%>
			<script>
				alert('<%=fid%>번 글 삭제되지 않았습니다. 비밀번호를 확인하세요');
				history.back();
			</script>	
	<%  }
	%>
</body>
</html>