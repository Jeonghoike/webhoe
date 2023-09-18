<%@page import="com.lec.dao.EmpDao"%>
<%@page import="com.lec.dto.EmpDto"%>
<%@page import="java.util.ArrayList"%>
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
	<table>
		<%
			EmpDao eDao = EmpDao.getInstance();
			ArrayList<EmpDto> empList = eDao.empList();
			if(empList.isEmpty()){
				out.println("<tr><td>입력된 데이터가 없습니다</td></tr>");
			}else{
				out.print("<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번</th>"+
						"<th>입사일</th><th>급여</th><th>상여</th>"+
						"<th>부서번호</th></tr>");
				for(EmpDto emp : empList){
					out.println("<tr><td>" + emp.getEmpno() + "</td>"
							  + "<td>" + emp.getEname() + "</td>"
							  + "<td>" + emp.getJob() + "</td>"
							  + "<td>" + (emp.getMgr()==0? "-":emp.getMgr()) + "</td>"
							  + "<td>" + emp.getHiredate() + "</td>"
							  + "<td>" + emp.getSal() + "</td>"
							  + "<td>" + emp.getComm() + "</td>"
							  + "<td>" + emp.getDeptno() + "</td>"
					);
				}
			}
		%>
	</table>
</body>
</html>