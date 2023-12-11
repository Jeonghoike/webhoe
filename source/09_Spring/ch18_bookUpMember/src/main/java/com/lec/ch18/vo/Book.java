package com.lec.ch18.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class Book {
	private int bnum;
	private String btitle;
	private String bwriter;
	private Date brdate;
	private String bimg1;
	private String bimg2;
	private String binfo;
	// top-N 구문에서 필요한 필드
	private int startRow;
	private int endRow;
	// 검색을 위한 필드
	// private String schItem;
	// private String shcWord;
}
