package com.lec.ch06;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String home(Model model) {
		String greeting = "안녕하세요, 스프링";
		// request.setAttribute("greeting", greeting); => view에서는 ${greeting}
		model.addAttribute("greeting", greeting ); // view에서는 ${greeting}
		System.out.println(greeting);
		logger.info(greeting);
		logger.warn(greeting);
		logger.error(greeting);
		return "home"; // 뷰파일명:"/WEB-INF/views/home.jsp"
	}
	
}
