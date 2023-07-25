package com.lec.ex3_exceptionEx;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {
	private String name;
	private String tel;
	private Date birth;
	public Friend(String name, String tel) {
		super();
		this.name = name;
		this.tel = tel;
		//birth = null;
	}
	public Friend(String name, String tel, Date birth) {
		super();
		this.name = name;
		this.tel = tel;
		this.birth = birth;
	}
	@Override
	public String toString() {
		if(birth!=null) { // birth°¡ ¾Æ´Ï¸é ¹Ø¿¡
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		return "[name]" + name + "\t[tel]" + tel + "\t[birth]" + sdf.format(birth) ;
		}
		// birthÀÌ¸é ¹Ø¿¡
		return "[name]" + name + "\t[tel]" + tel;
	}
}
