package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

@WebServlet("/Ex2")
public class Ex2Param extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // request의 파라미터 한글처리
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// menu, rest파라미터들 , nation 파라미터 전달받아 화면에 출력
		String[] menu = request.getParameterValues("menu");
		String[] rest = request.getParameterValues("rest");
		String nation = request.getParameter("nation");
		response.setContentType("text/html; charset=utf-8");  // 화면의response 한글처리
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		if(menu!=null) {
			// out.println("<h2>선택한 메뉴는 " + Arrays.toString(menu) + "입니다</h2>");
			out.println("<h2>선택한 메뉴는 ");
//			for(String m : menu) {
//				out.print(m + ", ");  마지막 ,가 없어지지않아 일반for문으로 
//			}
			for(int i=0 ; i<menu.length ; i++) {
				if(i==menu.length-1) {
					out.print(menu[i]);
				}else {
					out.print(menu[i] + ", ");
				}
			}
			out.println("입니다</h2>");
		}else {
			out.println("<h2>선택한 메뉴가 없습니다</h2>");
		}
		if(rest!=null) {
			out.println("<h2>선택한 식당은 " + Arrays.toString(rest) + "입니다</h2>");
		}else {
			out.println("<h2>선택한 식당이 없습니다</h2>");
		}
		out.println("<h2>선택한 국적은 " + nation + "</h2>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
