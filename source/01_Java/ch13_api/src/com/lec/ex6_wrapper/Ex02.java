package com.lec.ex6_wrapper;
// 문자열("100") -> 정수(100) Integer.parseInt(문자열)
// wjdtn(100 -> 문자열("100") String.valueOf(정수)
public class Ex02 {
	public static void main(String[] args) {
		System.out.println("스트링을 정수로 전환");
		int i = Integer.parseInt("100");
		System.out.println("i =" + i);
		String monthStr = String.valueOf(12); // "12"
		monthStr = "" + 12; // "12"
	}
}
