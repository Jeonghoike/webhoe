package com.lec.ex07_super;

public class TestMain {
	public static void main(String[] args) {
		Person papa = new Person();
		papa.setName("�ƺ���"); papa.setCharacter("�׶���");
		papa.intro();
		Person mom = new Person("������","������");
		mom.intro();
		System.out.println("----------");
		Person child1 = new Baby();
		child1.setName("�Ʊ��1"); child1.setCharacter("�Ϳ���");
		child1.intro();
		System.out.println("--------");
		Person child2 = new Baby("�Ʊ��2", "�ʹ� �Ϳ���");
		child2.intro();
		
	}
}
