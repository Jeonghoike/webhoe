package com.lec.ex08_customer;
// name, tel, infoString()
public class Staff extends Person{
	private String hiredate; // 입사일("2020-12-01") 다음주부터는  Date형
	private String department; // 부서
	// Staff s = new Staff("홍사원", "9999-9999", "2023-01-01", "전산");
	public Staff(String name, String tel, String hiredate, String department) {
		super(name, tel);
		this.hiredate = hiredate;
		this.department = department;
	}
	@Override
	public String infoString() {
		return super.infoString() + "[입사일]" + hiredate + "[부서]" + department;
	}
}
