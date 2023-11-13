package com.lec.ch03.method1;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.ch03.Family;
import com.lec.ch03.Student;
import com.lec.ch03.StudentInfo;
public class Method1TestMain {
	public static void main(String[] args) {
		String loc1 = "classpath:META-INF/method1_applicationCTX1.xml";
		String loc2 = "classpath:META-INF/method1_applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(loc1, loc2);
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println("student1 : " + student1);
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		Student student2 = studentInfo.getStudent();
		System.out.println("student2 : " + student2);
		if(student1.equals(student2)) {
			System.out.println("student1과 student2는 같은 객체");
		}else {
			System.out.println("student1과 student2는 다른 객체");
		}
		Student student3 = ctx.getBean("student3", Student.class);
		System.out.println("student3 : " + student3);
		if(student3.equals(student2)) {
			System.out.println("student2와 student3은 같은 객체");
		}else {
			System.out.println("student2와 student3은 다른 객체");
		}
		Family f = ctx.getBean("family", Family.class);
		System.out.println("f : " + f);
		ctx.close();
	}
}