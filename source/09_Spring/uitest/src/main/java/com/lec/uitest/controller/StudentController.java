package com.lec.uitest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.uitext.vo.Student;

@Controller
public class StudentController {
	@ModelAttribute("cnt")
	public int cnt() {
		return 4;
	}	
	@RequestMapping(value = "input", method=RequestMethod.GET)
	public String input() {
		return "student/input";
	}
	@RequestMapping(value = "input", method=RequestMethod.POST)
	public String inputPost(Student student) {
		student.setTotscore(student.getEng() + student.getKor() + student.getMath());
		student.setAvg((int) ((student.getTotscore()/3.0)*100)/100);
		return "student/result";
	}
}
