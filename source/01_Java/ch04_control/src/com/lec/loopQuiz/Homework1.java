package com.lec.loopQuiz;

import java.util.Scanner;

public class Homework1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
		System.out.print("����(0), ����(1), ���ڱ�(2) �� ���� �ϳ��� �����ϼ���");
		int you = scanner.nextInt(); // 0,1,2
		if(you==-1) break;
		int computer = (int) (Math.random()*3); // 0,1,2�� �� ����
		System.out.println(computer);
		if(you==0) {
			System.out.println("����");
		}else if(you==1 ) {
			System.out.println("����");
		}else if(you==2) {
			System.out.println("���ڱ�");
		}else {
			System.out.println("�߸� �Ͻ�");
			continue; // ���ǽ� �κ����� ��
		}
		if(you>computer) {
			System.out.println("����� �̰���ϴ�");
		}else if(you<computer) {
			System.out.println("��ǻ�Ͱ� �̰���ϴ�");
		}else if(you==computer) {
			System.out.println("�����ϴ�");
		}
		}	
	}

}
