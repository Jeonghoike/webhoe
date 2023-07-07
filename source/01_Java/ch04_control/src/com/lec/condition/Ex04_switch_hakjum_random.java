package com.lec.condition;

// 랜덤점수(0~100)의 학점 출력
public class Ex04_switch_hakjum_random {
	public static void main(String[] args) {
		//0<= math.random() < 1 실수난수 발생
		//0<= math.random()*101< 101 실수 난수 발생
		//0<= (int)(math.random()*101) < 101 정수난수
		int score = (int)(Math.random() *101);
		System.out.println("점수 : "+ score);
		// 학점출력
		switch(score /10) {
		
		case 10: case 9:
			System.out.println("A"); break;
		case 8:
			System.out.println("B"); break;
		case 7:
			System.out.println("D"); break;
		case 6:
			System.out.println("C"); break;
		default:
			System.out.println("F"); break;
		
		}
	}

}
