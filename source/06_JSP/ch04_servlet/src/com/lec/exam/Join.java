package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String birth = request.getParameter("birth");
		Date birthDate = null;    // 날짜만 필요한 경우
		Timestamp birthTS = null; // 날짜, 시간이다 필요한 경우
		if(birth!=null && !birth.equals(birth)) {
			birthDate = Date.valueOf(birth);
			birthTS = Timestamp.valueOf(birth + "00:00:00");
		}
		String[] hobby = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String[] mailSend = request.getParameterValues("mailSend");
		response.setContentType("text/Html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link href='css/join.css' rel='stylesheet'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id='joinForm_warp'>");
		out.println("<div id='joinForm_title'>회원가입정보</div>");
		out.println("<h2>이름 : " + name + "</h2>");
		out.println("<h2>id : " + id + "</h2>");
		// out.println("<tr><th>비번 : " + pw + "</th><tr><br>");
		out.println("<h2>비번 : " + pw.replaceAll("[a-zA-Z0-9~`!@#$%^&*()\\-_+=|\\\\{}\\[\\]:;\"'?/<>,\\.]", "*") + "</h2>");
		out.println("<h2>생년월일 : " + birth + "</h2>");
		out.println("<h2>취미 : ");
		if(hobby!=null) {
			for(int i=0 ; i<hobby.length ; i++) {
				if(i==hobby.length-1) {
					out.print(hobby[i]);
				}else {
					out.print(hobby[i]+", ");
				}
			}
			out.println("</h2>");
		}else {
			out.println("<h2>취미 : 없음</h2>");
		}
		// out.println("<tr><th>취미 : " + hobby + "</th><tr><br>");
		out.println("<h2>성별 : " + gender + "</h2>");
		out.println("<h2>이메일 : "+(email.equals("") ? "-":email)+"</h2>");
		out.println("<h2>이메일수신동의 : ");
		if(mailSend!=null) {
			out.print(Arrays.toString(mailSend));
		}else {
			out.println("모두거부");
		}
		//out.println("<tr><th>이메일수신동의 : " + mailSend + "</th><tr><br>");		
		out.println("<h2>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
