package com.lec.ch05.ex1_env;
import java.io.IOException;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;
public class AdminTestMain {
	public static void main(String[] args) {
		// 컨테이너 생성
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();
		// env의 속성과 속성값으로 되어 있는 propertySource들
		MutablePropertySources propertySources = env.getPropertySources();
		// propertySource들 뒤에 admin.properties의 내용을 추가
		String loc = "classpath:META-INF/ex1/admin.properties";
		try {
			propertySources.addLast(new ResourcePropertySource(loc)); // 추가
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("admin.id : " + env.getProperty("admin.id"));
		System.out.println("admin.pw : " + env.getProperty("admin.pw"));
		// 외부파일의 정보가 있는 env의 admin.id와 admin.pw를 빈으로 생성
		ctx.load("classpath:META-INF/ex1/CTX.xml");
		ctx.refresh();
		Admin admin = ctx.getBean("admin", Admin.class);
		System.out.println("admin객체의 admin.id : " + admin.getAdminId());
		System.out.println("admin객체의 admin.pw : " + admin.getAdminPw());
		ctx.close();
	}
}















