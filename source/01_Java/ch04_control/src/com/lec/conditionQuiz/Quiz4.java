package com.lec.conditionQuiz;
// ���������� ����
//��ǻ�Ϳ� ���������� ������ �ϴ� ���α׷��� �����Ͻÿ�. 
//��, ����ڴ� ������ ������ �� ���� 0�� �Է��ϰ� ������ �����ϰ��� �� ���� 1�� �Է��ϰ�, ���� �����ϰ��� �� ���� 2�� �Է��Ͽ� ������ �����մϴ�
import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("����(0), ����(1), ���ڱ�(2) �� ���� �ϳ��� �����ϼ���");
		int you = scanner.nextInt(); // 0,1,2
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
