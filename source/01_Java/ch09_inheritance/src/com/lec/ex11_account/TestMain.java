package com.lec.ex11_account;

public class TestMain {
	public static void main(String[] args) {
		Account acc1 = new Account("011-1", "È«±æµ¿");
		CheckingAccount acc2 = new CheckingAccount("011-2", "¹Ú", 10000, "1234");
		CreditLineAccount acc3 = new CreditLineAccount("011-3", "±è", 1000, "9876", 10000);
		acc1.deposite(10000);
		acc1.withdraw(9000);
		acc2.pay("1234", 11000);
		acc3.pay("9876", 11000);
	}
}
