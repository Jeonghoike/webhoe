package com.lec.ex04_shape;

public class ShapeTestMain {
	public static void main(String[] args) {
		Shape[] shape = {new Circle(5), new Rectangle(10, 5), new Triangle(10, 3)};
		for(int idx=0 ; idx<shape.length ; idx++) {
			shape[idx].draw();
			System.out.println("³ÐÀÌ´Â" + shape[idx].area());
		}
		for(Shape s : shape) {
			s.draw();
			System.out.println("³ÐÀÌ´Â" + s.area());
		}
	}
}
