package com.lec.ch03.method3;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.ch03.Student;
public class Method3TestMain {
	public static void main(String[] args) {
		String loc = "classpath:META-INF/method3_applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(loc);
		Student student1 = ctx.getBean("student1", Student.class);
		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println("student1 : " + student1);
		System.out.println("student2 : " + student2);
		ctx.close();
	}
}
