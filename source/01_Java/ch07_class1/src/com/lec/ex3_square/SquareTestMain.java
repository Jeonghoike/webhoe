package com.lec.ex3_square;

public class SquareTestMain {
	public static void main(String[] args) {
		Square s1 = new Square();
		System.out.println("s1의 한변 길이 :" + s1.getSide());
		Square s2 = new Square(2);
		System.out.println("s2의 한변 길이 :" + s2.getSide());
		System.out.println("s1의 넓이는 " + s1.area());
		s2.setSide(10);
		System.out.println("수정된 s2의 넓이는 " + s2.area());
	}
}
