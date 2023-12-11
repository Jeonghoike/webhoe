package com.lec.hello.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import lombok.extern.slf4j.Slf4j;
@Controller
@Slf4j
public class HelloController {
	// @RequestMapping(value="/", method=RequestMethod.GET)
	@GetMapping("/")
	public String index(Model model) {
		log.info("첫화면으로 감");
		model.addAttribute("greeting", "Hello, Spring Boot");
		return "index"; // templates/index.html
		// webcome page 우선순위 : 컨트롤러를 통한 view -> static/index.html
	}
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("data", "어서와 부트는 처음이지");
		return "hello";
	}
}
