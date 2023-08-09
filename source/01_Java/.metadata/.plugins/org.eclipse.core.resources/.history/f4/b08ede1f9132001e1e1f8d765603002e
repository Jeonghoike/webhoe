package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 수정할 부서번호를 받아 존재여부를 확인 후, 부서명, 근무지를 입력박아 update
public class UpdateDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		Statement stmt  = null;
		ResultSet rs    = null;
		Scanner scanner = new Scanner(System.in);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			System.out.print("수정할 부서번호는 ?");
			int deptno = scanner.nextInt();
			String selectSQL = "SELECT * FROM DEPT WHERE DEPTNO=" + deptno;
			rs = stmt.executeQuery(selectSQL);
			if(rs.next()) { // 존재하는 부서번호이므로 수정 진행
				System.out.print("수정할 부서명은 ?");
				String dname = scanner.next();
				System.out.print("수정할 위치는 ?");
				String loc = scanner.next();
				String updateSQL = String.format("UPDATE DEPT SET DNAME='%s', LOC='%s' WHERE DEPTNO=%d", 
													dname, loc, deptno);
				int result = stmt.executeUpdate(updateSQL);
				if(result>0) {
					System.out.println(deptno + "번 부서 수정 성공");
				}
			}else {
				System.out.println(deptno + "번 부서는 유효한 부서번호가 아닙니다");
			}			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
