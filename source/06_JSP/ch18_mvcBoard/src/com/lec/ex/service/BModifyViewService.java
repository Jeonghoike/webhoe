package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;

public class BModifyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// bid파라미터 받아 dao를 통해 dto request에 set
		int bid = Integer.parseInt(request.getParameter("bid"));
		BoardDao bDao = new BoardDao();
		request.setAttribute("modifyBoard", bDao.getBoardNotHitUp(bid));
	}

}
