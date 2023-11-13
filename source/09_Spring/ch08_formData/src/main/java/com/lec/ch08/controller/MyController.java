package com.lec.ch08.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	// 모든 요청 경로의 jsp 페이지에 출력할 내용(ex. 쿠팡에서의 장바구니 갯수..)
	@ModelAttribute("cnt")
	public int cnt() {
		return 5;
	}
	@ModelAttribute("list")
	public ArrayList<String> list(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("test1"); list.add("test2");
		return list;
	}
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String input() {
		// model.addAttribute("cnt", 5);
		return "member/input";
	}
//	@RequestMapping(value = "studentId/*", method=RequestMethod.GET)
//	public String studentId(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
//		String uri = request.getRequestURI(); // /ch09/studentId/aaa
//		String id = uri.substring(uri.lastIndexOf("/")+1);
//		id = URLDecoder.decode(id, "utf-8"); // url에 한글이 들어왔을 경우 
//		System.out.println("넘어온 id : " + id );
//		// http://localhost:8090/ch08/studentId/%ED%99%8D%EA%B8%B8%EB%8F%99
//		model.addAttribute("id", id);
//		return "studentId";
//	}
	@RequestMapping(value = "studentId/{id}", method=RequestMethod.GET)
	public String studentId(@PathVariable("id") String id, Model model) throws UnsupportedEncodingException {
		model.addAttribute("id", id);
		return "studentId";
	}
}
