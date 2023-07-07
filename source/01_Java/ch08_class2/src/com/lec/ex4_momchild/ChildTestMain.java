package com.lec.ex4_momchild;

public class ChildTestMain {
	public static void main(String[] args) {
		Child child1 = new Child("첫째 똘만이");
		Child child2 = new Child("둘째 똘순이");
		Child child3 = new Child("셋째 똘이");
		System.out.println("첫째 엄마 지갑 :" + child1.momPouch.money);
		System.out.println("둘째 엄마 지갑 :" + child2.momPouch.money);
		System.out.println("셋째 엄마 지갑 :" + child3.momPouch.money);
		child1.takeMoney(100);
		System.out.println("엄마 지갑 :" + child1.momPouch.money);
		child2.takeMoney(100);
		System.out.println("엄마 지갑 : " + child2.momPouch.money);
		child3.takeMoney(200);
		System.out.println("셋째 엄마 지갑" + child3.momPouch.money);
	}
}
