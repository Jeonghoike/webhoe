package com.lec.quiz;
import java.util.Scanner;
// 사용자로부터 수를 입력받아 입력받은 수가 3의 배수인지 여부를 출력
public class Quiz1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요: ");
		int su = sc.nextInt(); // 키보드로부터 입력받은 정수를 su에 할당
		String result = (su%3==0) ? "3의 배수입니다" : "3의 배수가 아닙니다";
		System.out.println("입력하신 수(" + su+")는" +result);
		System.out.printf("입력하신 수(%d)는 %s", su, result);
		sc.close();
	}

}
