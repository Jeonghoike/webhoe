package com.lec.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.DeleteService;
import com.lec.service.InsertService;
import com.lec.service.SelectService;
import com.lec.service.Service;
import com.lec.service.UpdateService;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 무슨 요청이 들어왔는지 판별 (select.do? delete.do? insert.do? update.do?)
		String uri = request.getRequestURI(); // "/ch17/insert.do"
		String conPath = request.getContextPath(); // "/ch17"
		String command = uri.substring(conPath.length()); // "/insert.do"
		System.out.println("uri : " + uri);
		System.out.println("conPath : " + conPath);
		System.out.println("들어온 요청 : " + command);
		// 들어온 요청에 따라 다른 일을 하고 뷰단으로 forward
		String viewPage = null; // 뷰페이지를 저장할 변수
		Service service = null; //InsertService,SelectService,UpdateService, DeleteService 할당
		if(command.equals("/insert.do")) {
			// insert.do로 요청이 들어오면 할 일을 호출
			service = new InsertService();
			service.execute(request, response); // request에 "insertResult" 추가(1)
			viewPage = "select.do"; // insert후에 select.do로
		}else if(command.equals("/select.do")) {
			// select.do로 요청이 들어오면 할 일을 호출
			service = new SelectService();
			service.execute(request, response);// request에 "list"추가 
			viewPage = "ex2/select.jsp";
		}else if(command.equals("/update.do")) {
			// update.do 할 일을 호출
			service = new UpdateService();
			service.execute(request, response); // request에 updateResult 추가(1)
			viewPage = "select.do"; // update.do 처리 후 select.do로		
		}else if(command.equals("/delete.do")) {
			// delete.do 할 일을 호출
			service = new DeleteService();
			service.execute(request, response); // request에 deleteResult 추가(삭제성공)
			viewPage = "select.do"; // delete.do 처리후 select.do로
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
