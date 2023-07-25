package com.lec.quiz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {
	private String name;
	private String tel;
	private String address;
	private Date birthday;
	public Friend(String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
	public Friend(String name, String tel, String address, Date birthday) {
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		if(birthday!=null) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		return "�̸� : " + name + "\n�ּ� : " + address + "\n�ڵ���" + tel + "\n����" + sdf.format(birthday) + "\n";
		}
		return "�̸� : " + name + "\n�ּ� : " + address + "\n�ڵ���" + tel + "\n";
	}
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public String getAddress() {
		return address;
	}
	public Date getBirthday() {
		return birthday;
	}
	
}
