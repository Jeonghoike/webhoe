package com.lec.ex4_human.kid;
//main에서 Kid kid = new Kid("홍길동");
public class Kid {
	private String name;
	public Kid(String name) {
		this.name = name;
		System.out.println("name을 초기화하는 Kid 생성자 함수");
	}
}
