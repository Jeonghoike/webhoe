package com.lec.quiz;
import java.util.Scanner;
public class Quiz2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է��ϼ��� : ");
		int su = sc.nextInt();
		String result = (su%2==0) ? " ¦���Դϴ�" : "Ȧ�� �Դϴ�";
		System.out.println("�Է��Ͻ� ��(" + su+")��" +result);
		System.out.printf("�Է��Ͻ� ��(%d)�� %s", su, result);
		sc.close();
	}

}
