package com.lec.ex;
// return이 없는 method, 매개변수가 없는 method
public class Ex04_voidMethod {
	public static void main(String[] args) {
		printLine();
		System.out.println("Hello, Java");
		printLine('~');
		System.out.println("Hello, Oracle DB");
		printLine(15);
		System.out.println("Hello, World");
		Ex04_voidMethod ex = new Ex04_voidMethod();
		ex.printLine(21, '#');
	}//main
	private void printLine(int cnt, char c) {
		for(int i=0; i<cnt ; i++) {
			System.out.print(c);
		}
		System.out.println();
		
	}
	private static void printLine(int cnt) {
		for(int i=0; i<cnt ; i++) {
			System.out.print('-');
		}
		System.out.println();
		
	}
	private static void printLine(char c) {
		for(int i=0; i<20 ; i++) {
			System.out.print(c);
		}//for
		System.out.println();
	}
	private static void printLine() {
		for(int i=0; i<20 ; i++) {
			System.out.print('-');
		}
		System.out.println();//기본 라인 그리고 개행
	}
	
}
