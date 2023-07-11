package strategy1.step2;

public class Robot {
	public void actionWalk() {
		System.out.println("���� �� �ֽ��ϴ�.");
	}
	public void actionRun() {
		System.out.println("�� �� �ֽ��ϴ�.");
	}
	public void shape() { // "XXRobot�� ��, �ٸ�, ����, �Ӹ��� �ֽ��ϴ�." ���
		String className = getClass().getName(); // "strategy1.step2.SuperRobot"
		int idx = className.lastIndexOf("."); // �Ǹ������� ������ "."�� ��ġ 15 (strategy1.step2.SuperRobot�� �ι�°"."��ġ�� ����)
		String name = className.substring(idx+1); // 16°���� ������ ���ڿ� ����
		System.out.println(name + "�� ������ ��, �ٸ�, ����, �Ӹ��� �ֽ��ϴ�");
	}
}
