package com.lec.loop;
// 1~10까지 누적합은 55입니다
// 1+2+3+4+5+6+7+8+9+10=55
public class Ex02for {
	public static void main(String[] args) {
		int tot = 0; // 누적합을 위한 변수
		for(int i=1 ; i<=10 ; i++) {
			tot += i; // tot = tot + i;
			System.out.print(i );
			if(i!=10) {
				System.out.print("+");
			}
		}
		System.out.println("="+ tot);
	}

}
