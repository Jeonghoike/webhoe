package com.lec.ch07.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	private static final Logger logger = LoggerFactory.getLogger(MyController.class);
	// http://localhost:8090/ch07/ 의 요청 처리 로직
	@RequestMapping("/")
	public String home () {
		logger.info("메인으로 감");
		return "main";
	}
}
