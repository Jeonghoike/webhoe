package com.lec.ex1_string;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�ֹι�ȣ�� �Է��ϼ���");
		String juminNo = scanner.next();
		char genderChar = juminNo.charAt(7);
		if(genderChar=='1' || genderChar=='3') {		
			System.out.println("����");
		}else if(genderChar=='2' || genderChar=='4'){
			System.out.println("����");
		}else {
			System.out.println("��ȿ���������ֹι�ȣ�Դϴ�");
		}
		// ��� 3
//		int genderInt = Integer.parseInt(genderStr);
//		if(genderInt==1 || genderInt==3) {
//			System.out.println("�����̽ñ���");
//		}else if(genderInt==2 || genderInt==4)
	}
}
