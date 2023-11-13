package com.lec.ch03.method2;
import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.lec.ch03.Student;
import com.lec.ch03.StudentInfo;
@Configuration
public class Method2ApplicationConfig {
	@Bean
	public Student student1() {
		ArrayList<String> hobby = new ArrayList<String>();
		hobby.add("마라톤"); hobby.add("볼링"); hobby.add("탁구");
		Student student = new Student("홍길동", 30, hobby);
		student.setHeight(170);
		student.setWeight(60);
		return student;
	}
	@Bean
	public StudentInfo studentInfo() {
		StudentInfo info = new StudentInfo();
		info.setStudent(student1());
		return info;
	}
}














