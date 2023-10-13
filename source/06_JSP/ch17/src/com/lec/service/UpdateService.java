package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// update로직
		System.out.println("update로직(파라미터받아 dao를 통해 update하기");
		request.setAttribute("updateResult", 1);
	}

}
