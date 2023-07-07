package com.lec.ex01_parentChild;

public class ChildTestMain {
	public static void main(String[] args) {
		ChildClass child = new ChildClass();
		System.out.println(child.cstr);
		System.out.println(child.pstr);
		child.getPapaName();
		child.getMamiName();
		
	}
}
