package com.lec.ex1_list;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Ex04_FriendsTodayBirth {
	public static void main(String[] args) {
		ArrayList<Friend> friends =new ArrayList<Friend>();
		friends.add(new Friend("ȫ�浿", "010-9999-9999"));
		friends.add(new Friend("��浿", "010-8888-8888", new Date(98,6,14)));
		friends.add(new Friend("���浿", "010-7777-7777", new Date(98,6,14)));
		friends.add(new Friend("�ڱ浿", "010-6666-6666", new Date(98,5,14)));
		friends.add(new Friend("���浿", "010-5555-5555", new Date(98,11,4)));
		// ������ ������ ģ���� ���
		System.out.print("������ ������ ģ����");
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd"); // ���� ������ ģ��
		String nowStr = sdf.format(now); // "07-14"
		boolean searchOk = false;
		for(Friend friend : friends) {
			Date birth = friend.getBirth();
			if(birth!=null && sdf.format(birth).equals(nowStr)) {
				System.out.print("\n" + friend);
				searchOk = true; // ������ ģ�� ã�Ҵ�
//				if(birth!=null) {
//					String birthStr = sdf.format(birth);
//					if(birthStr.equals(nowStr)) {
//						System.out.print("\n" + friend);
//						searchOk = true; // ������ ģ�� ã�Ҵ�
//					}//if	
//				}
			}//if
		}//for
		if(!searchOk) {
			System.out.println("�����ϴ�");
		}
	}
}