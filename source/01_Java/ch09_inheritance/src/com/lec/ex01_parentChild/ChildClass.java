package com.lec.ex01_parentChild;
// pstr, getPapaName(), getMamiName()
public class ChildClass extends ParentClass{
	public String cstr = "자식클래스";
	public ChildClass() {
		System.out.println("자식 클래스 생성자 함수");
	}
}
