package com.lec.ex0_jannmuri;
//자바 파일에  public class 한개씩 꼭 구현
public class PersonTestMain {
	public static void main(String[] args) {
		PersonInfo person1 = new PersonInfo("홍길동", 22, 'm');
		person1.print();		
	}
}
class PersonInfo{
	private String name;
	private int	   age;
	private char   gender;
	public PersonInfo(String name, int age, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public void print() {
		System.out.println("이름 :" + name + ", 나이 : " + age +",성별 : " + gender );
	}
}