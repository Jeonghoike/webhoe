package com.lec.ex01_store;
// 대학가 매장 2호점
public class StoreNum2 extends HeadQuaterStore {
	public StoreNum2(String storeName) {
		super(storeName);
	}
	@Override
	public void bude() {
		System.out.println("부재찌개 -8,000원");
	}
	@Override
	public void bibim() {
		System.out.println("비빔밥-8,000원");
	}
	@Override
	public void gonggibab() {
		System.out.println("공기밥 : 무료");
	}
	@Override
	public void kimchi() {
		System.out.println("김치찌개-8,000원");
		
	}
	@Override
	public void sunde() {
		System.out.println("순대국-8,000");
		
	}
}
