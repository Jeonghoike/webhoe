<%@page import="com.lec.dto.EmpDto"%>
<%@page import="com.lec.dao.EmpDao"%>
<%@page import="com.lec.dto.DeptDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.DeptDao"%>
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
	<form>
	<p>
		부서번호
		<select name="deptno">
			<option value="0">모든 부서</option>
			<%
				String deptnoStr = request.getParameter("deptno");
				if(deptnoStr == null){
					deptnoStr = "0";
				}
				int deptnoInput = Integer.parseInt(deptnoStr); //전달받은 파라미터 값 정수
				DeptDao dDao = DeptDao.getInstance();
				ArrayList<DeptDto> depts = dDao.deptList();
				for(DeptDto dept : depts){
					// <option value='10'>10-SALES-BOSTON</option>
					// <option value='10' selected='selected'>10-SALES-BOSTON</option>
					int deptno = dept.getDeptno();
					String dname = dept.getDname();
					String loc = dept.getLoc();
					if(deptnoInput == deptno){
						out.print("<option value='" + deptno + "' selected='selected'>" + deptno + "-" + dname + "-" + loc + "</option>");
					}else{
						out.print("<option value='" + deptno + "'>" + deptno + "-" + dname + "-" + loc + "</option>");
					}
				}
			%>
		</select>
		<input type="submit" value="검색" class="btn">
	</p>
	</form>
	<table>
		<tr><th>사번</th><th>이름</th><th>입사일</th><th>부서번호</th><th>부서명</th></tr>
		<%
			EmpDao eDao = EmpDao.getInstance();
			ArrayList<EmpDto> emps = eDao.dnameEmpList(deptnoInput);
			if(!emps.isEmpty()){
				for(EmpDto emp : emps){
					out.print("<tr><td>" + emp.getEmpno() + "</td>" 
							    + "<td>" + emp.getEname() + "</td>"
							    + "<td>" + emp.getHiredate() + "</td>"
							    + "<td>" + emp.getDeptno() + "</td>"
							    + "<td>" + emp.getDname() + "</td></tr>");
				}
				out.print("<tr><td colspan='5'>총" + emps.size() + "명</td></tr>");
			}else{
				out.print("<tr><td colspan='5'>해당 부서번호의 사원은 없습니다</td></tr>");
			}
		%>
	</table>
</body>
</html>