package com.lec.ex6preparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
// 부서번호, 부서명, 위치 입력받아 insert
public class Ex1_insertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		String sql = "INSERT INTO DEPT VALUES (?, ?, ?)";
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		System.out.print("추가할 부서번호는 ?");
		int deptno = scanner.nextInt();
		System.out.print("추가할 부서명은 ?");
		String dname = scanner.next();
		System.out.print("추가할 부서위치는 ?");
		String loc = scanner.next();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			//stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql); // ?가 3개 있는 sql / pstmt : SQL전송객체
			// 물음표 체우기
			pstmt.setInt(1, deptno); // deptno가 int값이라서 setInt()함수 이용
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			int result = pstmt.executeUpdate();
			System.out.println(result>0 ? deptno+"번 입력 성공" : deptno+"번 입력 실패");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
		    }
		}
	}
}
