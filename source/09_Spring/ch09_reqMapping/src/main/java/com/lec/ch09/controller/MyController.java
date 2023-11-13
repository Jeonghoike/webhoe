package com.lec.ch09.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	private static final Logger logger = LoggerFactory.getLogger(MyController.class);
	@RequestMapping(value = "main", method=RequestMethod.GET) // main.do 요청처리 
	public String main() {
		return "main";
	}
//	@RequestMapping(value = "student")
//	public String student(String id, Model model, HttpServletRequest request) {
//		String method = request.getMethod(); // GET또는 POST
//		logger.info("들어온 요청방식은 " + method);
//		model.addAttribute("method", method);
//		model.addAttribute("id", id);
//		return "studentId";
//	}
	@RequestMapping(value = "student", method=RequestMethod.GET)
	public String student(String id, Model model) {
		logger.info("들어온 요청방식은 GET");
		model.addAttribute("method", "GET");
		model.addAttribute("id", id);
		return "studentId";
	}
	@RequestMapping(value = "student", method=RequestMethod.POST)
	public String student(Model model, String id) {
		logger.info("들어온 요청방식은 POST");
		model.addAttribute("method", "POST");
		model.addAttribute("id", id);
		return "studentId";
	}
	@RequestMapping(value = "studentOk", method=RequestMethod.GET)
	public String studentOk() {
		return "studentOk";
	}
	@RequestMapping(value = "studentOk", method=RequestMethod.POST)
	public String studentOkPost() {
		return "studentOk";
	}
	@RequestMapping(value = "studentNg", method=RequestMethod.GET)
	public String studentNg() {
		return "studentNg";
	}
	@RequestMapping(value = "studentNg", method=RequestMethod.POST)
	public ModelAndView studentNg(ModelAndView mav) {
		mav.setViewName("studentNg");
		return mav;
	}
	@RequestMapping(value = "idConfirm", method=RequestMethod.POST)
	public String idConfirm(String id, Model model) {
		model.addAttribute("id", id);
		if(id.equals("aaa")) {
			// 제대로 된 id를 입력한 경우 "studentOk.do" 요청
			// return "redirect:studentOk.do"; // 새로운 request객체로 studentOk.do요청(GET)
			return "forward:studentOk.do"; // request객체를 새로 생성하지 않고, studentOk.do 요청(POST)
		}else {
			// confirm 실패된 id를 입력한 경우 "studentNg.do" 요청
			// return "redirect:studentNg.do"; // 새로운 request객체로 studentNg.do 요청
			return "forward:studentNg.do";
		}
	}
	@RequestMapping(value = "fullPath", method=RequestMethod.GET)
	public String fullPath() {
		// return "redirect:http://www.naver.com";
		// return "http://localhost:8090/ch09/temp/temp.jsp";
		return "redirect:temp/temp.jsp";
	}
}
