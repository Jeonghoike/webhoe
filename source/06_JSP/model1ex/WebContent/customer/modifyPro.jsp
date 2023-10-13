<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="com.lec.dto.CustomerDto"%>
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
	<jsp:useBean id="dto" class="com.lec.dto.CustomerDto"/>
	<jsp:setProperty property="*" name="dto"/>
	<% 
		String tempCbirth = request.getParameter("tempCbirth");
		if(!tempCbirth.equals("")){
			dto.setCbirth(Date.valueOf(tempCbirth));
		}
		CustomerDto customer = (CustomerDto)session.getAttribute("customer");
		String sessionPw = null;
		if(customer!=null){
			sessionPw = customer.getCpw();
		}
		String oldCpw = request.getParameter("oldCpw");
		if(sessionPw.equals(oldCpw)){
			if(dto.getCpw() == null){
				dto.setCpw(oldCpw);
			}
			CustomerDao cDao = CustomerDao.getInstance();
			int result = cDao.modifyCustomer(dto);
			if(result == CustomerDao.SUCCESS){
				session.setAttribute("customer", dto);
	%>		
				<script>
					alert('정보수정이완료되었습니다');
					location.href = '<%=conPath%>/main/main.jsp';
				</script>	
	<%		}else{%>
				<script>
					alert('정보수정이 실패되었습니다. 정보가 너무 깁니다');
					location.href = '<%=conPath%>/customer/modifyForm.jsp';
				</script>
	<%		}%>
	<%	}else{%>
			<script>
				alert('현 비밀번호가 바르지 않습니다. 확인하세요');
				history.back();
			</script>
	<%	}%>
</body>
</html>