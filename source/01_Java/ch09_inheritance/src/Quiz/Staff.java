package Quiz;

public class Staff extends Person{
	private static int cntStaff = 1;
	private String dep;
	public Staff(String id, String name, String dep) {
		super(id, name);
		this.dep = dep;
		++cntStaff;
		setNo("staff" + cntStaff);
	}
	@Override
	public String infoString() {
		return super.infoString()+"\t(ºÎ¼­)" + dep;
	}
}
