package com.lec.ex02_protected.copy;
// ChildIJ child = new ChildIJ(10,20)
public class ChildIJ extends SuperIJ{
	private int total;
	public ChildIJ() {
		System.out.println("매개변수 없는 ChildIJ 생성자 함수");
	}
	public ChildIJ(int i, int j) {
		super(i, j);
		System.out.println("매개변수 있는 ChildIJ 생성자 함수 - i,j초기화");
//		this.i = i;
//		setJ(j);
	}
	public void sum() {
		total = i + getJ();
		System.out.println("i="+i + ", j=" +getJ() + ", total=" +total);
	}
}
