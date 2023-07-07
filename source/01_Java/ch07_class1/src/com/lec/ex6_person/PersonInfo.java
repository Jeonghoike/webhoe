package com.lec.ex6_person;
//new PersonInfo("홍길동", 22, 'm')
public class PersonInfo {
	private String name;
	private int age;
	private char gender; // 'm'또는 'f'
	public PersonInfo() { } // 디폴트 생성자 함수
	public PersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public void print() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("성별 : " + gender); // 성별 : m
		String str = (gender=='m')? "남" : (gender=='f' ? "여":"-");
		System.out.println("성별 : " + str); // 성별 : 남
	}
	public String infoPrint() {
		String str = (gender=='m')? "남" : (gender=='f' ? "여":"-");
		//String result = "이름 : " + name + "\n나이 : " + age + "\n성별 : " + str;
		String result = "이름 : " + name;
		result += "\n나이 :" + age; // result = result + "\n나이 : " + age;
		result += "\n성별 : " + str;
		return result;
	}
}
