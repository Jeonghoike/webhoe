package com.lec.ex1_tryCatch;

public class Ex03_finally {
	public static void main(String[] args) {
		int[] arr = {0,1,2};
		for(int idx = 0 ; idx<=arr.length ; idx++) {
			try {
		System.out.println("arr[" + idx + "]=" + arr[idx]);
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("예외 메세지 : " + e.getMessage());
			}finally {
				System.out.println("try절 실행후에도, catch절 실행후에도 실행되는 절");
			} // try
			System.out.println("---------------------------------");
		} // for 
	} // main
} // class 
