package com.lec.ex09_store;
// ���а� ���� 2ȣ��
public class StoreNum2 extends HeadQuaterStore {
	public StoreNum2(String storeName) {
		super(storeName);
	}
	@Override
	public void bude() {
		System.out.println("����� -8,000��");
	}
	@Override
	public void bibim() {
		System.out.println("�����-8,000��");
	}
	@Override
	public void gonggibab() {
		System.out.println("����� : ����");
	}
}
