package com.lec.loopQuiz;

public class Quiz1 {
	public static void main(String[] args) {
		int tot = 1; // 
		for(int i=1 ; i<=10 ; i++) {
			tot *= i; // tot = tot + i;
			System.out.print(i );
			if(i!=10) {
				System.out.print("*");
			}
		}
		System.out.println("=" + tot);
	}
}
