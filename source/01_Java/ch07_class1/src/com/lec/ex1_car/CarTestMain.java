package com.lec.ex1_car;

public class CarTestMain {
	public static void main(String[] args) {
		Car myPorche = new Car();
		myPorche.setColor("����"); //myPorche.color = "����";
		myPorche.setCc(3000); //myporche.cc = 3000;
		System.out.println(myPorche.setColor() + "�� �� : "+ myPorche.getCc() + "cc, �ӵ� :" + myPorche.getSpeed());
//		System.out.println(myPorsche.color + "�� �� :" + myPorsche.cc + "cc, �ӵ� :" + myPorsche.speed);
		myPorche.drive();
		myPorche.park();
		myPorche.race();
		Car yourPorche = new Car();
		yourPorche.setColor("gray");
		yourPorche.drive();
	}
}
