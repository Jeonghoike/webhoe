package com.lec.ex;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex1_servlet")
public class Ex1_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 넘어온 파라미터 받아 db와 적당히 왔다갔다 한 정보를 request에 추가하고 view단으로 forward한다
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		Member member = new Member(id, pw, name);
		request.setAttribute("member", member); // view단으로 전달하고자 하는 데이터
		// view단으로 forward
		// RequestDispatcher dispatcher = request.getRequestDispatcher("1_dispatcher/ex1_view.jsp");
		// dispatcher.forward(request, response);
		// 위임하는 페이지에서 request객체가 새롭게 생성
		response.sendRedirect("2_redirect/ex1_view.jsp?id="+id+"&pw="+pw+"&name="+URLEncoder.encode(name,"utf-8"));
	}
}
