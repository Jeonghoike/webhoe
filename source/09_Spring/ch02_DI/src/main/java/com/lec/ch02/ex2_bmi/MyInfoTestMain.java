package com.lec.ch02.ex2_bmi;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class MyInfoTestMain {
	public static void main(String[] args) {
		String resource1 = "classpath:applicationCTX2_f.xml";
		String resource2 = "classpath:applicationCTX2_m.xml";
		AbstractApplicationContext ctx 
			= new GenericXmlApplicationContext(resource1, resource2);
		MyInfo woman = ctx.getBean("woman", MyInfo.class);
		MyInfo man   = (MyInfo)ctx.getBean("man");
		woman.infoPrint();
		man.infoPrint();
		ctx.close();
	}
}
