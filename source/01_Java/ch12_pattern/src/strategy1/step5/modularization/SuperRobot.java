package strategy1.step5.modularization;
// ctrl + shift + O Import�ҷ��� �� ���� 
import strategy1.step4.interfaces.FlyYes;

import strategy1.step4.interfaces.KnifeLazer;

import strategy1.step4.interfaces.MissileYes;

// actionWalk(), actionRun(), shape()
public class SuperRobot extends Robot {
	public SuperRobot() {
		setFly(new FlyYes()); //fly = new FlyYes();
		setMissile(new MissileYes()); //missile = new MissileYes();
		setKnife(new KnifeLazer()); //knife = new KnifeLazer();
	}
}
