package com.lec.ch15.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class Emp {
	// emp테이블 컬럼 + dname, loc + startRow, endRow
	private int empno;
	private String ename;
	private String job;
	private String mgr; // 등록이나 수정할 때 빈스트링 입력이 가능하도록
	private Date hiredate;
	private int sal;
	private String comm; // 등록이나 수정할 때 빈스트링 입력이 가능하도록
	private int deptno;
	private String dname;
	private String loc;
	private int startRow; // 페이징 처리를 위한 속성 변수
	private int endRow;   // 페이징 처리를 위한 속성 변수
}
