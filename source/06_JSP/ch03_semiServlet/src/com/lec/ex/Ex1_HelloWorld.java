package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.print.attribute.ResolutionSyntax;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex1_HelloWorld
 */
// @WebServlet(name = "HelloWorld", urlPatterns = { "/HW" })
public class Ex1_HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex1_HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get호출");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post호출");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); // 스트림 생성
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("h1{color:blue}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>안녕하세요, 첫 Servlet 예제입니다</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
