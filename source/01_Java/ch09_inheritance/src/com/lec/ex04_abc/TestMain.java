package com.lec.ex04_abc;

public class TestMain {
	public static void main(String[] args) {
		S sObj = new S(); // S생성자 함수
		//A aObj = new A();
		S aObj = new A(); // 생성자함수 2개 실행(부모단, 자식단)
		//B bObj = new B();
		S bObj = new B(); // 생성자함수 2개 실행(부모단, 자식단)
		C cObj = new C(); // 생성자함수 2개 실행(부모단, 자식단)
		//S[] arr = {new C(), new A(), new B(), newC()}
		S[] arr = {sObj, aObj, bObj, cObj};
		for(int idx=0 ; idx<arr.length ; idx++) {
			System.out.println(idx+"번째:" +arr[idx].s);
		}
		for(S a : arr) {
			System.out.println("s=" + a.s);
		}
	}
}
