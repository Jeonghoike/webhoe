package com.lec.ex11_account;
// accountNo, ownerName, balance, deposit(), withdraw(), infoPrint(), 
// CheckingAccount ca1 = new CheckingAccount("111", "홍",[1000,] "1234123412341324");
public class CheckingAccount extends Account{
	private String cardNo;
	public CheckingAccount(String accountNo, String ownerName,  String carNo) {
		super(accountNo, ownerName);
		this.cardNo = cardNo;

	}
	public CheckingAccount(String accountNo, String ownerName, int balance, String carNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;

	}
	// ca1.pay("1234123413241234", 10000)
	public void pay(String cardNo, int amount) {
		if(cardNo.equals(this.cardNo)) {// 올바른 카드번호인 경우
			if(getBalance() >=amount) { // 지불가능
				//balance = balance - amount
				setBalance(getBalance() - amount); // 잔액을 amount만큼 차감
				System.out.printf("%s님 %d원 지불하여 %s 계좌에 잔액 %d입니다\n", getOwnerName(),amount, getAccountNo(), getBalance());
			}else { //잔액부족으로 지불 불가
				System.out.println(getOwnerName()+"님 잔액부족으로 지불 불가합니다");
			}
		}else {
			System.out.println("유효한 카드번호가 아닙니다");
		}
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
}
