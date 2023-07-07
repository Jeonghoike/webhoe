package Quiz;

public class Student extends Person {
	private static int cntStudent = 0;
	private String ban;
	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
		++cntStudent;
		setNo("student" + cntStudent);	
	}
	@Override
	public String infoString() {
		return super.infoString()+"\t(¹Ý)" + ban;
	}
}
