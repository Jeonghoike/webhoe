package com.lec.ex5_scanner;

import java.util.Scanner;

// ���� - �̸� - �ּ�
public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("����?");
		int age = scanner.nextInt();
		System.out.println("�Է��� ���̴�" + age);
		System.out.print("�̸�(�� ũ���� | ȫ�浿)? ");
		scanner.nextLine();// ���ۿ� �����ִ� \n�� ����� �뵵
		String name = scanner.nextLine().trim(); // "�� ũ����"�� �ȵ�   �����ϸ� �踸 ��µ�  // white-space(space, tap, \n)�ձ��� ������. �Ǿտ� �ִ� \n�� ����
		System.out.println("�Է��� �̸���" + name);
		System.out.print("�ּ�?");
		String address = scanner.nextLine(); // \n�ձ��� �������� \n����
		System.out.println("�Է��� �ּҴ�" + address);
		System.out.println("��");
	}
}