package com.lec.ex01;
// CONSTANT_NUM, method1(추상) / CONSTANT_STRING, method2(추상)
public class ClassEx implements InterfaceEx1, InterfaceEx2{
	
	@Override
	public void method2() {
		System.out.println("실제 구현은 implements한 클래스에서 함 - method2");
	}

	@Override
	public void method1() {
		System.out.println("실제 구현은 implements한 클래스에서 함 - method1");
	}

}
