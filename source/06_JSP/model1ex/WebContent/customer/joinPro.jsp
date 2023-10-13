<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="java.sql.Date"%>
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
	<jsp:useBean id="dto" class="com.lec.dto.CustomerDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		String tempBirth = request.getParameter("tempBirth");
		if(!tempBirth.equals("")){
			dto.setCbirth(Date.valueOf(tempBirth));
		}
		CustomerDao cDao = CustomerDao.getInstance();
		int result = cDao.confirmID(dto.getCid());
		if(result == CustomerDao.CUSTOMER_NONEXISTENT){
			result = cDao.joinCustomer(dto);
			if(result == CustomerDao.SUCCESS){
				session.setAttribute("cid", dto.getCid());
	%>
		<script>
			alert('<%=dto.getCname()%>님 회원가입 감사합니다');
			location.href='loginForm.jsp';
		</script>			
	<%		}else{%>
				<script>
					alert('회원가입이 실패되었습니다. 길이 제한이 있습니다');
					hiotory.go(-1);
				</script>
	<%		}%>
	<%	}else{%>
		<script>
			alert('중복된 ID입니다. 다른 아이디를 사용하세요');
			history.back();
		</script>
	<%}%>
</body>
</html>