package com.lec.quiz;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���� �Է��ϼ��� : ");
		int su =sc.nextInt();
		System.out.print("�ι�° ���� �Է��ϼ��� : ");
		int su2 =sc.nextInt();
		System.out.println("�μ��� ������ �����"  + ((su==su2)?"O":"X"));
		System.out.printf("ù��° ���� �� ū��  "+((su>su2)?"O":"X"));
		sc.close();
		
	}

}
