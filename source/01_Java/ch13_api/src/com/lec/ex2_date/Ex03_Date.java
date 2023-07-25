package com.lec.ex2_date;

import java.util.Date;
import java.util.GregorianCalendar;

public class Ex03_Date {
	public static void main(String[] args) {
		Date now = new Date(); // 지금 시점
		// Date nowThat = new Date(2023-1900, 6, 12); 비추
		Date nowThat = new Date(new GregorianCalendar(2023, 6, 1).getTimeInMillis()); // 특정시점
		System.out.println(now);
		int year = now.getYear();
		System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$ta요일 %1$tH시(%1$tp %1$tl시) %1$tM분 %1$tS초", now);
		
	}
}
