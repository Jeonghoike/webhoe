package com.lec.condition;

import java.util.Scanner;

// 사용자부터 받은 정수가 홀수인지 짝수인지 출력 (삼항연산자, if, switch) - switch
public class Ex05_ {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int su = scanner.nextInt();
		switch(su%2) {
		case 0: 
			System.out.println("짝수"); break;
		default:
			System.out.println("홀수"); break;
			
		}
		scanner.close();
	}

}
