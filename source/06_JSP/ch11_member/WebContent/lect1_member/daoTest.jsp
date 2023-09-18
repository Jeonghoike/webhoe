<%@page import="com.lec.member.MemberDto"%>
<%@page import="com.lec.member.MemberDao"%>
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
	<h1>테스트 페이지</h1>
	<%
		MemberDao dao = MemberDao.getInstance();
		String id = "bbb";
		int result = dao.confirmID(id);
		if(result == MemberDao.MEMBER_EXISTENT){
			out.print("<h3>1. confirmID 결과 : " + id + "는 중복된 아이디로 회원가입 불가합니다</h3>");
		}else{
			out.print("<h3>1. confirmID 결과 : " + id + "는 가입가능한 아이디 입니다</h3>");
			MemberDto dto = new MemberDto(id, "111",  "홍", null, null, null, null,
													"a@hong.com", null, null, null);
			result = dao.joinMember(dto);
			if(result == MemberDao.SUCCESS){
				out.print("<h3>2. join 결과 : " + id + "로 회원가입 성공</h3>");
			}else{
				out.print("<h3>2. join 결과 : 회원가입 실패</h3>");
			}
		}
		out.print("<h3>3. loginCheck 결과</h3>");
		id = "bbb"; String pw = "111";
		result = dao.loginCheck(id, pw);
		if(result == MemberDao.LOGIN_SUCCESS){
			out.print("id는 " + id + ", pw는 " + pw + " : 로그인 성공<br>");
		}else if(result == MemberDao.LOGIN_FAIL_PW){
			out.print("id는 " + id + ", pw는 " + pw + " : 비밀번호 오류로 로그인 실패<br>");
		}else if(result == MemberDao.LOGIN_FAIL_ID){
			out.print("id는 " + id + ", pw는 " + pw + " : 아이디 오류로 로그인 실패<br>");
		}
		id = "bbb";  pw = "xxx";
		result = dao.loginCheck(id, pw);
		if(result == MemberDao.LOGIN_SUCCESS){
			out.print("id는 " + id + ", pw는 " + pw + " : 로그인 성공<br>");
		}else if(result == MemberDao.LOGIN_FAIL_PW){
			out.print("id는 " + id + ", pw는 " + pw + " : 비밀번호 오류로 로그인 실패<br>");
		}else if(result == MemberDao.LOGIN_FAIL_ID){
			out.print("id는 " + id + ", pw는 " + pw + " : 아이디 오류로 로그인 실패<br>");
		}
		id = "xxx";  pw = "xxx";
		result = dao.loginCheck(id, pw);
		if(result == MemberDao.LOGIN_SUCCESS){
			out.print("id는 " + id + ", pw는 " + pw + " : 로그인 성공<br>");
		}else if(result == MemberDao.LOGIN_FAIL_PW){
			out.print("id는 " + id + ", pw는 " + pw + " : 비밀번호 오류로 로그인 실패<br>");
		}else if(result == MemberDao.LOGIN_FAIL_ID){
			out.print("id는 " + id + ", pw는 " + pw + " : 아이디 오류로 로그인 실패<br>");
		}
		out.print("<h3>4. id로 dto 가져로기</h3>");
		MemberDto dto = dao.getMember("aaa");
		out.print("id = aaa인 dto : " + dto + "<br>");
		dto = dao.getMember("zzz");
		out.print("id = zzz인 member : " + dto + "<br>");
		out.print("<h3>5. 정보수정</h3>");
		out.print("id = aaa인 member 수정전 : " + dao.getMember("aaa") + "<br>");
		dto = new MemberDto("aaa", "111",  "홍길동", "02", "9999", "9999", null,
				"xxxx@hong.com", null, null, null);
		result = dao.modifyMember(dto);
		if(result == MemberDao.SUCCESS){
		out.print("db에 수정후 데이터 : " + dao.getMember("aaa") + "<br>");			
		}else{
			out.print(dto.getId() + "수정 실패");
		}
	%>
</body>
</html>