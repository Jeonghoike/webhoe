package com.lec.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.ex.dto.BoardDto;

public class BoardDao {
	public static final int SUCCESS = 1;
	public final int FAIL = 0;
	private DataSource ds;
	public BoardDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	//  1. 글목록 (startRow부터 endRow)
	public ArrayList<BoardDto> listBoard(int startRow, int endRow){
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * " + 
				"    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP) A) " + 
				"    WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int bid         = rs.getInt("bid");
				String bname    = rs.getString("bname");
				String btitle   = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit        = rs.getInt("bhit");
				int bgroup      = rs.getInt("bgroup");
				int bstep       = rs.getInt("bstep");
				int bindent     = rs.getInt("bindent");
				String bip      = rs.getString("bip");
				dtos.add(new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bip));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	//	2. 글갯수
	public int getBoardTotCnt() {
		int totCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT  FROM MVC_BOARD";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totCnt = rs.getInt("cnt"); // 엘리아스를 주지 않았으면 1 ( 첫번째열)
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return totCnt;
	}
	//	3. 원글쓰기 (사용자로부터 입력받은 bname, btitle, bcontent, bip, bgroup은 글번호, bstep, bindent은 0)
	public int writeBoard(BoardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVC_BOARD (bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP) " + 
				"    VALUES (MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, MVC_BOARD_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBname());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setString(4, dto.getBip());
			pstmt.executeUpdate();
			result = SUCCESS;
			System.out.println("원글 쓰기 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " : 원글쓰기 실패 " + dto);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	public int writeBoard(String bname, String btitle, String bcontent, String bip) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVC_BOARD (bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP) " + 
				"    VALUES (MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, MVC_BOARD_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setString(4, bip);
			pstmt.executeUpdate();
			result = SUCCESS;
			System.out.println("원글 쓰기 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " : 원글쓰기 실패 ");
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	//	4. bid로 조회수 1 올리기
	public void hitUp(int bid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_BOARD SET BHIT = BHIT+1 WHERE BID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			pstmt.executeUpdate();
			System.out.println(bid + "번 글 조회수 up");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " : 조회수 업 실패");
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	//	5. bid로 dto가져오기
	public BoardDto getBoardNotHitUp(int bid) {
		BoardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MVC_BOARD WHERE BID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String bname    = rs.getString("bname");
				String btitle   = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit        = rs.getInt("bhit");
				int bgroup      = rs.getInt("bgroup");
				int bstep       = rs.getInt("bstep");
				int bindent     = rs.getInt("bindent");
				String bip      = rs.getString("bip");
				dto = new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bip);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	//	6. 글수정 (특정 bid의 bname, btitle, bcontent, bip 수정)
	public int modifyBoard(int bid, String bname, String btitle, String bcontent, String bip) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_BOARD " + 
				"    SET BNAME = ?, " + 
				"        BTITLE = ?, " + 
				"        BCONTENT = ?, " + 
				"        BIP = ? " + 
				"    WHERE BID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setString(4, bip);
			pstmt.setInt(5, bid);
			pstmt.executeUpdate();
			result = SUCCESS;
			System.out.println(result==SUCCESS ? "글 수정 성공" : "글 번호(bid) 오류");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " : 글 수정 실패 ");
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	//	7. 글삭제 (특정 bid 삭제)
	public int deleteBoard(int bid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM MVC_BOARD WHERE BID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "글 삭제 성공" : "글 번호(bid) 오류");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " : 글 삭제 실패 ");
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	//	8. 답변글 저장 전단계(엑셀 ⓐ 단계)
	private void preReplyStep(int bgroup, int bstep) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_BOARD SET BSTEP = BSTEP+1 " + 
				"    WHERE BGROUP =? AND BSTEP>?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bgroup);
			pstmt.setInt(2, bstep);
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 bstep 재조정 됨");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "preReplyStep 오류");
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	//	9. 답변글 저장
		// 답변글쓴이 : bname, btitle, bcontent
		// 시스템으로 : bip
		// 원글 정보 : bgroup, bstep, bindent
	public int replyBoard(String bname, String btitle, String bcontent, String bip, int bgroup, int bstep, int bindent) {
		int result = FAIL;
		preReplyStep(bgroup, bstep);
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVC_BOARD (bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP) " + 
				"    VALUES (MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setInt(4, bgroup);
			pstmt.setInt(5, bstep+1);
			pstmt.setInt(6, bindent+1);
			pstmt.setString(7, bip);
			pstmt.executeUpdate();
			result = SUCCESS;
			System.out.println("답변글 쓰기 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " : 답변글쓰기 실패 " );
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
}
