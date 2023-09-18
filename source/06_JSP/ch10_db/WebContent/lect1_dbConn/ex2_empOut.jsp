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
</head>
<%!
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url    = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection        conn;
	PreparedStatement pstmt;
	ResultSet         rs;	
%>
<body>
	<table>
		<%
			String deptnoStr = request.getParameter("deptno");
			if(deptnoStr==null){
				deptnoStr = "0";
			}
			int deptnoInput = Integer.parseInt(deptnoStr);
			String sql = "SELECT * FROM EMP WHERE DEPTNO LIKE '%'||?";
			try{
				Class.forName(driver); // (1)
				conn = DriverManager.getConnection(url, "scott", "tiger"); // (2)
				pstmt = conn.prepareStatement(sql); // (3)
				pstmt.setInt(1, deptnoInput); // sql안의 ? 채우기
				rs = pstmt.executeQuery();
				out.print("<tr><th>사번</th><th>이름</th><th>직책</th><th>부서번호</th></tr>");
				if(rs.next()){
					// 해당 부서번호의 사원이 있는 경우
					do{
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					int deptno = rs.getInt("deptno");
					out.print("<tr><td>" + empno + "</td>"
								+ "<td>" + ename + "</td>"
								+ "<td>" + job + "</td>"
								+ "<td>" + deptno + "</td></tr>");
					}while(rs.next());
				}else{
					// 해당 부서번호의 사원이 없는 경우
					out.print("<tr><td colspan='4'>해당 부서번호의 사원이 없습니다</td></tr>");
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