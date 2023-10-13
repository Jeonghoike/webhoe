package com.lec.dto;

import java.sql.Timestamp;

public class BoardDto {
	private int bid;
	private String bname;
	private String btitle;
	private String bcontent;
	private String bemail;
	private int bhit;
	private String bpw;
	private int bgroup;
	private int bstep;
	private int bindent;
	private String bip;
	private Timestamp bdate;
	public BoardDto() { }
	public BoardDto(int bid, String bname, String btitle, String bcontent, String bemail, int bhit, String bpw,
			int bgroup, int bstep, int bindent, String bip, Timestamp bdate) {
		this.bid = bid;
		this.bname = bname;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bemail = bemail;
		this.bhit = bhit;
		this.bpw = bpw;
		this.bgroup = bgroup;
		this.bstep = bstep;
		this.bindent = bindent;
		this.bip = bip;
		this.bdate = bdate;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBemail() {
		return bemail;
	}
	public void setBemail(String bemail) {
		this.bemail = bemail;
	}
	public int getBhit() {
		return bhit;
	}
	public void setBhit(int bhit) {
		this.bhit = bhit;
	}
	public String getBpw() {
		return bpw;
	}
	public void setBpw(String bpw) {
		this.bpw = bpw;
	}
	public int getBgroup() {
		return bgroup;
	}
	public void setBgroup(int bgroup) {
		this.bgroup = bgroup;
	}
	public int getBstep() {
		return bstep;
	}
	public void setBstep(int bstep) {
		this.bstep = bstep;
	}
	public int getBindent() {
		return bindent;
	}
	public void setBindent(int bindent) {
		this.bindent = bindent;
	}
	public String getBip() {
		return bip;
	}
	public void setBip(String bip) {
		this.bip = bip;
	}
	public Timestamp getBdate() {
		return bdate;
	}
	public void setBdate(Timestamp bdate) {
		this.bdate = bdate;
	}
	@Override
	public String toString() {
		return "BoardDto [bid=" + bid + ", bname=" + bname + ", btitle=" + btitle + ", bcontent=" + bcontent
				+ ", bemail=" + bemail + ", bhit=" + bhit + ", bpw=" + bpw + ", bgroup=" + bgroup + ", bstep=" + bstep
				+ ", bindent=" + bindent + ", bip=" + bip + ", bdate=" + bdate + "]";
	}
}
