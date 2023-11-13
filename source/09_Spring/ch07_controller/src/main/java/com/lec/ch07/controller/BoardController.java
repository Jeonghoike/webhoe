package com.lec.ch07.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// board/write(GET)		board/content(GET)		board/list(GET)		board/reply(GET)
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lec.ch07.dto.Member;
@Controller
@RequestMapping("board") // 공통요청 경로
public class BoardController {
	@RequestMapping(value="write") // 요청경로 board/write
	public String write() {
		return "board/write"; // 뷰 : WEB-INF/views/board/write.jsp
	}
	@RequestMapping(value="content")
	public String content(Model model, HttpServletRequest request) {
		// request.setAttribute("id", "aaa"); = ${id}
		model.addAttribute("id", "aaa");
		model.addAttribute("pw", "111");
		Member member = new Member("bbb","222");
		model.addAttribute("member", member);
		return "board/content";
	}
	@RequestMapping(value="/list", method=RequestMethod.GET) // 요청경로 : board/list
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(new Member("aaa", "111"));
		list.add(new Member("bbb", "222"));
		list.add(new Member("ccc", "333"));
		mav.addObject("list", list);
		mav.setViewName("board/list");
		return mav;
	}
	/*public String list(Model model) {
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(new Member("aaa", "111"));
		list.add(new Member("bbb", "222"));
		model.addAttribute("list", list);
		return "board/list";
	}*/
	@RequestMapping(value="reply", method = RequestMethod.GET) // 입력받는 view페이지
	public ModelAndView reply(ModelAndView mav) {
		Member member = new Member("aaa", "111");
		mav.addObject("member", member);
		mav.setViewName("board/reply");
		return mav;
	}
	
	@RequestMapping(value="reply", method = RequestMethod.POST) // submit 처리
	public String reply(Model model) {
		model.addAttribute("result", "reply(POST)완료");
		return "board/result";
	}
}
