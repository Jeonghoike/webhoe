package com.lec.ch18.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ch18.service.MemberJoinService;
import com.lec.ch18.service.MemberListService;
import com.lec.ch18.service.Service;
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean joinMode = false;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 들어온 요청을 판별하고 그에 따른 service.execute()를 호출한 후 viewPage로 forward 
		String uri = request.getRequestURI(); //"/ch18_mvc/memberList.do"
		String conPath = request.getContextPath(); // "/ch18_mvc"
		String command = uri.substring(conPath.length()); // "/memberList.do"
		String viewPage = null;
		Service service = null;
		if(command.equals("/memberList.do")) {
			// list로직을 수행 호출
			service = new MemberListService();
			service.execute(request, response); // memberList를 request 추가
			viewPage = "member/memberList.jsp";
		}else if(command.equals("/memberJoinView.do")) {
			// 회원가입 페이지로 
			viewPage = "member/memberJoin.jsp";
			joinMode = true;
		}else if(command.equals("/memberJoin.do")) {
			if(joinMode) {
				service = new MemberJoinService();
				service.execute(request, response);// joinResult와 joinMsg를 request 추가
				joinMode = false;
			}
			viewPage = "memberList.do"; // 회원가입후 회원리스트로
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}















