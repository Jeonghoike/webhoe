package com.lec.ex4_momchild;

public class Child {
	private String name;
	static MomPouch momPouch = new MomPouch();
	public Child(String name) { // Child c1 = new Child("첫째 똘만이")
		this.name = name;
		//momPouch = new MomPouch();
	}
	public void takeMoney(int money) {
		if(momPouch.money >= money) {
			momPouch.money -= money; //momPouch.money = momPouch.money - money;
			System.out.println(name + "가" + money + "원 가져가서 엄마지갑에" + momPouch.money + "원남음");
		}else {
			System.out.println(name + "가 돈 못받음. 현재 엄마 지갑에" + momPouch.money + "원 뿐");
		}//if
	}// takMoney
}//class
