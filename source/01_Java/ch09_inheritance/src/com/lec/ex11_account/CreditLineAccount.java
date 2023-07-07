package com.lec.ex11_account;
// accountNo, ownerName, balance, deposit(), withdraw(), infoPrint(), infoString(), pay()
public class CreditLineAccount extends CheckingAccount {
	private int creditLine; // ī���ѵ�
	public CreditLineAccount(String accountNo, String ownerName, String carNo, int creditLine) {
		super(accountNo, ownerName, carNo);
		this.creditLine = creditLine;
	}
	public CreditLineAccount(String accountNo, String ownerName, int balance, String carNo, int creditLine) {
		super(accountNo, ownerName, balance, carNo);
		this.creditLine = creditLine;
	}
	// ca1.pay("1234123413241234", 10000)
	@Override
		public void pay(String cardNo, int amount) {
			if(cardNo.equals(getCardNo())) {// �ùٸ� ī���ȣ�� ���
				if(creditLine >=amount) { // ���Ұ���
					creditLine -= amount;//creditLine = creditLine - amount; // �ܾ��� amount��ŭ ����
					System.out.printf("%s�� %d�� �����Ͽ� �ѵ� %�� ���ҽ��ϴ�\n", getOwnerName(),amount, creditLine);
				}else { //�ܾ׺������� ���� �Ұ�
					System.out.println(getOwnerName()+"�� �ѵ��������� ���� �Ұ��մϴ�");
				}
			}else {
				System.out.println("��ȿ�� ī���ȣ�� �ƴմϴ�");
			}
		}

}
