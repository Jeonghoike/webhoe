package strategy3quiz.moudul;

public class TestMain {
	public static void main(String[] args) {
		Student st1 = new Student("ere", "ȫ�浿", "�����ڹ�");
		Student st2 = new Student("dbd", "��浿", "�ڹٴܱ�");
		Lecture l1 = new Lecture("aaa", "���浿", "������");
		Lecture l2 = new Lecture("dbc", "������", "�����α׷���");
		Staff s1 = new Staff("sss", "�����", "����");
		Person[] person = {st1, st2, l1, l2, s1};
		for(Person p : person) {
			//System.out.println(p);
			p.print();
			p.job();
			p.get();
		}
		
	}
}
