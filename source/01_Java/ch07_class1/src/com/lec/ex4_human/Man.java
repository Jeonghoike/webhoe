package com.lec.ex4_human;
//Man kim = new Man("홍길동", 22, 180, 68.0); 생성자함수의 오버로딩
//Man kim = new Man();
//Man kim = new Man("홍길동");
//Man kim = new Man(180);
//Man kim = new Man(22); 불가
//Man kim = new Man(68.0);
public class Man {
	private String name;
	private int age;
	private int height;
	private double weight;
	// 개발자가 생성자 함수를 안 만들면 컴파일러는 디폴트 생성자 함수 자동 생성.
	// 개발자가 생성자 함수를 하나이상 만들면 컴파일러는 디폴트 생성자 함수를 안 만들어
	public Man() {
		System.out.println("매개변수 없는 Man 생성자 함수");
	}
	public Man(String name, int age, int height, double weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		System.out.println("데이터 4개 초기화하는 Man 생성자 함수");
	}
	public Man(String name) {
		this.name = name;
		System.out.println("이름을 초기화하는 Man 생성자 함수");
	}
	public Man(int height) {
		this.height = height;
		System.out.println("키를 초기화하는 Man 생성자 함수");
	}
	public Man(double weight) {
		this.weight = weight;
		System.out.println("몸무게를 초기화하는 Man 생성자 함수");
	}
	public double caculateBMI() {
		double result = weight / ((height*0.01) * (height*0.01));
		return result;
	}
	// setter & getter
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	public int getHeight() {return height;}
	public void setHeight(int height) {this.height = height;}
	public double getWeight() {return weight;}
	public void setWeight(double weight) {this.weight = weight;}
}
