package com.lec.ex1_string;
// String�� ������ �����ϰ��� ���°� StringBuffer > StringBuilder 
public class Ex10_StringBuffer {
	public static void main(String[] args) {
		String str ="abc";
		StringBuffer strbuBuffer = new StringBuffer("abc");
		System.out.println("strBuffer�� �ؽ��ڵ� : " + strbuBuffer.hashCode());
		strbuBuffer.append("def"); // "abcdef"
		System.out.println("append�� : " + strbuBuffer);
		System.out.println("strBuffer�� �ؽ��ڵ� : " + strbuBuffer.hashCode());
		strbuBuffer.delete(3,5); // "abcd" 3��°���� 5��° �ձ��� ����
		System.out.println("append�� : " + strbuBuffer);
		System.out.println("strBuffer�� �ؽ��ڵ� : " + strbuBuffer.hashCode());
	}
}
