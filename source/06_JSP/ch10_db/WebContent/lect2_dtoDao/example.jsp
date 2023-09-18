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
	<%
		String schName = request.getParameter("schName");
		if(schName==null) schName = "";
	%>
	<form action="">
		<p>
			사원명
			<input type="text" name="schName" class="btn" value="<%=schName.toUpperCase().trim()%>">
			<input type="submit" value="검색" class="btn">
		</p>
	</form>
	<table>
		<tr>
			<th>사번</th><th>이름</th><th>직책</th><th>상사번호</th>
			<th>입사일</th><th>급여</th><th>부서번호</th><th>부서명</th>
		</tr>
		<%
		EmpDao dao = EmpDao.getInstance();
		ArrayList<EmpDto> empDtos = dao.enameEmpList(schName);
		if(empDtos.size() != 0){
			for(EmpDto empDto : empDtos){
				out.print("<tr><td>" + empDto.getEmpno() + "</td>"
							+ "<td>" + empDto.getEname() + "</td>"
							+ "<td>" + empDto.getJob() + "</td>"
							+ "<td>" + empDto.getMgr() + "</td>"
							+ "<td>" + empDto.getHiredate() + "</td>"
							+ "<td>" + empDto.getSal() + "</td>"
							+ "<td>" + empDto.getDeptno() + "</td>"
							+ "<td>" + empDto.getDname() + "</td></tr>");
			}
		}else{
			out.print("<tr><td> colspan='8'>해당 사원이 없습니다</td></tr>");
		}
		%>
	</table>
</body>
</html>