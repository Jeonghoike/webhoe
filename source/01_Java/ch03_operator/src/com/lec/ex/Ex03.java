package com.lec.ex;
//동등비교(관계)연산자 : ==(같다), !=(다르다), >, >-, <, <-
public class Ex03 {
	public static void main(String[] args) {
		int n1=10, n2=5;
		boolean result = (n1 == n2);
		System.out.printf("%d %s %d = %b\n", n1, "==", n2, result);
		result = (n1 != n2);
		System.out.printf("%d %s %d = %b\n", n1, "!=", n2, result);
		result = (n1 >= n2);
		System.out.printf("%d %s %d = %b\n", n1, ">=", n2, result);
		
		result = !(n1 != n2); // !(논리연산 ; 반대를 의미)
		System.out.printf("%d %s %d의 반대는 %b\n", n1, "!=", n2, result);
	}

}
