package com.lec.ex01_store;
// �߻�Ŭ���� : �߻�޼ҵ尡 1�� �̻� ���� ��
//�߻�޼ҵ� : �޼ҵ� �����ϰ� ������ ����. ���� ��ӹ��� Ŭ������ ��(��ӹ��� Ŭ�������� �������̵� ����)
public abstract class HeadQuaterStore {
	private String storeName;
	public HeadQuaterStore(String storeName) {
		this.storeName = storeName;
	}
	public abstract void kimchi(); 
	public abstract void bude();
	public abstract void bibim(); 
	public abstract void sunde();
	public abstract void gonggibab();
	public String getStoreName() {
		return storeName;
	}
}
