package com.lec.loop;
// break : 반복문 블럭을 빠져 나감
public class Ex05_break_continue {
	public static void main(String[] args) {
		for(int i=1 ; i<=10 ; i++) {
			if(i==3) 
				//break; // 반복문 빠져나감
				continue; // 증감식->조건식으로 감
			System.out.println(i);
		}
	}

}
