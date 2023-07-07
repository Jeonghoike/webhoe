package com.lec.ex02;

public class TestMain {
	public static void main(String[] args) {
		SuperClass obj = new ChildClass(); // 추상클래스(SuperClass)는 타입으로만 가능. 객체 생성은 불가
		obj.method1();
		obj.method2();
		obj.method3();
		//obj.method4(); // obj의 타입이 SuperClass타입이라서 컴파일 에러
		if(obj instanceof ChildClass) {
			((ChildClass)obj).method4();
		}
	}
}
