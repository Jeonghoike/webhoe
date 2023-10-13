<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.ex.dto.MemberDto"%>
<%@page import="com.lec.ex.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<%
	MemberDao dao = MemberDao.getInstance();
	out.println("<h3>1.회원id중복체크</h3>");
	if(MemberDao.EXISTENT == dao.midConfirm("bbb")){
		out.println("bbb는 중복된 ID");
	}else if(MemberDao.NONEXISTENT == dao.midConfirm("bbb")){
		out.println("bbb는 사용가능한 ID");
		out.println("<h3>2.회원가입</h3>");
		int result = dao.joinMember(new MemberDto("bbb","1","홍길","h@h.com","NOIMG.JPG",null, "경기",null));
		if(result == MemberDao.SUCCESS){
			out.println("회원가입 성공");
		}else if(result == MemberDao.FAIL){
			out.println("회원가입 실패");
		}
	}
	out.println("<h3>3.로그인</h3>");
	String mid = "bbb", mpw="1";
	int result = dao.loginCheck(mid, mpw);
	if(result == MemberDao.SUCCESS){
		out.println("<p>"+mid+"/"+mpw+" 로그인 성공</p>");
	}else if(result == MemberDao.FAIL){
		out.println("<p>"+mid+"/"+mpw+" 로그인 실패</p>");
	}
	mid = "bbb"; mpw="9";
	result = dao.loginCheck(mid, mpw);
	if(result == MemberDao.SUCCESS){
		out.println("<p>"+mid+"/"+mpw+" 로그인 성공</p>");
	}else if(result == MemberDao.FAIL){
		out.println("<p>"+mid+"/"+mpw+" 로그인 실패</p>");
	}
	out.println("<h3>4.mid로 dto가져오기</h3>");
	MemberDto member = dao.getMember("aaa");
	out.println("<p>"+member+"</p>");
	out.println("<h1>5. 회원정보 수정(aaa회원정보 수정)</h1>");
	mid = "bbb";
	member = dao.getMember(mid);
	out.println("<p>수정전 : " + member + "</p>");
	member.setMname("박박박");
	member.setMemail(null);
	member.setMaddress(null);
	dao.modifyMember(member); // 회원정보 수정
	out.println("<p>수정후 : " + dao.getMember(mid)+"</p>");
	out.println("<h1>6. 회원리스트 (4~6)</h1>");
	ArrayList<MemberDto> members = dao.getMemberlist(4, 6); 
	for(MemberDto m : members){
		out.println(m + "<br>");
	}
	out.println("<h1>7. 회원수 : " + dao.getMemberTotCnt() + "</h1>");
	out.println("<h1>8. "+mid+"회원 탈퇴</h1>");
	result = dao.withdrawalMember(mid);
	out.println(result == MemberDao.SUCCESS? "탈퇴 완료":"탈퇴 실패");
%>	
</body>
</html>