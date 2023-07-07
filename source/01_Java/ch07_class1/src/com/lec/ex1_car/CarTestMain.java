package com.lec.ex1_car;

public class CarTestMain {
	public static void main(String[] args) {
		Car myPorche = new Car();
		myPorche.setColor("빨강"); //myPorche.color = "빨갈";
		myPorche.setCc(3000); //myporche.cc = 3000;
		System.out.println(myPorche.setColor() + "색 차 : "+ myPorche.getCc() + "cc, 속도 :" + myPorche.getSpeed());
//		System.out.println(myPorsche.color + "색 차 :" + myPorsche.cc + "cc, 속도 :" + myPorsche.speed);
		myPorche.drive();
		myPorche.park();
		myPorche.race();
		Car yourPorche = new Car();
		yourPorche.setColor("gray");
		yourPorche.drive();
	}
}
