package com.lec.ex1_string;

import java.util.Scanner;

public class Ex06_telLoop {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("전화번호(xxx-xxxx-xxxx형태로 입력하세요)?");
			String tel = scanner.next();
			if(tel.equalsIgnoreCase("x")) break;
			System.out.println("입력한 전화번호는" + tel);
			System.out.print("짝수번째 문자열 : ");
			for(int idx=0 ; idx<tel.length() ; idx++) {
				if(idx%2==0) {
					System.out.print(tel.charAt(idx));
				}else {
					System.out.print(' ');
				}
			} //for
			System.out.print("\n문자열 꺼꾸로 :");
			for(int idx=tel.length()-1 ; idx>=0 ; idx--) {
				System.out.print(tel.charAt(idx));
			}//for
			int preIdx = tel.indexOf("-");
			String preTel = tel.substring(0, preIdx);
			System.out.println("\n전화번호 맨앞자리 :" + preTel);
			int postIdx = tel.lastIndexOf("-");
			String postTel = tel.substring(postIdx + 1);
			System.out.println("\n전화번호 뒷자리 : " + postTel);
		}
		
	}
}
