package strategy3quiz.moudul;

import strategy3quiz.interfaces.GetSalary;
import strategy3quiz.interfaces.GetStudentPay;
import strategy3quiz.interfaces.JobStudy;

public class Student extends Person {	
	private String ban;
	public Student(String id, String name, String ban) {
		super(id, name);
		setJob(new JobStudy());
		setGet(new GetStudentPay());
		this.ban = ban;
	}
	@Override
	public void print() {
		super.print();
		System.out.println("[¹Ý]" + ban);
	}
}
