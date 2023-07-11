package com.lec.ex1_string;

import java.util.Scanner;

//전화번호 뒷자리가 중복 X
public class Ex07_searchTel {
	public static void main(String[] args) {
		String[] tels = {"010-9999-9999", "010-8888-8888", "010-7777-7777"};
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("검색할 전화번호 뒷자리 : ");
			String searchTel = scanner.next(); // "6666"
			if(searchTel.equalsIgnoreCase("x")) break;
			int i;
			for( i=0 ; i<tels.length ; i++) {
				int postIdx = tels[i].lastIndexOf("-");
				String postTel = tels[i].substring(postIdx+1);
				if(postTel.equals(searchTel)) {
					System.out.println("검색하신 전화번호는" + tels[i]);
					break;
				}
			}//for
			if(i==tels.length) {
				System.out.println("입력하신 전화번호 뒷자리는 저장되지 않았습니다");
			}
		}//while
	}
}
