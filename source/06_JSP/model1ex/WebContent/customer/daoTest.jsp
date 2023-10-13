<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>테스트 페이지</h1>
	<%
		CustomerDao cDao = CustomerDao.getInstance();
		String cid = "bbb";
		int result = cDao.confirmID(cid);
		if(result == CustomerDao.CUSTOMER_EXISTENT){
			out.println("<h3>1. confirmID 결과 :" + cid + "는 중복된 아이디로 회원가입불가</h3>");
		}else{
			out.println("<h3>1. confirmID 결과 :" + cid + "는 중복되지 않은 아이디로 회원가입 가능</h3>");
			CustomerDto dto = new CustomerDto(cid, "111", "임길동", "010-4444-3333", "im@shin.com", "서울", null, "m", null);
			result = cDao.joinCustomer(dto);
			if(result == CustomerDao.SUCCESS){
				out.println("<h3>2. join결과 : 회원가입성공 " + dto + "</h3>");
			}else{
				out.println("<h3>2. join결과 : 회원가입실패 " + dto + "</h3>");
			}
		}
		out.println("<h3>3.로그인 결과");
		cid = "aaa"; String cpw = "111";
		result = cDao.loginCheck(cid, cpw);
		if(result == CustomerDao.LOGIN_SUCCESS){
			out.print("id는 " + cid + ", pw는 " + cpw + " : 로그인 성공<br>");
		}else if(result == CustomerDao.LOGIN_FAIL){
			out.print("id는 " + cid + ", pw는 " + cpw + " : 로그인 실패<br>");
		}
		cid = "xx"; cpw = "111";
		result = cDao.loginCheck(cid, cpw);
		if(result == CustomerDao.LOGIN_SUCCESS){
			out.print("id는 " + cid + ", pw는 " + cpw + " : 로그인 성공<br>");
		}else if(result == CustomerDao.LOGIN_FAIL){
			out.print("id는 " + cid + ", pw는 " + cpw + " : 로그인 실패<br>");
		}
		out.println("<h3>4. id로 dto가져오기</h3>");
		CustomerDto dto = cDao.getCustomer("qqq");
		out.println("qqq 아이디는 (없는 cid)인 member : " + dto + "<br>");
		dto = cDao.getCustomer("aaa");
		out.println("aaa 아이디인 member : " + dto + "<br>");
		out.println("<h3>5. 정보수정 <h3>");
		dto.setCname("둘리");
		dto.setCaddress("쥬라기");
		result = cDao.modifyCustomer(dto);
		if(result == CustomerDao.SUCCESS){
			out.println("수정완료<br>");
			out.println("db의 수정된 데이터 : " + cDao.getCustomer(dto.getCid()) + "<br>");
		}else{
			out.println(dto.getCid()+"아이디가없어 수정 못함<br>");
		}
		
	%>
</body>
</html>