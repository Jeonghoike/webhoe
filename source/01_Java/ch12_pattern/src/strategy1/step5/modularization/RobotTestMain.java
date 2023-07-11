package strategy1.step5.modularization;

import strategy1.step4.interfaces.FlyHigh;
import strategy1.step4.interfaces.KnifeToy;

public class RobotTestMain {
	public static void main(String[] args) {
		Robot superrobot = new SuperRobot();
		Robot standardRobot = new StandardRobot();
		Robot lowRobot = new LowRobot();
		Robot[] robots = {superrobot, standardRobot, lowRobot};
		for(Robot robot : robots) {
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
//			if(robot instanceof SuperRobot) {
//			SuperRobot tempRobot = (SuperRobot)robot;
//			tempRobot.actionFly();
//			tempRobot.actionMissile();
//			tempRobot.actionKnife();
//		}else if(robot instanceof StandardRobot){
//			StandardRobot tempRobot = (StandardRobot)robot;
//			tempRobot.actionFly();
//			tempRobot.actionmissile();
//			tempRobot.actionKnife();
//		}else if (robot instanceof LowRobot) {
//			LowRobot tempRobot = (LowRobot)robot;
//			tempRobot.actionFly();
//			tempRobot.actionmissile();
//			tempRobot.actionKnife();
//		} // if
		} // for
		System.out.println("SuperRobot 높이 아주 높이 날수 있는 기능으로 업그레이드"); 
		superrobot.setFly(new FlyHigh());
		superrobot.shape();
		superrobot.actionFly();
		System.out.println("LowRobot의 장난감 검이 있는 기능으로 업그레이드");
		lowRobot.setKnife(new KnifeToy());
		lowRobot.shape();
		lowRobot.actionKnife();
	} // main
}
