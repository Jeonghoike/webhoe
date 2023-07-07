package com.lec.ex10_final;
// speed, running(), stop();오버라이드금지
public final class Rabbit extends Animal { // Rabbit 클래스를 상속하는 것은 금지
	@Override
	public void running() {
		speed += 30;
		System.out.println("토끼가 껑충껑충 뛰어요. 현재속도 : " + speed);
	}
}
