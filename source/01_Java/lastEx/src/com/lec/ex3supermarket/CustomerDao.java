package com.lec.ex3supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public final static int SUCCESS =1;
	public final static int FAIL    =0;
	// dao는 싱글톤 구현 = private 생성자에는 driver로드(1단계)
	private static CustomerDao INSTANCE;
	public static CustomerDao getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new CustomerDao();
		}
		return INSTANCE;
	}
	private CustomerDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	// -- 1. 회원가입(고객전화와 고객이름은 입력받아 INSERT)
    public int insertCustomer (String ctel, String cname) {
    	int result = FAIL;
    	// ctel과 cname으로 customer insert (2~7단계)
    	Connection        conn  = null;
    	PreparedStatement pstmt = null;
    	String sql = "INSERT INTO CUSTOMER (CID, CTEL, CNAME)"
    			+ "    VALUES (CUSTOMER_CID_SEQ.NEXTVAL, ?, ?)";
    	try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			pstmt.setString(2, cname);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} // try-catch-finally
    	return result;
    }
    //-- 2. 폰뒤4자리(풀번호) 검색
    public ArrayList<CustomerDto> ctelGetCustomers(String searchTel){  // 컨트롤 시프트 o 임폴트 없는건 있게, 필요없는건 삭제
    	ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
    	// searchTel로 검색한 후 dtos에 add
    	Connection        conn  = null;
    	PreparedStatement pstmt = null;
    	ResultSet         rs    = null;
    	String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME,"
    			+ "        (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CID=C.CID) forLevelUp"
    			+ "    FROM CUSTOMER C, CUS_LEVEL L"
    			+ "    WHERE C.LEVELNO=L.LEVELNO AND CTEL LIKE '%'||?"
    			+ "    ORDER BY CAMOUNT DESC, CID";
    	try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchTel);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int    cid        = rs.getInt("cid");
				String ctel       = rs.getString("ctel");
				String cname      = rs.getString("cname");
				int    cpoint     = rs.getInt("cpoint");
				int    camount    = rs.getInt("camount");
				String levelName  = rs.getString("levelName");
				int    forLevelUp = rs.getInt("forLevelUp");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} // try-catch-finally
    	return dtos;
    }
    // 3. 물품구입 
    public int buy(int cid, int price) {
    	int result = FAIL;
    	// cid price로 물품구매 update
    	Connection        conn  = null;
    	PreparedStatement pstmt = null;
    	String sql ="UPDATE CUSTOMER "
    			+ "        SET CPOINT = CPOINT + (? * 0.05),"
    			+ "            CAMOUNT = CAMOUNT + ?,"
    			+ "            LEVELNO = (SELECT L.LEVELNO"
    			+ "                            FROM CUSTOMER C, CUS_LEVEL L"
    			+ "                            WHERE CAMOUNT + ? BETWEEN LOW AND HIGH AND CID =?)"
    			+ "        WHERE CID=?";
    	try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setInt(2, price);
			pstmt.setInt(3, price);
			pstmt.setInt(4, cid);
			pstmt.setInt(5, cid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} // try-catch-finally
    	return result;
    }
    // 3번 물품구매 후 고객정보를 출력
    public CustomerDto getCustomer(int cid) {
    	CustomerDto dto = null;
    	// cid로 검색 결과를 dto에 할당
    	Connection        conn  = null;
    	PreparedStatement pstmt = null;
    	ResultSet         rs    = null;
    	String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME,"
    			+ "            (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CID=C.CID) forLevelUp"
    			+ "        FROM CUSTOMER C, CUS_LEVEL L"
    			+ "        WHERE C.LEVELNO=L.LEVELNO AND CID=?";
    	try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) { // 검색결과가 있는 경우(cid가 있는 경우), dto에 CustomerDto 객체를 생성해서 할당
				//int    cid        = rs.getInt("cid");
				String ctel       = rs.getString("ctel");
				String cname      = rs.getString("cname");
				int    cpoint     = rs.getInt("cpoint");
				int    camount    = rs.getInt("camount");
				String levelName  = rs.getString("levelName");
				int    forLevelUp = rs.getInt("forLevelUp");
				dto = new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} // try-catch-finally
    	return dto;
    }
    // 4번 전 고객등급별 추출
    public ArrayList<String> getLevelnames(){
    	ArrayList<String> levelNames = new ArrayList<String>();
    	// 고객레벨이름들을 levelNames에 add
    	Connection        conn  = null;
    	PreparedStatement pstmt = null;
    	ResultSet         rs    = null;
    	String sql = "SELECT LEVELNAME FROM CUS_LEVEL";
    	try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) { 
				levelNames.add(rs.getString("levelName"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} // try-catch-finally
    	return levelNames;
    }
    // 4번 고객등급별(등급이름) 출력
    public ArrayList<CustomerDto> levelNameGetCustomers(String levelName){
    	ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
    	Connection        conn  = null;
    	PreparedStatement pstmt = null;
    	ResultSet         rs    = null;
    	String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME,"
    			+ "    (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CID=C.CID) forLevelUp"
    			+ "    FROM CUSTOMER C, CUS_LEVEL L "
    			+ "    WHERE C.LEVELNO=L.LEVELNO AND LEVELNAME = UPPER(?)"
    			+ "    ORDER BY CAMOUNT DESC, CID";
    	try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, levelName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int    cid        = rs.getInt("cid");
				String ctel       = rs.getString("ctel");
				String cname      = rs.getString("cname");
				int    cpoint     = rs.getInt("cpoint");
				int    camount    = rs.getInt("camount");
				//String levelName  = rs.getString("levelName");
				int    forLevelUp = rs.getInt("forLevelUp");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} // try-catch-finally
    	return dtos;
    }
    // 5번 고객 전체 출력
    public ArrayList<CustomerDto> GetCustomers(){
    	ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
    	Connection        conn  = null;
    	PreparedStatement pstmt = null;
    	ResultSet         rs    = null;
    	String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME,"
    			+ "    (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CID=C.CID) forLevelUp"
    			+ "    FROM CUSTOMER C, CUS_LEVEL L "
    			+ "    WHERE C.LEVELNO=L.LEVELNO "
    			+ "    ORDER BY CAMOUNT DESC, CID";
    	try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int    cid        = rs.getInt("cid");
				String ctel       = rs.getString("ctel");
				String cname      = rs.getString("cname");
				int    cpoint     = rs.getInt("cpoint");
				int    camount    = rs.getInt("camount");
				String levelName  = rs.getString("levelName");
				int    forLevelUp = rs.getInt("forLevelUp");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} // try-catch-finally
    	return dtos;
    }
    // 6번 회원탈퇴
    public int deleteCustomer(String ctel) {
    	int result = FAIL;
    	Connection        conn  = null;
    	PreparedStatement pstmt = null;
    	String sql = "DELETE FROM CUSTOMER WHERE CTEL=?";
    	try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} // try-catch-finally
    	return result;
    }
 } // class
