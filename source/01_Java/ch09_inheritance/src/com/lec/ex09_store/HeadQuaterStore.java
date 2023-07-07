package com.lec.ex09_store;
//º»»çÁöÄ§ : ±èÄ¡Âî°³-8,000 ºÎ´ëÂî°³-9,000 ºñºö¹ä-9,000 ¼ø´ë±¹-8,000 °ø±â¹ä-1,000¿ø
// HeadQuaterStore headStore = new  HeadQuaterStore("=º»»ç=")
public class HeadQuaterStore {
	private String storeName;
	public HeadQuaterStore(String storeName) {
		this.storeName = storeName;
	}
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³-8,000");
	}
	public void bude() {
		System.out.println("ºÎ´ëÂî°³-9,000¿ø");
	}
	public void bibim() {
		System.out.println("ºñºö¹ä-9,000¿ø");
	}
	public void sunde() {
		System.out.println("¼ø´ë±¹-8,000¿ø");
	}
	public void gonggibab() {
		System.out.println("°ø±â¹ä-1,000¿ø");
	}
	public String getStoreName() {
		return storeName;
	}
}
