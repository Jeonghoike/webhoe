package strategy3quiz.moudul;

import strategy3quiz.interfaces.GetSalary;
import strategy3quiz.interfaces.JobMng;

public class Staff extends Person {
	private String Part;
	public Staff(String id , String name, String part) {
		super(id, name);
		setJob(new JobMng());
		setGet(new GetSalary());
		this.Part = part;
	}
	@Override
	public void print() {
		super.print();
		System.out.println("[ºÎ¼­]" + Part);
	}
}
