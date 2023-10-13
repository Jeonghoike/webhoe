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
</head>
<body>
	<%
		BoardDao dao = BoardDao.getInstance();
		BoardDto dto = new BoardDto(); // 임의의 데이터 dto에 채워서writeBoard 70번 수행
		for(int i=0 ; i<70 ; i++){
			dto.setBname("홍길동" + i);
			dto.setBtitle("글 제목" + i);
			dto.setBcontent("본문 내용입니다." + i);
			if(i%2!=0){
				dto.setBemail("hong" + i + "hong.com");
			}
			dto.setBpw("111");
			dto.setBip("192.168.0." + i);
			int result = dao.writeBoard(dto);
			System.out.println(result==BoardDao.SUCCESS ? i+"번 째 성공": i+"번째 실패"); 
		}
		response.sendRedirect(conPath+"/board/list.jsp");
	%>
</body>
</html>