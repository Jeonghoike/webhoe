package com.lec.ex4_momchild;

public class ChildTestMain {
	public static void main(String[] args) {
		Child child1 = new Child("ù° �ʸ���");
		Child child2 = new Child("��° �ʼ���");
		Child child3 = new Child("��° ����");
		System.out.println("ù° ���� ���� :" + child1.momPouch.money);
		System.out.println("��° ���� ���� :" + child2.momPouch.money);
		System.out.println("��° ���� ���� :" + child3.momPouch.money);
		child1.takeMoney(100);
		System.out.println("���� ���� :" + child1.momPouch.money);
		child2.takeMoney(100);
		System.out.println("���� ���� : " + child2.momPouch.money);
		child3.takeMoney(200);
		System.out.println("��° ���� ����" + child3.momPouch.money);
	}
}
