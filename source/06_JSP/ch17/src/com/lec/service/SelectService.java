package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// select 로직
		System.out.println("select로직 수행함(pageNum받아 startRow, endRow계산후 dao에서 list받아옴)");
		request.setAttribute("list", "list결과를 ArrayList로 받은 것");
		// 뷰던에서 필요한 데이터는 request에 setAttribute 합니다
	}

}
