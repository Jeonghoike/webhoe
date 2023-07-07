package com.lec.ex04_abc;

public class S {
	protected int s;
	public S() {
		System.out.println("-----------------");
		System.out.println("매개변수 없는 부모단의 생성자 함수");
	}
	public S(int s) {
		System.out.println("매개변수 있는 부모단의 생성자 함수");
	}
}
