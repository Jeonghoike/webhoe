package com.lec.dao;

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

import com.lec.dto.BoardDto;

public class BoardDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	// 싱글톤 
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	private BoardDao() {}
	private Connection getConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	// 1. 글목록(전체 글 그룹 최신글이 위로)
	public ArrayList<BoardDto> listBoard(){
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOARD ORDER BY BGROUP DESC";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bemail = rs.getString("bemail");
				int bhit = rs.getInt("bhit");;
				String bpw = rs.getString("bpw");
				int bgroup = rs.getInt("bgroup");;
				int bstep = rs.getInt("bstep");;
				int bindent = rs.getInt("bindent");;
				String bip = rs.getString("bip");
				Timestamp bdate = rs.getTimestamp("bdate");
				dtos.add(new BoardDto(bid, bname, btitle, bcontent, bemail, bhit, bpw, bgroup, bstep, bindent, bip, bdate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	// 2. 전체 글 갯수
	public int getBoardTotalCnt() {
		int totalCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM BOARD";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totalCnt = rs.getInt("cnt");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
		}
		return totalCnt;
	}
	// 3. 원글쓰기 - 작성자, 글제목, 본문, 이메일, 비번, IP (BGRUOP은 글번호, BSTEP은 0, BINDENT는 0)
	public int writeBoard(BoardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO BOARD (BID, BNAME, BTITLE, BCONTENT, BEMAIL, BPW, BGROUP, BSTEP, BINDENT, BIP) " + 
				"    VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, BOARD_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBname());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setString(4, dto.getBemail());
			pstmt.setString(5, dto.getBpw());
			pstmt.setString(6, dto.getBip());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
}
