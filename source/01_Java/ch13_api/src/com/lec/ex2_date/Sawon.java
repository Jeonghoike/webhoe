package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon {
	private String sawonNo;
	private String sawonName;
	private String sawonDep;
	private Date sawonDate;
	public Sawon(String sawonNo, String sawonName, String sawonDep) {
		this.sawonNo = sawonNo;
		this.sawonName = sawonName;
		this.sawonDep = sawonDep;	
		sawonDate = new Date();
	}
	public Sawon(String sawonNo, String sawonName, String sawonDep, int y, int m, int d) {
		this.sawonNo = sawonNo;
		this.sawonName = sawonName;
		this.sawonDep = sawonDep;	
		sawonDate = new Date(new GregorianCalendar(y, m-1, d).getTimeInMillis());
	}
	public String infoString() { 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��, M��, d��");
		String result = "[���] :" + sawonNo;
		result += "\t[�̸�]" + sawonName;
		result += "[�μ�]" + sawonDep;
		result += "[�Ի���]" + sdf.format(sawonDate);
		return result;	
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return "[���]"+ sawonNo + "[�̸�]" + sawonName + "\t[�μ�]" + sawonDep + "\t[�Ի���]" + sdf.format(sawonDate);
	}
}
