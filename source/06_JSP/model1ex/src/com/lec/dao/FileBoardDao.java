package com.lec.dao;

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

import com.lec.dto.FileBoardDto;

public class FileBoardDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	//싱글톤
	private static FileBoardDao instance = new FileBoardDao();
	public static FileBoardDao getInstance() {
		return instance;
	}
	private FileBoardDao() {}
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	// 1. 글목록
	public ArrayList<FileBoardDto> listFileBoard(int startRow, int endRow){
		ArrayList<FileBoardDto> dtos = new ArrayList<FileBoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * " + 
				"    FROM(SELECT ROWNUM RN, A.* " + 
				"            FROM(SELECT F.*, CNAME, CEMAIL " + 
				"                    FROM FILEBOARD F, CUSTOMER C " + 
				"                    WHERE F.CID=C.CID " + 
				"                    ORDER BY FGROUP DESC, FSTEP)A) " + 
				"    WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int fid = rs.getInt("fid");
				String cid = rs.getString("cid");
				String ftitle = rs.getString("ftitle");
				String fcontent = rs.getString("fcontent");
				String filename = rs.getString("filename");
				int fhit= rs.getInt("fhit");
				String fpw = rs.getString("fpw");
				int fgroup= rs.getInt("fgroup");
				int fstep = rs.getInt("fstep");
				int findent = rs.getInt("findent");
				String fip = rs.getString("fip");
				Timestamp frdate = rs.getTimestamp("frdate");
				String cname = rs.getString("cname");
				String cemail = rs.getString("cemail"); 
				dtos.add(new FileBoardDto(fid, cid, ftitle, fcontent, filename, fhit, fpw, fgroup, fstep, findent, fip, frdate, cname, cemail));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   != null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	// 2. 전체 글 갯수
	public int getFileBoardTotalCnt() {
		int totalCnt = 0;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql ="SELECT COUNT(*) CNT FROM FILEBOARD";
		try {
			conn  = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs    = pstmt.executeQuery();
			rs.next();
			totalCnt = rs.getInt("cnt");
		} catch (SQLException e) {
			System.out.println("cnt : "+e.getMessage());
		}finally {
			try {
				if(rs   != null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return totalCnt;
	}
	// 3. 글쓰기
	public int writeFileBoard(FileBoardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (FID, CID, FTITLE, FCONTENT, FILENAME, FPW, FGROUP, FSTEP, FINDENT, FIP)" + 
				"    VALUES (FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, FILEBOARD_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getFtitle());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(4, dto.getFilename());
			pstmt.setString(5, dto.getFpw());
			pstmt.setString(6, dto.getFip());
			result = pstmt.executeUpdate();
			System.out.println("글쓰기 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "글쓰다 예외발생 : " + dto);
		}finally {
			try {
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 4. fid로 조회수 1올리기
	public void hitUp(int fid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET FHIT = FHIT + 1 WHERE FID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			pstmt.executeUpdate();
			System.out.println(fid + "번 글 조회수 1up");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	// 5. fid로 dto가져오기
	public FileBoardDto getFileBoardNotHitUp(int fid) {
		FileBoardDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C " + 
				"  WHERE F.CID = C.CID AND FID=? " + 
				"  ORDER BY fGROUP DESC, fSTEP";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String cid = rs.getString("cid");
				String ftitle = rs.getString("ftitle");
				String fcontent = rs.getString("fcontent");
				String filename = rs.getString("filename");
				int fhit= rs.getInt("fhit");
				String fpw = rs.getString("fpw");
				int fgroup= rs.getInt("fgroup");
				int fstep = rs.getInt("fstep");
				int findent = rs.getInt("findent");
				String fip = rs.getString("fip");
				Timestamp frdate = rs.getTimestamp("frdate");
				String cname = rs.getString("cname");
				String cemail = rs.getString("cemail");
				dto = new FileBoardDto(fid, cid, ftitle, fcontent, filename, fhit, fpw, fgroup, fstep, findent, fip, frdate, cname, cemail);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   != null) rs.close();
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	// 6. 글수정 : 글제목, 본문, 첨부파일, 비번, ip수정
	public int modifyFileBoard(FileBoardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD " + 
				"  SET FTITLE = ?, " + 
				"      FCONTENT = ?, " + 
				"      FILENAME = ?, " + 
				"      FPW    = ?, " + 
				"      FIP    = ? " + 
				"  WHERE FID=? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getFtitle());
			pstmt.setString(2, dto.getFcontent());
			pstmt.setString(3, dto.getFilename());
			pstmt.setString(4, dto.getFpw());
			pstmt.setString(5, dto.getFip());
			pstmt.setInt(6, dto.getFid());
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "글수정 성공" : "글수정 실패(fid오류)");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "글수정 예외 발생 : " + dto);
		}finally {
			try {
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 7. 글삭제 (fid, fpw)
	public int deleteFileBoard(int fid, String fpw) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD WHERE FID=? AND FPW=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			pstmt.setString(2, fpw);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "글삭제 성공" : "글삭제 실패(비번확인)");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result; 
	}
	// 8. 답변글 쓰기 전단계(엑셀 a단계)
	private void preReplyStep(int fgroup, int fstep) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET FSTEP = FSTEP+1 WHERE FGROUP=? AND FSTEP>?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fgroup);
			pstmt.setInt(2, fstep);
			int cnt = pstmt.executeUpdate();
			System.out.println("기존 답변글" + cnt + "개 bstep 조정됨");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	// 9. 답변글 쓰기
	public int replyFileBoard(FileBoardDto dto) {
		int result = FAIL;
		preReplyStep(dto.getFgroup(), dto.getFstep());
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (fID, cID, fTITLE, fCONTENT, FILENAME, fPW, " + 
				"                fGROUP, fSTEP, fINDENT, fIP) " + 
				"        VALUES (FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, " + 
				"                ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getFtitle());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(4, dto.getFilename());
			pstmt.setString(5, dto.getFpw());
			pstmt.setInt(6, dto.getFgroup());
			pstmt.setInt(7, dto.getFstep());
			pstmt.setInt(8, dto.getFindent());
			pstmt.setString(9, dto.getFip());
			System.out.println("원글쓰기 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "답변글쓰다 예외 발생 : " + dto);
		}finally {
			try {
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
}
