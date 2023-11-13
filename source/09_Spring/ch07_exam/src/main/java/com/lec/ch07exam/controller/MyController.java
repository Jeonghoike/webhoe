package com.lec.ch07exam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MyController {
	private static final Logger logger = LoggerFactory.getLogger(MyController.class);
	@RequestMapping("/")
	public String home() {
		logger.info("메인으로 가기");
		return "main";
	}
}
