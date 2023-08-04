package com.lec.ex5delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 삭제하고자 하는 부서번호를 입력받아 delete
public class DeleteDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		Statement stmt  = null;
		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제할 부서번호는 ?");
		int deptno = scanner.nextInt();
		String sql = "DELETE FROM DEPT WHERE DEPTNO=" + deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			if(result>0) {
				System.out.println(deptno + "번 부서 삭제 성공");
			}else {
				System.out.println(deptno + "번 부서 유효한 부서번호가 아닙니다");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} // try-catch-finally
	}
}
