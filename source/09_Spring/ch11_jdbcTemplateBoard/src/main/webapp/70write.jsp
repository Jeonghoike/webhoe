<%@page import="com.lec.ch11.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		String bname=null, btitle=null, bcontent="", bip=null;
		BoardDao bDao = new BoardDao();
		for(int i=1 ; i<=70 ; i++){
			bname = "홍길동"+i;
			btitle = "제목 " + i;
			bip = "192.168.1." + i;
			int result = bDao.writeBoard(bname, btitle, bcontent, bip);
			System.out.println(result==1? i+"번째 성공": i+"번째 실패");
		}
		response.sendRedirect("board/list.do");
	%>
</body>
</html>













