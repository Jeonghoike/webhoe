package com.lec.ex4_object;

import java.text.SimpleDateFormat;
import java.util.Date;
// new Friend("홍", "010-9999-9999", "서울 서대문구", new Date(98, 11, 12))
// new Friend("홍", "010-9999-9999", "서울 서대문구", new Date(new GregofianCalendar(1998,11,12).getTime~();))
public class Friend {
	private String name;
	private String tel;
	private String address;
	private Date birthdy;
	public Friend(String name, String tel, String address, Date birthdy) {
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.birthdy = birthdy;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		return "이름 :"+name + "\n주소 :" + address + "\n핸드폰 : "+ tel + "\n생일: " + sdf.format(birthdy) + "\n"; 
	}
	
	// getter
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public String getAddress() {
		return address;
	}
	public Date getBirthdy() {
		return birthdy;
	}
	
}
