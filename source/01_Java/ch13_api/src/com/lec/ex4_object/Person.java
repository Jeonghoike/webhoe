package com.lec.ex4_object;
// 데이터(private) + 생성자 + 메소드(기능, setter&getter, 오버라이드할 메소드)
// Person p1 = new Person();
// Person p2 = new Person(9812121012012L);
public class Person {
	private long juminNo; // 9812121012012
	public Person() {}
	public Person(long juminNo) {
		this.juminNo = juminNo;
	}
	@Override
	public String toString() {
		return "주민번호는" + juminNo;
	}
	@Override
	public boolean equals(Object obj) {
		// p1.equals(p2) : p1:this / p2:obj
		// (this.)juminNo와 obj.juminNo 같으면 true를 return
		if(obj!=null && obj instanceof Person) {
			Person other = (Person)obj;
			boolean juminNoChk = juminNo == other.juminNo;
			return juminNoChk;
		}
		return false;
	}
}
