package com.lec.ex3_exceptionEx;

import java.util.Date;

public class Ex02_FriendNullPointException {
	public static void main(String[] args) {
		Friend hong = new Friend("È«±æµ¿", "010-9999-999", new Date(98,11,12));
		System.out.println(hong);
		Friend kim = new Friend("±è±æµ¿", "010-8888-8888");
		System.out.println(kim);
	}
}
