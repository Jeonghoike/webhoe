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
	<%request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.ex.dto.BoardDto"/>
	<jsp:setProperty property="*" name="dto"/>
	<%		
		// 들어온 파라미터 : bid, bname, btitle, bcontent, bemail, bpw , pageNum
		// dao.modifyBoard(dto)를 호출하기 위해서 bip 추가 셋팅
		/*pageNum 추가*/
		String pageNum = request.getParameter("pageNum");
		dto.setBip(request.getRemoteAddr()); // 수정요청한 컴퓨터 ip
		BoardDao bDao = BoardDao.getInstance();
		int result = bDao.modifyboard(dto);
		if(result == BoardDao.SUCCESS){
	%>	
		<script>
			alert('글수정 성공');
			// location.href='<%=conPath%>/board/list.jsp?pageNum=<%=pageNum%>'; // 글수정 후 글목록 페이지로
			location.href = '<%=conPath%>/board/content.jsp?bid=<%=dto.getBid()%>&after=u&pageNum=<%=pageNum%>'; // 상세보기페이지로
		</script>	
	<%	}else{%>
		<script>
			alert('글수정 실패(길어)');
			history.go(-1);
		</script>
	<%	}%>
</body>
</html>