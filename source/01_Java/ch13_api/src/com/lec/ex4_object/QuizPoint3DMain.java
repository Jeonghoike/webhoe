package com.lec.ex4_object;

public class QuizPoint3DMain {
	public static void main(String[] args) {
		Point3D[] p3s = {new Point3D(), new Point3D(1.2, 3, 5), new Point3D()};
		System.out.println(p3s[0]);
		System.out.println(p3s[0].equals(p3s[2]));
		System.out.println(p3s[0].equals(p3s[1]));
		
		Point3D p1 = new Point3D();
		Point3D p2 = new Point3D(5.5, 4.4, 3.3);
		Point3D p3 = new Point3D(5.5, 4.4, 3.3);
		Point3D p4 = null;
		System.out.println("p1 : " + p1);
		System.out.println("p2 : " + p2);
		System.out.println("p1�� p2�� ���� ��ǥ������ ���� : " + p1.equals(p2));
		System.out.println("p3�� p2�� ���� ��ǥ������ ���� : " + p3.equals(p2));
		System.out.println("p2�� p4�� ���� ��ǥ������ ���� : " + p2.equals(p4));
	}
}
