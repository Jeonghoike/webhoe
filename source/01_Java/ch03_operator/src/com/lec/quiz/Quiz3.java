package com.lec.quiz;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 수를 입력하세요 : ");
		int su =sc.nextInt();
		System.out.print("두번째 수를 입력하세요 : ");
		int su2 =sc.nextInt();
		System.out.println("두수가 같은지 결과는"  + ((su==su2)?"O":"X"));
		System.out.printf("첫번째 수가 더 큰지  "+((su>su2)?"O":"X"));
		sc.close();
		
	}

}
