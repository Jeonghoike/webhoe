package com.lec.ch03.method2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.ch03.Family;
import com.lec.ch03.Student;
import com.lec.ch03.StudentInfo;
public class Method2TestMain {
	public static void main(String[] args) {
		// AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml경로");
		AbstractApplicationContext ctx 
		= new AnnotationConfigApplicationContext(Method2ApplicationConfig.class, 
												Method2ApplicationConfig2.class);
		Student student1 = ctx.getBean("student1", Student.class);
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		Student student2 = studentInfo.getStudent();
		if(student1.equals(student2)) {
			System.out.println("student1과 2는 같은 객체");
		}else {
			System.out.println("student1과 2는 다른 객체");
		}
		Student student3 = ctx.getBean("student3", Student.class);
		Family family = ctx.getBean("family", Family.class);
		System.out.println("student1 : " + student1);
		System.out.println("student2 : " + student2);
		System.out.println("student3 : " + student3);
		System.out.println("family : " + family);
		ctx.close();
	}
}











