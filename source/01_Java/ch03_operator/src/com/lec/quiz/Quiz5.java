package com.lec.quiz;

import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���� �Է��ϼ��� : ");
		int kor =sc.nextInt();
		System.out.print("�ι�° ���� �Է��ϼ��� : ");
		int eng =sc.nextInt();
		System.out.print("����° ���� �Է��ϼ��� : ");
		int mat =sc.nextInt();
		int sum = kor + eng + mat;
		double avg = sum/3.;
		System.out.printf("���� = %d, ���� = %d, ���� = %d\n", kor, eng, mat);
		System.out.printf("���� = %d, ��� = %.2f\n", sum, avg);
		sc.close();
	}

}
