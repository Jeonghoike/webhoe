package com.lec.ch18.dto;
import java.sql.Date;
import java.sql.Timestamp;
public class MemberDto {
	private String id;
	private String pw;
	private String name;
	private Date   birth;
	private Timestamp rdate;
	public MemberDto() {}
	public MemberDto(String id, String pw, String name, Date birth, Timestamp rdate) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.rdate = rdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Timestamp getRdate() {
		return rdate;
	}
	public void setRdate(Timestamp rdate) {
		this.rdate = rdate;
	}
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pw=" + pw + ", name=" + name + ", birth=" + birth + ", rdate=" + rdate + "]";
	}
}
