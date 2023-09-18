<%@page import="com.lec.dto.EmpDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.EmpDao"%>
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
		String deptnoStr = request.getParameter("deptno");
		if(deptnoStr==null){
			deptnoStr = "0";
		}
		int deptnoInput = Integer.parseInt(deptnoStr);
		EmpDao eDao = EmpDao.getInstance();
		ArrayList<EmpDto> empList = eDao.deptnoEmpList(deptnoInput);		
		// empList 출력하기
		out.print("<tr><th>사번</th><th>이름</th><th>직책</th><th>부서번호</th></tr>");
		if(empList.size()!=0){
			for(int idx=0 ; idx<empList.size() ; idx++){
				out.print("<tr><td>" + empList.get(idx).getEmpno() + "</td>"
							+ "<td>" + empList.get(idx).getEname() + "</td>"
							+ "<td>" + empList.get(idx).getJob() + "</td>"
							+ "<td>" + empList.get(idx).getDeptno() + "</td><tr>");
			}
			out.print("<tr><td> colspan='4'>이상 총" + empList.size() + "명</td></tr>");
		}else{
			out.print("<tr><td colspan='4'>해당 부서번호의 사원이 없습니다</td></tr>");
		}
	%>
	</table>
</body>
</html>