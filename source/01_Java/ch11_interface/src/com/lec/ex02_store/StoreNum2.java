package com.lec.ex02_store;
// ���а� ���� 2ȣ��
public class StoreNum2 implements HeadQuaterStore {
	private String storeName;
	public StoreNum2(String storeName) {
		this.storeName = storeName;
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
	@Override
	public void kimchi() {
		System.out.println("��ġ�-8,000��");
		
	}
	@Override
	public void sunde() {
		System.out.println("���뱹-8,000");
		
	}
	@Override
	public String getStoreName() {
		return storeName;
	}
	
}
