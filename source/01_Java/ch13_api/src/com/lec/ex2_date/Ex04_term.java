package com.lec.ex2_date;

import java.util.Date;
import java.util.GregorianCalendar;
// 두 시점 사이 계산 
public class Ex04_term {
	public static void main(String[] args) {
		Date now1 = new Date(); // 지금
		Date now2 = new Date(new GregorianCalendar(2023, 5, 26, 9, 30, 0).getTimeInMillis()); //특정 시점
		long now1Millis = now1.getTime(); // 1970.1.1 ~ now1까지의 밀리세컨
		long now2Millis = now2.getTime(); // 1970.1.1 ~ now2까지의 밀리세컨
		long day = (now1Millis - now2Millis)/ (1000*60*60*24);
		System.out.println("몇일 차이인지 : " + day);
	}
}
