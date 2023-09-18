<%@page import="java.util.Arrays"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/join.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		// 넘어온 파라미터 받기
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//String pwOut = pw.replaceAll("[a-zA-Z0-9~`!@#$%^&*()\\-_+=|\\\\{}\\[\\]:;\"'?/<>,\\.]", "*");
		String pwOut = "";
		for(int i=0 ; i<pw.length() ; i++) {
			pwOut += "*";
		}
		String birth = request.getParameter("birth"); // 파라미터 값은 무조건 문자열 전달
		Date birthDate = null;    // 날짜만 필요한 경우
		Timestamp birthTS = null; // 날짜, 시간이 다 필요한 경우
		if(birth!=null && !birth.equals("") ) {
			birthDate = Date.valueOf(birth);
			birthTS = Timestamp.valueOf(birth + " 00:00:00");
		}
		String[] hobby = request.getParameterValues("hobby");
		String hobbyOut = "";
		if(hobby!=null) {
			for(int i=0 ; i<hobby.length ; i++)
				if(i==hobby.length-1)
					hobbyOut += hobby[i];
				else
					hobbyOut += hobby[i]+", ";
		}else {
			hobbyOut = "없음";
		}
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String[] mailSend = request.getParameterValues("mailSend");
	%>
	<div id='joinForm_wrap'>
		<div id='join_title'>회원가입정보</div>
		<h2>이름 : <%=name%> </h2>
		<h2>아이디 : <%=id%> </h2>
		<h2>비번 : <%=pwOut%> </h2>
		<h2>생년월일 : <%=birth.equals("")? "-":birth %></h2>
		<h2>생년월일 : <%=birthTS==null? "-":birthTS %></h2>
		<h2>취미 : <%=hobbyOut %></h2>
		<h2>성별 : <%=gender%> </h2>
		<h2>이메일 : <%=email.equals("") ? "-":email %></h2>
		<h2>메일수신동의 : <%=mailSend!=null? Arrays.toString(mailSend) : "모두거부"%></h2>
		<h2>가입IP : <%=request.getRemoteAddr() %></h2>
		<button class="joinBtn_style" onclick="location.href='<%=conPath %>/member/login.jsp'">로그인</button>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>