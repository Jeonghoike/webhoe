package singleton2;

public class SecondClass {
	public SecondClass() {
		System.out.println("SecondClass ������ �����ߡڡڡڡڡڡڡڡڡڡڡڡڡ�");
		SingletonClass singtonObject = SingletonClass.getInstance();
		System.out.println("��Ŭ�� ��ü�� i����" + singtonObject.getI());
		System.out.println("SecondClass ������ ���� ���ڡڡڡڡڡڡڡڡڡڡڡڡ�");
	}
}
