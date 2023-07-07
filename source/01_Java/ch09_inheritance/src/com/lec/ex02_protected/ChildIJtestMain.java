package com.lec.ex02_protected;

public class ChildIJtestMain {
	public static void main(String[] args) {
		ChildIJ child1 = new ChildIJ(); 
		child1.setI(1); child1.setJ(2);
		child1.sum();
		System.out.println("------------------");
		ChildIJ child2 = new ChildIJ(10, 20);
		child2.sum();
	}
}
