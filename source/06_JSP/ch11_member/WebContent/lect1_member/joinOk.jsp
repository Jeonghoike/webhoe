<%@page import="com.lec.member.MemberDao"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.member.MemberDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		String tempBirth = request.getParameter("tempBirth"); // ""(빈스트링)이거나 "1999-12-12"
		if(!tempBirth.equals("")){
			dto.setBirth(Date.valueOf(tempBirth));
			// dto의 birth가 Timestamp형이면 dto.setBirth(Timestamp.valueOf(tempBirth + "00:00:00"));
		}
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.confirmID(dto.getId()); // ID 중복체크
		if(result == MemberDao.MEMBER_NONEXISTENT){
			// 사용가능한 ID라서 회원가입 진행 -> session에 id추가 -> login 페이지로
			result = mDao.joinMember(dto); // 회원가입
			if(result == MemberDao.SUCCESS){ // 회원가입 성공
				session.setAttribute("id", dto.getId());
	%>
		<script>
			alert('<%=dto.getName()%>님 회원가입 감사합니다');
			location.href = 'login.jsp';
		</script>
	<%		}else{ // 회원가입 실패%>
				<script>
					alert('회원가입이 실패되었습니다. 길이 제한이 있습니다');
					history.go(-1);
					//location.href = 'join.jsp';
				</script>
	<%		}%>
	<%	}else{ // 중복된 ID라서 이전페이지로%>
		<script>
			alert('중복된 ID입니다. 다른 아이디를 사용하세요');
			history.back();
		</script>		
	<%}%>
</body>
</html>