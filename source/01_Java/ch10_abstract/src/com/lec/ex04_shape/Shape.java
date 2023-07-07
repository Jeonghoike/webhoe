package com.lec.ex04_shape;

public abstract class Shape {
	public abstract double area();
	public void draw() {
		System.out.println("도형을 그려요");
	}
}
