package com.lec.ex1_string;
// String의 단점을 보완하고자 나온게 StringBuffer > StringBuilder 
public class Ex10_StringBuffer {
	public static void main(String[] args) {
		String str ="abc";
		StringBuffer strbuBuffer = new StringBuffer("abc");
		System.out.println("strBuffer의 해쉬코드 : " + strbuBuffer.hashCode());
		strbuBuffer.append("def"); // "abcdef"
		System.out.println("append후 : " + strbuBuffer);
		System.out.println("strBuffer의 해쉬코드 : " + strbuBuffer.hashCode());
		strbuBuffer.delete(3,5); // "abcd" 3번째부터 5번째 앞까지 삭제
		System.out.println("append후 : " + strbuBuffer);
		System.out.println("strBuffer의 해쉬코드 : " + strbuBuffer.hashCode());
	}
}
