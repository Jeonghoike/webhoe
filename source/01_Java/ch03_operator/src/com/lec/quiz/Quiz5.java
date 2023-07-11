package com.lec.quiz;

import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 수를 입력하세요 : ");
		int kor =sc.nextInt();
		System.out.print("두번째 수를 입력하세요 : ");
		int eng =sc.nextInt();
		System.out.print("세번째 수를 입력하세요 : ");
		int mat =sc.nextInt();
		int sum = kor + eng + mat;
		double avg = sum/3.;
		System.out.printf("국어 = %d, 영어 = %d, 수학 = %d\n", kor, eng, mat);
		System.out.printf("총점 = %d, 평균 = %.2f\n", sum, avg);
		sc.close();
	}

}
