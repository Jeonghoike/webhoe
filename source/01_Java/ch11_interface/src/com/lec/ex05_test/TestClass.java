package com.lec.ex05_test;
// i1, m1(추상), i2, m2(추상), i3, m3(추상)
public class TestClass implements I3 {	
	@Override
	public void m1() {
		System.out.println("상수i1 = " + i1);
	}
	@Override
	public void m2() {
		System.out.println("상수i2 = " + i2);
	}
	@Override
	public void m3() {
		System.out.println("상수 i3 = " + i3);
	}

}
