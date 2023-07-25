package com.lec.ex4_newException;

public class AccountTestMain {
	public static void main(String[] args) {
		Account hong = new Account("011-1234", "홍길동", 10000);
		//System.out.println(hong);
		System.out.println(hong);
		Account hong1 = new Account("012-9875", "홍길자");
		System.out.println(hong);
		try {
			hong.withdraw(5000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			hong1.withdraw(10);
		} catch (Exception e) {
			System.out.println("예외 메세지>>> " + e.getMessage());;
		}// 잔액이 부족하면 인출 불가
		hong1.deposite(100000);
	}
}
