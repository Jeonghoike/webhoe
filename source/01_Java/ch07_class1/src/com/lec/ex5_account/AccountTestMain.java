package com.lec.ex5_account;

public class AccountTestMain {
	public static void main(String[] args) {
		Account hong = new Account("011-1234", "홍길동", 10000);
		//System.out.println(hong);
		System.out.println(hong.infoString());
		Account hong1 = new Account("012-9875", "홍길자");
		hong.infoPrint();
		hong.withdraw(5000);
		hong1.withdraw(10);// 잔액이 부족하면 인출 불가
		hong1.deposite(100000);
	}
}
