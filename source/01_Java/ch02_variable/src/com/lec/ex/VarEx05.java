package com.lec.ex;
// 형변환 
public class VarEx05 {
	public static void main(String[] arge) {
		int i =10; // 4byte
		double d = i; // d = 10.0; 묵시적인 형변환 8byte
		System.out.println("d =" +d);
		i = (int)10.6; // 명시적인 형변환 - 데이터손실이 생길 수 있음
		System.out.println();
	}

}
