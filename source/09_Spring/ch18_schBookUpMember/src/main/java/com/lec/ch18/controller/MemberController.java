package com.lec.ch18.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch18.service.MemberService;
import com.lec.ch18.vo.Member;

@Controller
@RequestMapping(value = "member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	@RequestMapping(value = "join", method=RequestMethod.GET)
	public String join() {
		return "member/join";
	}
	@RequestMapping(value = "idConfirm", method=RequestMethod.GET)
	public String idConfirm(String mid, Model model) {
		model.addAttribute("idConfirmResult", memberService.idConfirm(mid));
		return "member/idConfirm";
	}
	@RequestMapping(value = "join", method=RequestMethod.POST)
	// @ModelAttribute("mDto") 필요 (member라는 이름으로 들어가면 세션의 member와 혼돈될 수 있음)
	public String join(@ModelAttribute("mDto") Member member, Model model, HttpSession session) {
		model.addAttribute("joinResult", memberService.joinMember(member, session));
		return "member/login";
	}
	@RequestMapping(value = "login", method=RequestMethod.GET)
	public String login() {
		return "member/login";
	}
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(String mid, String mpw, String after, 
								HttpSession httpSession, Model model) {
		String loginResult = memberService.loginCheck(mid, mpw, httpSession);
		if(loginResult.equals("로그인 성공")) {
			return "redirect:../" + after;
		}else {
			model.addAttribute("loginResult", loginResult);
			model.addAttribute("mid", mid);
			model.addAttribute("mpw", mpw);
			return "member/login";
		}
	}
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:../main.do";
	}
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String modify() {
		return "member/modify";
	}
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modify(@ModelAttribute("mDto") Member member, HttpSession httpSession,
							Model model) {
		model.addAttribute("modifyResult", memberService.modifyMember(member, httpSession));
		return "forward:../main.do";
	}
}
