package com.lec.ch04.ex2_life;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class LifeCycleTestMain {
	public static void main(String[] args) {
		String loc = "classpath:META-INF/ex2/CTX.xml";
		//AbstractApplicationContext ctx = new GenericXmlApplicationContext(loc);//컨테이터생성->파싱->빈생성
		System.out.println("1. IOC 컨테이너 생성");
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		System.out.println("2. 파싱");
		ctx.load(loc);
		System.out.println("3. 빈 객체 생성");
		ctx.refresh();
		System.out.println("4. 빈을 주입받아 사용");
		Person person = ctx.getBean("person", Person.class);
		System.out.println(person);
		System.out.println("5. IOC 컨테이너를 소멸하면 빈도 자동 소멸");
		ctx.close();
	}
}











