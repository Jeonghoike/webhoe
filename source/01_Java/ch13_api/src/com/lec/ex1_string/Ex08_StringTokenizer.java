package com.lec.ex1_string;

import java.util.StringTokenizer;

public class Ex08_StringTokenizer {
	public static void main(String[] args) {
		String str1 = "�ں��� ���� ���� ���ҿ� �嵿��"; // ������ : space "  "
		String str2 = "100, 99, 85, 73"; // ������ : ", "
		StringTokenizer token1 = new StringTokenizer(str1); // �����ڰ� "  "
		StringTokenizer token2 = new StringTokenizer(str2, ", "); // �����ڰ� ", "
		while(token1.hasMoreTokens()) {
			System.out.println(token1.nextToken());
		}
		while(token2.hasMoreElements()) {
			System.out.println(token2.nextToken());
		}
	}//main
}