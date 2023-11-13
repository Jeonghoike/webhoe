package com.lec.ch02.ex3_student;
import org.springframework.context.support.GenericXmlApplicationContext;
public class StudentTestMain {
	public static void main(String[] args) {
		String location = "classpath:applicationCTX3.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(location);
		// 스트링 설정파일을 파싱해서 컨테이너 생성 - student1, student2, studentPrint 빈(컴포넌트)생성
		StudentPrint sPrint = ctx.getBean("studentPrint", StudentPrint.class);
		sPrint.print();
		Student student1 = ctx.getBean("student1", Student.class);
		Student student2 = ctx.getBean("student2", Student.class);
		if(sPrint.getStudent().equals(student1)) {
			System.out.println("sPrint의 student는 student1과 같은 객체");
		}else {
			System.out.println("sPrint의 student는 student1과 다른 객체");
		}
		sPrint.setStudent(student2);
		sPrint.print(); // 변경된 student2정보 출력
		if(sPrint.getStudent().equals(student1)) {
			System.out.println("sPrint의 student는 student1과 같은 객체");
		}else {
			System.out.println("sPrint의 student는 student1과 다른 객체");
		}
		ctx.close();
	}
}











