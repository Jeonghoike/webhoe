package com.lec.ex2_date;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ex02_GregorianCalendar {
	public static void main(String[] args) {
		//Calendar nowCal = Calendar.getInstance();
		GregorianCalendar now = new GregorianCalendar(); // 매개변수가 없으면 지금 시점 
		
		System.out.println(now);
		//2023년7월 12일 수요일 13시 (오전1시)xx분xx초
		int year = now.get(Calendar.YEAR); 
		int month =now.get(Calendar.MONTH) + 1; // 컴퓨터는 0월 부터있기 때문에 +1
		int day = now.get(Calendar.DAY_OF_MONTH);
		int week = now.get(Calendar.DAY_OF_WEEK); // 1:일, 2:월, 3:화, 4:수...7::토
		int hour24 = now.get(Calendar.HOUR_OF_DAY); // 24시간 단위
		int hour = now.get(Calendar.HOUR); // 12시간 단위
		int ampm = now.get(Calendar.AM_PM); // 0:오전, 1:오후
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		System.out.printf("%d년 %d월 %d일 ", year, month, day);
		switch (week) {
		case 1: System.out.print("일요일"); break;
		case 2: System.out.print("월요일"); break;
		case 3: System.out.print("화요일"); break;
		case 4: System.out.print("수요일"); break;
		case 5: System.out.print("목요일"); break;
		case 6: System.out.print("금요일"); break;
		case 7: System.out.print("토요일"); break;	
		}
		System.out.printf("%d시(%s %d시) %d분 %d초\n", hour24, ampm==0? "오전":"오후", hour, minute, second);
		//%d정수,  %f실수, %s문자열,  %c문자, %b boolean,...
		//%tY(년도), %tm(월), %td(일), %ta(요일), %th(24시), %tp(오전/오후), %tl(12시) %tM(분) %tS(초)
		System.out.printf("%tY년 %tm월 %td일 %ta요일 %tH시(%tp %tl시) %tM분 %tS초", now, now, now, now, now, now, now, now, now);
		
		System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$ta요일 %1$tH시(%1$tp %1$tl시) %1$tM분 %1$tS초", now);
	}
}
