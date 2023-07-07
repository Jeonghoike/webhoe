package com.lec.condition;
// 점수 할당 후 점수에 따른 결과를 출력
public class Ex01_if {
	public static void main(String[] args) {
		int score = 65;
		if(score >= 90) {
			System.out.println("완벽합니다");
		}else if(score>=70){
			System.out.println("뭐 완벽 안 하네");
		}else if(score>=60) {
			System.out.println("분발하시던지");
		}else {
			System.out.println("재시험입니다");
		System.out.println("DONE");
		}
		
	}

}
