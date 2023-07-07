package com.lec.ex10_final;
// speed, running(), stop();오버라이드 금지
public class Dog extends Animal {
	@Override
	public void running() {
		speed += 10;
		System.out.println("강아지가 꼬리를 흔들며 뛰어요. 현재속도 : " + speed);
	}
}
