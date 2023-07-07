package com.lec.ex3_product;

public class ProductTestMain {
	public static void main(String[] args) {
		System.out.println("static  : " + Product.count);
		Product.staticMethod();
		Product p1 = new Product();
		p1.infoprint();
		Product p2 = new Product();
		System.out.println("static  : " + Product.count);
		p2.infoprint();
		Product p3 = new Product();
		System.out.println("static   : " + Product.count);
		System.out.println("static  : " + p1.count);
		System.out.println("static  : " + p2.count);
	}

}
