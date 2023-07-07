package com.lec.loopQuiz;

import java.util.Scanner;

public class Homework2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("가위(0), 바위(1), 보자기(2) 중 숫자 하나를 선택하세요");
			int you = scanner.nextInt(); // 0,1,2
			if(you==-1) break;
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
				continue; // 조건식 부분으로 감
			}//if
			if(you>computer) {
				System.out.println("당신이 이겼습니다");
			}else if(you<computer) {
				System.out.println("컴퓨터가 이겼습니다");
				break;
			}else if(you==computer) {
				System.out.println("비겼습니다");
			}//if
		}while(true);
	}
}
