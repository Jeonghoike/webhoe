package com.lec.methoed;

public class Ex03 {
	public static void main(String[] args) {
		System.out.println("-9의 절대값은: " +Arithmetic.abs(-9));
		Arithmetic ar = new Arithmetic();
		int tot = ar.sum(11,100);
		System.out.println("11부터 100까지 누적합은" + tot);
		System.out.println(ar.evenOdd(tot));
		tot = ar.sum(10);
		System.out.println("1에서10까지의 합은"+ tot);
	}
}
