package com.lec.ex01;
// InterfaceEx1 : CONSTANT_NUM, method1() 
// InterfaceEx2 : CONSTANT_STRING, method2()
public class TestMain {
	public static void main(String[] args) {
//		InterfaceEx1 ex1 = new InterfaceEx1(); 추상클래스와 인터페이스는 객체 생성 불가. 오직 타입으로만가능
		ClassEx obj = new ClassEx();
		obj.method1();
		obj.method2();
		InterfaceEx1 obj1 = new ClassEx();
		obj1.method1();
		//obj1.method2();
		InterfaceEx2 obj2 = new ClassEx();
		obj2.method2();
		//obj2.method1();
		System.out.println("CONSTANT_NUM :" + InterfaceEx1.CONSTANT_NUM);
		System.out.println("CONSTANT_NUM :" + ClassEx.CONSTANT_NUM);
		System.out.println("CONSTANT_NUM :" + obj.CONSTANT_NUM);// static은 class로 접근 추천
		System.out.println("CONSTANT_STRING :" + InterfaceEx2.CONSTANT_STRING);
		System.out.println("CONSTANT_STRING :" + ClassEx.CONSTANT_STRING);
	}
}
