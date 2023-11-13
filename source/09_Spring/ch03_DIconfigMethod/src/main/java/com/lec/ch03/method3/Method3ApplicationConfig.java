package com.lec.ch03.method3;
import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.lec.ch03.Student;
@Configuration
public class Method3ApplicationConfig {
	@Bean
	public Student student2() {
		ArrayList<String> hobby = new ArrayList<String>();
		hobby.add("그네타기"); hobby.add("윷놀이");
		Student student = new Student("성춘향", 20, hobby);
		student.setHeight(160);
		student.setWeight(50);
		return student;
	}
}
