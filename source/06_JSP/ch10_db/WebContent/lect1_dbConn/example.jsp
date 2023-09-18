<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
	<style>
		p{text-align: center;}
	</style>
</head>
<%!
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url    = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection        conn;
	PreparedStatement pstmt;
	ResultSet         rs;	
%>
<%
	String enameStr = request.getParameter("ename");
	if(enameStr==null){
		enameStr = "";
	}
%> 
<body>
	<form action="">
		<P>
			사원명					
			<input type="text" name="ename" class="btn" value="<%=enameStr.toUpperCase().trim() %>">
			<input type="submit" value="검색" class="btn">
		</P>
	</form>
	<table>
		<tr><th>사번</th><th>이름</th><th>직책</th><th>상사번호</th><th>입사일</th><th>급여</th><th>부서번호</th><th>부서명</th></tr>
		<%
			String sql = "SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, E.DEPTNO, DNAME " 
				    + " FROM EMP E, DEPT D "
				    + " WHERE E.DEPTNO=D.DEPTNO AND E.ENAME LIKE '%'||TRIM(UPPER(?))||'%'";
			try{
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, enameStr);
				rs = pstmt.executeQuery();
				if(rs.next()){
					do{
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						String job = rs.getString("job");
						int mgr = rs.getInt("mgr");
						Date hiredate = rs.getDate("hiredate");
						int sal = rs.getInt("sal");
						int deptno = rs.getInt("deptno");
						String dname = rs.getString("dname");
						out.print("<tr><td>" + empno + "</td>"
								     +"<td>" + ename + "</td>"
								     +"<td>" + job + "</td>"
								     +"<td>" + mgr + "</td>"
								     +"<td>" + hiredate + "</td>"
								     +"<td>" + sal + "</td>"
								     +"<td>" + deptno + "</td>"
								     +"<td>" + dname + "</td></tr>");
					}while(rs.next());
				}else{
					out.println("<tr><td colspan='8'>검색하신 사원이 없습니다</td></tr>");
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}finally{
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			}
		%>
	</table>
</body>
</html>