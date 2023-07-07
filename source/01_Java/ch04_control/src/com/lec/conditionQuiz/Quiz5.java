package com.lec.conditionQuiz;

import java.util.Scanner;

//현재 몇월인지를 키보드로부터 입력받아 계절을 출력하는 프로그램을 구현하세
public class Quiz5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("사계절 중 : ");
		int month = scanner.nextInt();
		if(month==12 || month== 1 || month==2) {
			System.out.println("겨울입니다");
		}else if(month==3 || month==4|| month==5) {
			System.out.println("봄입니다.");
			
		}else if(month==6 || month==7 ||month==8) {
			System.out.println("여름을입니다.");
		}else if(month==9 || month==10 ||month==11) {
			System.out.println("가을입니다.");
		}else {
			System.out.println("유효한 개월 수가 아닙니다");
		}
	}

}
