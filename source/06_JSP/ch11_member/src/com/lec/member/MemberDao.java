package com.lec.member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class MemberDao {
	public static final int MEMBER_EXISTENT = 0; // ID중복체크시 존재하는 ID일 경우 return 값
	public static final int MEMBER_NONEXISTENT = 1; // 사용가능한 ID일 경우 return 값
	public static final int LOGIN_SUCCESS = 1; // 로그인 성공시 return 값
	public static final int LOGIN_FAIL_PW = 0; // 로그인시 PW 오류일 때 return 값
	public static final int LOGIN_FAIL_ID = -1; // 로그인시 ID 오류일 때 return 값
	public static final int SUCCESS = 1; // 회원가입, 회원정보수정시 성공할 때 return 값
	public static final int FAIL    = 0; // 회원가입, 회원정보수정시 실패할 때 return 값
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url    = "jdbc:oracle:thin:@localhost:1521:xe";
	// 싱글톤
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() {
//		if(instance!=null) {
//			instance = new MemberDao();
//		}
		return instance;
	}
	private MemberDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	// connection 객체를 return
	private Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url, "scott", "tiger");
		return conn;
	}
	// 1. 회원가입시 ID 중복체크 : 
	public int confirmID(String id) {
		int result = MEMBER_EXISTENT;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		try {
			conn = getConnection(); // (2)
			pstmt = conn.prepareStatement(sql); // (3)
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); // (4) + (5)
			if(rs.next()) {
				// 중복된 id를 검색
				result = MEMBER_EXISTENT;
			}else {
				// 없는 id(사용가능한 id 검색)
				result = MEMBER_NONEXISTENT;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 2. 회원가입 INSERT : 
	public int joinMember(MemberDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MEMBER (ID, PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, ADDRESS, RDATE) " + 
				"    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone1());
			pstmt.setString(5, dto.getPhone2());
			pstmt.setString(6, dto.getPhone3());
			pstmt.setString(7, dto.getGender());
			pstmt.setString(8, dto.getEmail());
			pstmt.setDate(9, dto.getBirth());
			pstmt.setString(10, dto.getAddress());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "회원가입성공" : "회원가입실패");
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("회원가입 실패 : " + dto);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 3. 로그인 : 
	public int loginCheck(String id, String pw) {
		int result = LOGIN_FAIL_PW;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		try {
			conn = getConnection(); // (2)
			pstmt = conn.prepareStatement(sql); // (3)
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); // (4) + (5)
			if(rs.next()) {
				// 유효한 ID를 입력한 경우
				String dbPw = rs.getString("pw"); // DB에 있는 pw
				if(dbPw.equals(pw)) { // pw가 맞는지 체크하는 if
					result = LOGIN_SUCCESS;
				}else {
					result = LOGIN_FAIL_PW;
				}
			}else {
				// 유효하지 않은 ID를 입력한 경우
				result = LOGIN_FAIL_ID;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 4. 로그인 성공시 session에 setAttribute할 회원 정보(id로 dto가져오기) : 
	public MemberDto getMember(String id) {
		MemberDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		try {
			conn = getConnection(); // (2)
			pstmt = conn.prepareStatement(sql); // (3)
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); // (4) + (5)
			if(rs.next()) {
				String pw       = rs.getString("pw");
				String name     = rs.getString("name");
				String phone1   = rs.getString("phone1");
				String phone2   = rs.getString("phone2");
				String phone3   = rs.getString("phone3");
				String gender   = rs.getString("gender");
				String email    = rs.getString("email");
				Date   birth    = rs.getDate("birth");
				String address  = rs.getString("address");
				Timestamp rdate = rs.getTimestamp("rdate");
				dto = new MemberDto(id, pw, name, phone1, phone2, phone3, gender, email, birth, address, rdate);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs    != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	// 5. 회원정보 수정 : 
	public int modifyMember(MemberDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER " + 
				"    SET PW = ?, " + 
				"        NAME = ?, " + 
				"        PHONE1 = ?, " + 
				"        PHONE2 = ?, " + 
				"        PHONE3 = ?, " + 
				"        GENDER = ?, " + 
				"        EMAIL = ?, " + 
				"        BIRTH = ?, " + 
				"        ADDRESS = ? " + 
				"    WHERE ID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPhone1());
			pstmt.setString(4, dto.getPhone2());
			pstmt.setString(5, dto.getPhone3());
			pstmt.setString(6, dto.getGender());
			pstmt.setString(7, dto.getEmail());
			pstmt.setDate(8, dto.getBirth());
			pstmt.setString(9, dto.getAddress());
			pstmt.setString(10, dto.getId());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "회원수정성공" : "회원수정실패:"+dto);
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("회원수정 실패 : " + dto);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
}
