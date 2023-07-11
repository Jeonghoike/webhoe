package strategy1.step3;

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
	} // main
}
