package com.lec.ex07_super;

public class TestMain {
	public static void main(String[] args) {
		Person papa = new Person();
		papa.setName("¾Æºü°õ"); papa.setCharacter("¶×¶×ÇØ");
		papa.intro();
		Person mom = new Person("¾ö¸¶°õ","³¯¾ÀÇØ");
		mom.intro();
		System.out.println("----------");
		Person child1 = new Baby();
		child1.setName("¾Æ±â°õ1"); child1.setCharacter("±Í¿©¿ö");
		child1.intro();
		System.out.println("--------");
		Person child2 = new Baby("¾Æ±â°õ2", "³Ê¹« ±Í¿©¿ö");
		child2.intro();
		
	}
}
