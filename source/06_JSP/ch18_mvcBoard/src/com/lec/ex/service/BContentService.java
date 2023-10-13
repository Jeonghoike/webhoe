package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;

public class BContentService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// bid 파라미터 받아 dao를 통해 dto request에 추가(hitUp ?)
		int bid = Integer.parseInt(request.getParameter("bid"));
		BoardDao bDao = new BoardDao();
		// list.jsp를 통해서 content.do로 올 때만 조회수 1 up
		// list.jsp를 통해서 content.do로 올 때 url : content.do?bid=2&pageNum=2
		// 수정 성공 후 content.do로 올 때는 url : content.do?after=u
		if(request.getParameter("after")==null) {
			bDao.hitUp(bid);
		}
		request.setAttribute("contentBoard", bDao.getBoardNotHitUp(bid));
	}
}
