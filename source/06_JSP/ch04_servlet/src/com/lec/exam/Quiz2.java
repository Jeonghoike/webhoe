package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javafx.scene.control.Alert;

@WebServlet("/Quiz2")
public class Quiz2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numStr = request.getParameter("num");
		response.setContentType("text/html; charset=UTF-8");
		if(numStr==null) {
			response.getWriter().print("넘어온 파라미터가 없습니다");
		}else {
			int num = Integer.parseInt(numStr);
			int total = 0;
			for(int i=1 ; i<=num ; i++) {
				total += i;
			}
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<link href=\"\">"); 
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>1부터" + num + "까지 누적합은" + total + "입니다<h2>");
			out.println("</body>");
			out.println("</html>");
			out.close();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
