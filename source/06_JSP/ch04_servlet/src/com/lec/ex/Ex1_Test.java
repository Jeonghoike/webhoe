package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex1")
public class Ex1_Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("service() 수행 - get방식, post방식(doGet과 doPost수행 X");
//		request.setCharacterEncoding("utf-8");
//		actionDo(request, response);
//	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 수행");
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 수행");
		request.setCharacterEncoding("utf-8"); // request 파라미터를 한글처리
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// name과 pw 파라미터 받아 브라우저에 뿌리기
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		response.setContentType("text/html; charset=utf-8"); // response를 한글처리
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>이름은" + name + "</h2>");
		out.println("<h2>비번은" + pw + "</h2>");
		out.println("<h3>요청방식은" + request.getMethod() + "<h3>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
