package com.lec.quiz;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("ȫ�浿", "010-9999-1234", "���� ���빮��"));
		friends.add(new Friend("�ű浿", "010-8888-1234", "���� ������", new Date(new GregorianCalendar(1998,05,14).getTimeInMillis())));
		friends.add(new Friend("���缮", "010-7777-7777", "���� �����", new Date(new GregorianCalendar(1998,11,24).getTimeInMillis())));
		friends.add(new Friend("�ڸ��", "010-6666-6666", "��õ ����Ȧ��", new Date(new GregorianCalendar(1998,05,12).getTimeInMillis())));
		friends.add(new Friend("��ȣ��", "010-5555-5555", "���� ���ʽ�", new Date(new GregorianCalendar(1998,04,12).getTimeInMillis())));
		Scanner scanner = new Scanner(System.in);
		while(true) {
			boolean searchOk = false;
			System.out.print("�˻��� �ּ�2�ڸ�(��, ���Ḧ ���Ͻø� x�� �Է��Ͻÿ�) : ");
			String searchWord = scanner.next();
			if(searchWord.equalsIgnoreCase("x")) break;
			for(Friend friend : friends) {
				String address = friend.getAddress();
				int idx = address.indexOf(" ");
				String temp = address.substring(0, idx);
				if(searchWord.equals(temp)) {
					System.out.println(friend);
					searchOk = true;
				}
			}
			if(!searchOk) {
				System.out.println("�ش� ������ ģ���� �����ϴ�.");
			}
		}
	}
}
