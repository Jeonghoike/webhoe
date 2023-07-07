package com.lec.ex;
// 논리연산자 : &&(AND), ||(OR), |
public class Ex04 {
	public static void main(String[] args) {
		int i=1, j=10, h=10;
		System.out.println("&&(AND) : (i<j) && (++j>h) 는" +((i<j) && (++j>h)));
		System.out.println("j -" + j);
		// && 연산자의 경우 좌항이 false경우 우항의 값은 보지도 않고 결과를 false로
		System.out.println("&&(AND) : (i>j) && (++j>h) 는" +((i>j) && (++j>h)));
		System.out.println("j -" + j);
		// ||연산자의 경우 좌항이 true이면 우항은 값을 보지도않고 결과를 true로
		System.out.println("||(OR) : (i<j) || (++j>h) 는" +((i<j) || (++j>h)));
		System.out.println("j -" + j);
		System.out.println("||(OR) : (i>j) || (++j>h) 는" +((i>j) || (++j>h)));
		System.out.println("j -" + j);
	}

}
