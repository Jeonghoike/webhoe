package com.lec.ex_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex01_HashSet {
	public static void main(String[] args) {
//		String s0 = "str0";
//		String s1 = new String("str0");
//		System.out.println(s0 == s1);
//		System.out.println(s0.equals(s1));
//		System.out.println(s0.hashCode());
//		System.out.println(s1.hashCode()); 
		HashSet<String> hashset = new HashSet<String>();
		hashset.add("str0");
		hashset.add("str1");
		hashset.add("str2"); // "str0".equals("str2"), " str1".equals("str2")
		System.out.println(hashset);
		System.out.println("hashset의 데이터 갯수 : " + hashset.size());
		hashset.add("str2"); // "str0".equals("str2"), " str1".equals("str2"), "str2".equals("str2")
							 // "str0".hashcode()와 "str2".hashcode()의 결과가 같은지 비교 
		System.out.println("중복 데이터 add 후 : " + hashset);
		System.out.println("중복 데이터 add 후 데이터 갯수 : " + hashset.size());
		Iterator<String> iterator =hashset.iterator(); // hashset 출력을 반복
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
