package com.lec.ex09_store;
//������ħ : ��ġ�-8,000 �δ��-9,000 �����-9,000 ���뱹-8,000 �����-1,000��
// HeadQuaterStore headStore = new  HeadQuaterStore("=����=")
public class HeadQuaterStore {
	private String storeName;
	public HeadQuaterStore(String storeName) {
		this.storeName = storeName;
	}
	public void kimchi() {
		System.out.println("��ġ�-8,000");
	}
	public void bude() {
		System.out.println("�δ��-9,000��");
	}
	public void bibim() {
		System.out.println("�����-9,000��");
	}
	public void sunde() {
		System.out.println("���뱹-8,000��");
	}
	public void gonggibab() {
		System.out.println("�����-1,000��");
	}
	public String getStoreName() {
		return storeName;
	}
}
