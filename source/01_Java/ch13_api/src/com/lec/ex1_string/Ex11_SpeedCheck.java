package com.lec.ex1_string;

public class Ex11_SpeedCheck {
	public static void main(String[] args) {
		// System.currentTimeMillis() : 1970.1. 0시부터 현재까지의 밀리세컨
		// start
		long start = System.currentTimeMillis();
		String str = "a";
		for(int i=0 ; i<100000;  i++) {
			str += "a";
		}
		long end = System.currentTimeMillis();
		System.out.println("스트링 10만번 변경시간 :" + (end-start));
		start = System.currentTimeMillis(); //시작점
		StringBuffer strBuf = new StringBuffer("a");
		for(int i=0 ; i<100000 ; i++) {
			strBuf.append("a");
		}
		end = System.currentTimeMillis(); //끝나는 시점

		System.out.println("스트링 10만번 변경시간 :" + (end-start));
		start = System.currentTimeMillis(); //시작점
		StringBuilder strBuil = new StringBuilder("a");
		for(int i=0 ; i<100000 ; i++) {
			strBuil.append("a");
		}
		end = System.currentTimeMillis(); //끝나는 시점
		System.out.println("스트링빌더 10만번 변경시간 "+ (end-start));
	}
}
