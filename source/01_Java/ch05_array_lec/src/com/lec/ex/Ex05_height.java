package com.lec.ex;

import java.util.Scanner;

// 배열을 이용하여 친구들("영희","철수","길동","몽룡","춘향")의 키를 입력받고, 평균키를 출력.
// 가장 큰 친구와 가장 작은 친구를 출력(ex.길동 180)
public class Ex05_height {
	public static void main(String[] args) {
		String name[] = {"영희","철수","길동","몽룡","춘향"};
		int[] height = new int[name.length];
		int totalHeight =0; // 키 누적
		Scanner scanner = new Scanner(System.in);
		// 키 입력 받기 -> 키 누적
		for(int idx=0 ; idx<name.length ; idx++) {
			System.out.print(name[idx] + "의 키는 ?");
			height[idx] = scanner.nextInt();
			totalHeight += height[idx]; // 키 누적
		}
		for(int idx=0 ; idx<name.length ; idx++) {
			System.out.println(name[idx] + ":" + height[idx]);
		}
		System.out.printf("평균키: %.2f\n",(double)totalHeight/name.length);
		scanner.close();
		// 최장신, 최단신
		int maxIdx=0, max = 0; // 최장신을 구하기위한 변수(작은 값으로 초기화)
		int minIdx=0, min = 999; // 최단신을 구하기 위한 변수(큰 값으로 초기화)
		for(int idx=0 ; idx<name.length ; idx++) {
			if(height[idx]<min) {
				min = height[idx];
				minIdx = idx;
			}//if-최소값
			if(height[idx] > max) {
				max = height[idx];
				maxIdx = idx;
			}//if-최대값
		}//for
		System.out.println("최장신 : " + name[maxIdx] + " - " + height[maxIdx]);
		System.out.println("최단신 : " + name[minIdx] + " - " + height[minIdx]);
	}//main

}
