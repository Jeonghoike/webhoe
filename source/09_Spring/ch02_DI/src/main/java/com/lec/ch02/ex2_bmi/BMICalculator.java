package com.lec.ch02.ex2_bmi;
import lombok.Data;
@Data
public class BMICalculator {
	private double lowWeight;  // 저체중 bmi 지수 기준점
	private double normal;     // 정상체중 bmi 지수 기준점
	private double overWeight; // 과체중 bmi 지수 기준점
	private double obesity;    // 비만 bmi 지수 기준
	public void bmiCalculation(double weight, double height) {
		// 60Kg, 170cm일 때 bmi지수 = 60 / (1.7*1.7)
		double h = height * 0.01;
		double bmi = weight / (h*h);
		System.out.println("BMI 지수는 " + bmi);
		if(bmi <= lowWeight) {
			System.out.println("저체중입니다");
		}else if(bmi <= normal) {
			System.out.println("정상체중입니다");
		}else if(bmi <= overWeight) {
			System.out.println("과체중입니다");
		}else if(bmi <= obesity) {
			System.out.println("1단계 비만입니다");
		}else {
			System.out.println("2단계 비만입니다");
		}
	}
}












