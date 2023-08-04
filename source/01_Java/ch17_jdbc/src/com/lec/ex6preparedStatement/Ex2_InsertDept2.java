package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// 입력받은 부서번호를 중복체크한 후 부서명, 위치를 입략빋이 insert
public class Ex2_InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String selectQuery = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=?";
		String insertQuery = "INSERT INTO DEPT VALUES (?, ?, ?)";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(selectQuery);
			System.out.print("입력할 부서번호는 ?");
			int deptno = scanner.nextInt();
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			rs.next();
			int cnt = rs.getInt("cnt");
			if(cnt!=0) {
				System.out.println("중복된 부서번호는 입력이 불가합니다");
			}else {
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(insertQuery);
				pstmt.setInt(1, deptno);
				System.out.print("입력할 부서명은 ?");
				pstmt.setString(2, scanner.next());
				System.out.print("입력할 부서위치는 ?");
				pstmt.setString(3, scanner.next());
				int result = pstmt.executeUpdate();
				System.out.println(result>0?"입력성공" : "입력실패");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs    !=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}// try-catch-finally
	}
}
