package com.lec.ex.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.ex.dto.MemberDto;


public class MemberDao {
	public static final int EXISTENT = 0;
	public static final int NONEXISTENT = 1;
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	public static final int LOGIN_FAIL = 0;
	public static final int LOGIN_SUCCESS = 1;
	private DataSource ds;
	// 싱글톤
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	private MemberDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	// 1. 회원mid 중복체크
	public int midConfirm(String mid) {
		int result = EXISTENT;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM MVC_MEMBER WHERE mID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = EXISTENT;
			}else {
				result = NONEXISTENT;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 2. 이메일 중복체크
	public int memailConfirm(String memail) {
		int result = EXISTENT;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT COUNT(*) CNT FROM MVC_MEMBER WHERE MEMAIL=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memail);
			rs = pstmt.executeQuery();
				rs.next();
				int cnt = rs.getInt("cnt");
				if(cnt==1) {
					result = EXISTENT;
				}else if(cnt == 0){
					result = NONEXISTENT;
				}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	//(3) 회원가입
	public int joinMember(MemberDto member) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVC_MEMBER "
				+ "		(mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress) "
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getMpw());
			pstmt.setString(3, member.getMname());
			pstmt.setString(4, member.getMemail());
			pstmt.setString(5, member.getMphoto());
			pstmt.setDate(6, member.getMbirth());
			pstmt.setString(7, member.getMaddress());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	//(4) 로그인
	public int loginCheck(String mid, String mpw) {
		int result = LOGIN_FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM MVC_MEMBER WHERE mID = ? and mPW = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, mpw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = LOGIN_SUCCESS;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	//(5) mid로 dto가져오기(로그인 성공시 session에 setAttribute하기 위함)
	public MemberDto getMember(String mid) {
		MemberDto member = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM MVC_MEMBER WHERE mId = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//String mid     = rs.getString("mid");
				String mpw       = rs.getString("mpw");
				String mname     = rs.getString("mname");
				String memail    = rs.getString("memail");
				String mphoto    = rs.getString("mphoto");;
				Date   mbirth    = rs.getDate("mbirth");
				String maddress  = rs.getString("maddress");
				Timestamp mrdate = rs.getTimestamp("mrdate");
				member = new MemberDto(mid, mpw, mname, memail, mphoto, 
								mbirth, maddress, mrdate);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return member;
	}
	//(6) 회원정보수정 (특정mid의 정보 수정)
	public int modifyMember(MemberDto member) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_MEMBER SET mPw = ?, " + 
				"                    mName = ?, " + 
				"                    mEmail = ?, " + 
				"                    mPhoto = ?, " + 
				"                    mBirth = ?, " + 
				"                    mAddress = ? " + 
				"        WHERE mId = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMpw());
			pstmt.setString(2, member.getMname());
			pstmt.setString(3, member.getMemail());
			pstmt.setString(4, member.getMphoto());
			pstmt.setDate(5, member.getMbirth());
			pstmt.setString(6, member.getMaddress());
			pstmt.setString(7, member.getMid());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	//(7) 회원리스트(top-N구문) : 이름순으로 회원리스트
	public ArrayList<MemberDto> getMemberlist(int startRow, int endRow){
		ArrayList<MemberDto> members = new ArrayList<MemberDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * "
				+ "FROM (SELECT ROWNUM RN, A.* FROM "
				+ "					(SELECT * FROM MVC_MEMBER ORDER BY mname) A)" + 
				"        WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String mid       = rs.getString("mid");
				String mpw       = rs.getString("mpw");
				String mname     = rs.getString("mname");
				String memail    = rs.getString("memail");
				String mphoto    = rs.getString("mphoto");;
				Date   mbirth    = rs.getDate("mbirth");
				String maddress  = rs.getString("maddress");
				Timestamp mrdate = rs.getTimestamp("mrdate");
				MemberDto member = new MemberDto(mid, mpw, mname, memail, mphoto, 
								mbirth, maddress, mrdate);
				members.add(member);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return members;
	}
	//(8) 회원수
	public int getMemberTotCnt() {
		int totCnt = 0;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT COUNT(*) CNT FROM MVC_MEMBER";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totCnt = rs.getInt("cnt");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return totCnt;
	}
	//(9) 회원탈퇴시 탈퇴 mID로 작성한 모든 글 삭제 
	public int withdrawalMember(String mid) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM MVC_MEMBER WHERE MID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
}
