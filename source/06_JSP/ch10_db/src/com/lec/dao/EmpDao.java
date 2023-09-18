package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lec.dto.EmpDto;

public class EmpDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url    = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid    = "scott";
	private String upw    = "tiger";
	private static EmpDao INSTANCE = new EmpDao(); // 자기 클래스를 참조하는 static 변수
	public static EmpDao getInstance() {
		return INSTANCE;
	}
	
	private EmpDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	// ex1 : 모든 empList 반환
	public ArrayList<EmpDto> empList() {
		ArrayList<EmpDto> dtos = new ArrayList<EmpDto>();
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet            rs = null;
		String sql = "SELECT * FROM EMP";
		try {
			conn = DriverManager.getConnection(url, uid, upw); // (2)
			pstmt = conn.prepareStatement(sql); // (3)
			rs = pstmt.executeQuery(); // (4) + (5)
			while(rs.next()) { // (6)
				int    empno    = rs.getInt("empno");
				String ename    = rs.getString("ename");
				String job      = rs.getString("job");
				int    mgr      = rs.getInt("mgr");
				Date   hiredate = rs.getDate("hiredate");
				int    sal      = rs.getInt("sal");
				int    comm     = rs.getInt("comm");
				int    deptno   = rs.getInt("deptno");
				dtos.add(new EmpDto(empno, ename, job, mgr, hiredate, sal, comm, deptno, null));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {	// (7)		
			try {
				if(rs   != null) rs.close();
				if(pstmt != null) rs.close();
				if(conn != null) rs.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());;
			}
		}
		return dtos;
	}
	// ex2 : deptno로 empList 반환(dname 불포함)
	public ArrayList<EmpDto> deptnoEmpList(int deptno){
		ArrayList<EmpDto> dtos = new ArrayList<EmpDto>();
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet            rs = null;
		String sql = "SELECT * FROM EMP WHERE DEPTNO LIKE '%'||?";
		try {
			conn = DriverManager.getConnection(url, uid, upw); // (2)
			pstmt = conn.prepareStatement(sql); // (3)
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery(); // (4) + (5)
			while(rs.next()) { // (6)
				int    empno    = rs.getInt("empno");
				String ename    = rs.getString("ename");
				String job      = rs.getString("job");
				int    mgr      = rs.getInt("mgr");
				Date   hiredate = rs.getDate("hiredate");
				int    sal      = rs.getInt("sal");
				int    comm     = rs.getInt("comm");
				deptno   = rs.getInt("deptno");
				dtos.add(new EmpDto(empno, ename, job, mgr, hiredate, sal, comm, deptno, null));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {	// (7)		
			try {
				if(rs   != null) rs.close();
				if(pstmt != null) rs.close();
				if(conn != null) rs.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());;
			}
		}
		return dtos;
	}
	// ex3 : deptno로 empList 반환(dname 포함)
	public ArrayList<EmpDto> dnameEmpList(int deptno){
		ArrayList<EmpDto> dtos = new ArrayList<EmpDto>();
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet            rs = null;
		String sql = "SELECT E.*, DNAME" + 
				" FROM EMP E, DEPT D " + 
				" WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO LIKE '%'||?";
		try {
			conn = DriverManager.getConnection(url, uid, upw); // (2)
			pstmt = conn.prepareStatement(sql); // (3)
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery(); // (4) + (5)
			while(rs.next()) { // (6)
				int    empno    = rs.getInt("empno");
				String ename    = rs.getString("ename");
				String job      = rs.getString("job");
				int    mgr      = rs.getInt("mgr");
				Date   hiredate = rs.getDate("hiredate");
				int    sal      = rs.getInt("sal");
				int    comm     = rs.getInt("comm");
				deptno   = rs.getInt("deptno");
				String dname    = rs.getString("dname"); 
				dtos.add(new EmpDto(empno, ename, job, mgr, hiredate, sal, comm, deptno, dname));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {	// (7)		
			try {
				if(rs   != null) rs.close();
				if(pstmt != null) rs.close();
				if(conn != null) rs.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());;
			}
		}
		return dtos;
	}
	// example : 해당 이름이 포함된 empList 반환
	public ArrayList<EmpDto> enameEmpList(String schname) {
		ArrayList<EmpDto> dtos = new ArrayList<EmpDto>();
		Connection         conn = null;
		PreparedStatement pstmt = null;
		ResultSet            rs = null;
		String sql = "SELECT E.*, DNAME " + 
				" FROM EMP E, DEPT D" + 
				" WHERE E.DEPTNO=D.DEPTNO AND E.ENAME LIKE '%'||TRIM(UPPER(?))||'%'";
		try {
			conn = DriverManager.getConnection(url, uid, upw); // (2)
			pstmt = conn.prepareStatement(sql); // (3)
			pstmt.setString(1, schname);
			rs = pstmt.executeQuery(); // (4) + (5)
			while(rs.next()) { // (6)
				int    empno    = rs.getInt("empno");
				String ename    = rs.getString("ename");
				String job      = rs.getString("job");
				int    mgr      = rs.getInt("mgr");
				Date   hiredate = rs.getDate("hiredate");
				int    sal      = rs.getInt("sal");
				int    comm     = rs.getInt("comm");
				int deptno   = rs.getInt("deptno");
				String dname = rs.getString("dname");
				dtos.add(new EmpDto(empno, ename, job, mgr, hiredate, sal, comm, deptno, dname));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {	// (7)		
			try {
				if(rs   != null) rs.close();
				if(pstmt != null) rs.close();
				if(conn != null) rs.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());;
			}
		}
		return dtos;
	}
}
