package com.lec.ex03_point.copy;
// 2차원 좌표값
public class Point {
	private int x;
	private int y;
	public Point() {
		System.out.println("매개변수 없는 부모클래스 생성자 함수");
	}
	public Point(int x, int y) {
		System.out.println("매개변수 있는 부모클래스 생성자 함수 -x, y 초기화");
		this.x = x;
		this.y = y;
	}
	public void infoPrint() {
		System.out.println("좌표 :(x, y) : "+ x+ "," + y);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
