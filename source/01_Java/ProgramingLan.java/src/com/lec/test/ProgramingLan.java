package com.lec.test;

public class ProgramingLan {
	public static void main(String[] args) {
		int[] arr = {76,45,34,89,100,50,90,92};
		for(int i=0 ; i<arr.length-1 ; i++) {
			for(int j=i+1 ; j<arr.length ; j++) {
				if(arr[i] > arr[j]) {				
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}//if
			}//for-j
			
		}//for-i
		for(int a : arr) {
			System.out.println(a);
			int tot = 0;
		for(int i=0 ; i<arr.length ; i++) {
			tot +=arr[i]; 
		}
		System.out.println("ÇÕ °è = "+ tot);
		System.out.printf("Æò  ±Õ: %.2f\n",(double)tot/arr.length);
		}//main
	}

}
