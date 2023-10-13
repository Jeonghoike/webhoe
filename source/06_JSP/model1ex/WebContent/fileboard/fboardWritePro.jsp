<%@page import="com.lec.dao.FileBoardDao"%>
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
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="dto" class="com.lec.dto.FileBoardDto"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		dto.setFip(request.getRemoteAddr());
		FileBoardDao bDao = FileBoardDao.getInstance();
		int result = bDao.writeFileBoard(dto);
		if(result == FileBoardDao.SUCCESS){
	%>	
			<script>
				alert('글쓰기 완료');
				location.href='<%=conPath%>/fileboard/fboardList.jsp';
			</script>	
	<%	}else{%>
			<script>
				alert('글쓰기 실패(너무 길다)');
				history.back();
			</script>	
	<%	}%>
</body>
</html>