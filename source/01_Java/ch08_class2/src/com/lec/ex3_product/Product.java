package com.lec.ex3_product;
// 데이터: serialNo
// main에서 Product p1 = new Product();
public class Product {
	private int serialNo;
	public static int count = 100;
	public Product() {
		serialNo = ++count;
	}
	public static void staticMethod() {
		System.out.println("static 메소드");
	}
	public void infoprint() {
		System.out.println("시리얼번호 : " + serialNo + "\t공유변수 count : "+ count);
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

}
