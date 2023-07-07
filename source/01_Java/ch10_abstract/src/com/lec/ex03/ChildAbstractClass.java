package com.lec.ex03;

import com.lec.ex02.SuperClass;
// method1(추상), method2, method3, method4(일반)
public abstract class ChildAbstractClass extends SuperClass{
	public void method4() {
		System.out.println("ChildAbstractClass의 method4");
	}
}
