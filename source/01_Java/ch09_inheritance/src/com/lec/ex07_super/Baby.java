package com.lec.ex07_super;
// private(name, character) public(intro(), setter&getter)
// super() : 부모클래스의 생성자 함수
// this() : 현재 클래스의 생성자 함수
// super. : 부모클래스의
// this. : 내객체의
public class Baby extends Person{

	public Baby() {
		super(); // 부모클래스의 생성자함수 == Person()
		System.out.println("매개변수 없는 Baby 생성자");
	}
	public Baby(String name, String character) {
		super(name, character); // == Person(name, character). Person()수행 안함
//		setName(name);
//		setCharacter(character);
		System.out.println("매개변수 있는 Baby 생성자");
	}
	@Override
	public void intro() {
		System.out.print("☆응애 응애 이쁜아기");
		super.intro(); // 부모클래스의 intro()
	}
}
