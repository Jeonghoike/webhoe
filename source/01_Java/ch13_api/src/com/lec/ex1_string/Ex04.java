package com.lec.ex1_string;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("주민번호를 입력하세요");
		String juminNo = scanner.next();
		char genderChar = juminNo.charAt(7);
		if(genderChar=='1' || genderChar=='3') {		
			System.out.println("남자");
		}else if(genderChar=='2' || genderChar=='4'){
			System.out.println("여자");
		}else {
			System.out.println("유효하지않은주민번호입니다");
		}
		// 방법 3
//		int genderInt = Integer.parseInt(genderStr);
//		if(genderInt==1 || genderInt==3) {
//			System.out.println("남성이시군요");
//		}else if(genderInt==2 || genderInt==4)
	}
}
