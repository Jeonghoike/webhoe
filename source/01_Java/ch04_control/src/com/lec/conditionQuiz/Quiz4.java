package com.lec.conditionQuiz;
// 가위바위보 게임
//컴퓨터와 가위바위보 게임을 하는 프로그램을 구현하시오. 
//단, 사용자는 가위를 내고자 할 때는 0을 입력하고 바위를 선택하고자 할 때는 1을 입력하고, 보를 선택하고자 할 때는 2를 입력하여 게임을 진행합니다
import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("가위(0), 바위(1), 보자기(2) 중 숫자 하나를 선택하세요");
		int you = scanner.nextInt(); // 0,1,2
		int computer = (int) (Math.random()*3); // 0,1,2중 한 난수
		System.out.println(computer);
		if(you==0) {
			System.out.println("가위");
		}else if(you==1 ) {
			System.out.println("바위");
		}else if(you==2) {
			System.out.println("보자기");
		}else {
			System.out.println("잘못 하심");
		}
		if(you>computer) {
			System.out.println("당신이 이겼습니다");
		}else if(you<computer) {
			System.out.println("컴퓨터가 이겼습니다");
		}else if(you==computer) {
			System.out.println("비겼습니다");
		
		}
		}
}
