package strategy3quiz.moudul;

import strategy3quiz.interfaces.GetSalary;
import strategy3quiz.interfaces.JobLec;

public class Lecture extends Person {
	private String subject;
	public Lecture(String id, String name, String subject) {
		super(id, name);
		setJob(new JobLec());
		setGet(new GetSalary());
		this.subject = subject;
		
	}
	@Override
	public void print() {
		super.print();
		System.out.println("[강의과목]" + subject);
	}
}
