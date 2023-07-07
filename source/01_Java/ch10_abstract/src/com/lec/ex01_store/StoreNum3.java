package com.lec.ex01_store;
// Áõ±Ç°¡ ¸ÅÀå3È£Á¡ ±èÄ¡Âî°³-9,000 ºÎ´ëÂî°³-10,000 ºñºö¹ä-10,000 ¾óÅ«¼ø´ë±¹-9,00
public class StoreNum3 extends HeadQuaterStore {
	public StoreNum3(String storeName) {
		super(storeName);
	}
	@Override
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³-9,000¿ø");
	}
	@Override
	public void bude() {
		System.out.println("ºÎ´ëÂî°³-10,000");
	}
	@Override
	public void bibim() {
		System.out.println("ºñºö¹ä-10,000¿ø");
	}
	@Override
	public void sunde() {
		System.out.println("¾óÅ«¼ø´ë±¹-9,000");
	}
	@Override
	public void gonggibab() {
		System.out.println("°ø±â¹ä-1,000¿ø");		
	}
}
