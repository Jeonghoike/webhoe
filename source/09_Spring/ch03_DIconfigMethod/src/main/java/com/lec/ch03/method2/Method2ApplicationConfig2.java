package com.lec.ch03.method2;
import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lec.ch03.Family;
import com.lec.ch03.Student;
@Configuration
public class Method2ApplicationConfig2 {
	@Bean
	public Student student3() {
		ArrayList<String> hobby = new ArrayList<String>();
		hobby.add("그네타기"); hobby.add("윷놀이");
		Student student = new Student("성춘향", 20, hobby);
		student.setHeight(160);
		student.setWeight(50);
		return student;
	}
	@Bean
	public Family family() {
		Family family = new Family("홍아빠", "김엄마");
		family.setSisterName("홍딸램");
		family.setBrotherName("홍아들");
		return family;
	}
}







