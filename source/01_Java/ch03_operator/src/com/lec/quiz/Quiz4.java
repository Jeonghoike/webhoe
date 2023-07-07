package com.lec.quiz;
import java.util.Scanner;
public class Quiz4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("수를 입력하세요 : ");
		int su = sc.nextInt();
		String result = (su>=65) ? "경로우대 " : "일반";
		System.out.println("입력하신 수(" + su+")는" +result);
		System.out.printf("입력하신 수(%d)는 %s", su, result);
		sc.close();
	}

}
