package com.lec.ch01;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class CalTestMain {
	public static void main(String[] args) {
		// applicationCTX.xml을 파싱하여 bean 생성 (IOC 컨테이너에)
		AbstractApplicationContext ctx 
			= new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		// IOC 컨테이너에 있는 빈을 주입(DI)
		Calculation cal = ctx.getBean("cal", Calculation.class);
//		Calculation cal = new Calculation();
//		cal.setNum1(10);
//		cal.setNum2(5);
		cal.add();
		cal.sub();
		cal.mul();
		cal.div();
		ctx.close();
	}
}
