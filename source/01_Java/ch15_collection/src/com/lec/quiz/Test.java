package com.lec.quiz;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("홍길동", "010-9999-1234", "서울 서대문구"));
		friends.add(new Friend("신길동", "010-8888-1234", "서울 마포구", new Date(new GregorianCalendar(1998,05,14).getTimeInMillis())));
		friends.add(new Friend("유재석", "010-7777-7777", "전남 고흥시", new Date(new GregorianCalendar(1998,11,24).getTimeInMillis())));
		friends.add(new Friend("박명수", "010-6666-6666", "인천 미추홀구", new Date(new GregorianCalendar(1998,05,12).getTimeInMillis())));
		friends.add(new Friend("강호동", "010-5555-5555", "강원 속초시", new Date(new GregorianCalendar(1998,04,12).getTimeInMillis())));
		Scanner scanner = new Scanner(System.in);
		while(true) {
			boolean searchOk = false;
			System.out.print("검색할 주소2자리(단, 종료를 원하시면 x를 입력하시오) : ");
			String searchWord = scanner.next();
			if(searchWord.equalsIgnoreCase("x")) break;
			for(Friend friend : friends) {
				String address = friend.getAddress();
				int idx = address.indexOf(" ");
				String temp = address.substring(0, idx);
				if(searchWord.equals(temp)) {
					System.out.println(friend);
					searchOk = true;
				}
			}
			if(!searchOk) {
				System.out.println("해당 지역의 친구는 없습니다.");
			}
		}
	}
}
