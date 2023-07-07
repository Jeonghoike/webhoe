package com.lec.loop;
// 반복문(loop문)을 작성할때는 무한반복문에 들어가지 않도록 주의
public class Ex06_endless {
	public static void main(String[] args) {
		for(int i=0 ;  ; i++) {
			System.out.println(i + ", 안녕");
		}// 무한반복 for문
		// System.out.println("실행이 안 되는 부분이라 에러남");
	}

}
