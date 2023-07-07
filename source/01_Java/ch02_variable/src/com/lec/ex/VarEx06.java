package com.lec.ex;
// 기본데이터타입(기초데이터타입; 소문자시작) vs, 참조데이터타입(객체데이터타입; 대문자시작)
public class VarEx06 {
	public static void main(String[] args) {
		// 기본데이터타입
		int i; //4byte
		i = 10;
		// 참조데이터타입(객체데이터타입)
		String name;
		name = "KIM";
		System.out.println("name = " + name);
		name = "김수한무";
		System.out.println("name = " + name);
	}

}
