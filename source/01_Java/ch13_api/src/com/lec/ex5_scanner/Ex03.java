package com.lec.ex5_scanner;

import java.util.Scanner;

// 이름(톰 크루즈|홍길동) -> 주소 -> 나이
public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름?");
		String name = sc.nextLine();
		System.out.print("주소?");
		String address = sc.nextLine();
		System.out.print("나이");
		int age = sc.nextInt();
		System.out.println(age + "살" + name + "님" + address + "거주");
	}
}
