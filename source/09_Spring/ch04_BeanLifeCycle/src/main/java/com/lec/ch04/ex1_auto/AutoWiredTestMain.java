package com.lec.ch04.ex1_auto;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class AutoWiredTestMain {
	public static void main(String[] args) {
		String loc = "classpath:META-INF/ex1/CTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(loc);
		Student student = ctx.getBean("student", Student.class);
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		Student student2 = studentInfo.getStudent();
		System.out.println("student : " + student);
		System.out.println("studentInfo안의 student : " + student2);
		if(student.equals(student2)) {
			System.out.println("같은 객체");
		}else {
			System.out.println("다른 객체");
		}
		ctx.close();
	}
}











