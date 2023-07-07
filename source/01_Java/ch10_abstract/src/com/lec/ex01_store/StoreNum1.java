package com.lec.ex01_store;
// 주택가 1호점 : 부대찌개-8,000원, 순대국 -안팔아
// StoreNum1 store1 = new StoreNum1("주택가 1호점")
public class StoreNum1 extends HeadQuaterStore {
	public StoreNum1(String storeName) {
		super(storeName);
	}
	@Override
	public void kimchi() {
		System.out.println("김치찌개 - 8,000원");
	}
	@Override
	public void bude() {
		System.out.println("부대찌개-8,000원");
	}
	@Override
	public void sunde() {
		System.out.println("순대국-안팔아");
	}
	@Override
	public void bibim() {
		System.out.println("비빔밥-9,000원");
	}
	@Override
	public void gonggibab() {
		System.out.println("공기밥-1000원");
		
	}
		
}
