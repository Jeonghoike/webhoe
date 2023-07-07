package com.lec.ex;

public class Quiz2 {
	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50};
		int tot = 0;
		for(int i=0 ; i<arr.length ; i++) {
			tot +=arr[i];
		}//for
		System.out.println("모든 합은"+tot);
	}
}
