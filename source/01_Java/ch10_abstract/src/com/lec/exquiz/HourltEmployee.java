package com.lec.exquiz;

public class HourltEmployee extends Employee {
	private int hoursWorked;
	private int moneyPerHour;
	
	public HourltEmployee(String name, int hourWorked, int moneyPerHour) {
		super(name);
		this.hoursWorked = hourWorked;
		this.moneyPerHour = moneyPerHour;
	}

	@Override
	public int computePay() {
		return hoursWorked*moneyPerHour;
	}

}
