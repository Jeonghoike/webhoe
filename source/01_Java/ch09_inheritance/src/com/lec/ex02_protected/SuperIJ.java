package com.lec.ex02_protected;

public class SuperIJ {
	protected int i;
	private int j;
	public SuperIJ() { //상속받은 클래스에서 부모클래스의 디폴트 생성자 함수 호출(기본)
		System.out.println("매개변수 없는 SuperIJ 생성자 함수");
	}
	public SuperIJ(int i, int j) {
		System.out.println("매개변수가 있는 SUperIJ 생성자함수로i, j값초기화");
		this.i = i;
		this.j = j;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	
}
