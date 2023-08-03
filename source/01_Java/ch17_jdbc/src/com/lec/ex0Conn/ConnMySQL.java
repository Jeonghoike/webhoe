package com.lec.ex0Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnMySQL {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver"; // 8.0.X
		String url = "jdbc:mysql://127.0.0.1:3306/kimdb?serverTimezone=UTC"; // 8.0.x
		Connection conn = null;
		try {
			Class.forName(driver); // 1. ����̹� �ε�
			System.out.println("1. ����̹� �ε� ����");
			conn = DriverManager.getConnection(url, "root", "mysql"); // 2. DB ���ᰴü 
			System.out.println("2. MySQL ���� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ���� : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
				try {
					if(conn!=null)	conn.close(); // �������ܰ� : DB ���� ����
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
	}
	
}