package Quiz;

public class Gangsa extends Person {
	private static int cntGangsa = 0;
	private String subject;
	public Gangsa(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		++cntGangsa;
		setNo("Gangsa" + cntGangsa);
	}
	@Override
	public String infoString() {
		return super.infoString() + "\t(°ú¸ñ)" + subject;
	}
}
