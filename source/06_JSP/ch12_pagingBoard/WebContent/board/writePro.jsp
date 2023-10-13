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
		request.setCharacterEncoding("utf-8"); 
	%>
	<jsp:useBean id="dto" class="com.lec.ex.dto.BoardDto"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		dto.setBip(request.getRemoteAddr()); // 요청한 컴퓨터 ip 주소
		BoardDao bDao = BoardDao.getInstance();
		int result = bDao.writeBoard(dto); 
		// response.sendRedirect(conPath+"/board/list.jsp?result="+result); // list.jsp?writeResult=1
		if(result == BoardDao.SUCCESS){
	%>
		<script>
			alert('글쓰기 완료');
			location.href = '<%=conPath%>/board/list.jsp';
		</script>		
	<%	}else{%>
		<script>
			alert('글쓰기 실패(길어)');
			history.back();
		</script>	
	<%	}%>
</body>
</html>