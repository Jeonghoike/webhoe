package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 사용자로부터 부서명을 입력받아 해당 부서정보를 출력(Ex1참조)
public class Ex3_selectWhereDname {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		Statement stmt  = null;
		ResultSet rs    = null;
		Scanner scanner = new Scanner(System.in);
		System.out.print("원하는 부서명은 ?");
		String dname = scanner.next();
		String sql = "SELECT * FROM DEPT WHERE DNAME ='" + dname +"'";
		sql = String.format("SELECT * FROM DEPT WHERE DNAME =upper('%s')", dname);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs   = stmt.executeQuery(sql);
			if(rs.next()) {
				System.out.println("부서번호 : " + rs.getInt("deptno"));
				System.out.println("부서명 : " + rs.getString("dname"));
				System.out.println("부서위치 : " + rs.getString("loc"));
			}else {
				System.out.println("해당 부서명은 존재하지 않습니다");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally { // 7. DB연결해제
			try {
				if(rs  !=null) rs.close();      // 생성한것 반대로 close
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} // try-catch-finally	
	}
}
