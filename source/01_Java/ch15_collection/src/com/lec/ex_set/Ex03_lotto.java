package com.lec.ex_set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class Ex03_lotto {
	public static void main(String[] args) {
		Random random = new Random();
//		int[] lottoArr = new int[6];
//		for(int idx=0 ; idx<lottoArr.length ; idx++) {
//			lottoArr[idx] = random.nextInt(45)+1; // 1~45사이의 정수 난수
//		}
//		System.out.println(Arrays.toString(lottoArr));
		//HashSet<Integer> lotto = new HashSet<Integer>();
		TreeSet<Integer> lotto = new TreeSet<Integer>();
		int cnt = 0;
		while(lotto.size()<6) {
			cnt ++;
			lotto.add(random.nextInt(45)+1);
		}
		System.out.println(cnt + "번 뽑은 로또 번호 : " + lotto);
	}
}
