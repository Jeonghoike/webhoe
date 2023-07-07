package com.lec.ex09_store;
// 증권가 매장3호점 김치찌개-9,000 부대찌개-10,000 비빔밥-10,000 얼큰순대국-9,00
public class StoreNum3 extends HeadQuaterStore {
	public StoreNum3(String storeName) {
		super(storeName);
	}
	@Override
	public void kimchi() {
		System.out.println("김치찌개-9,000원");
	}
	@Override
	public void bude() {
		System.out.println("부대찌개-10,000");
	}
	@Override
	public void bibim() {
		System.out.println("비빔밥-10,000원");
	}
	@Override
	public void sunde() {
		System.out.println("얼큰순대국-9,000");
	}
}
