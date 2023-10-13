package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.MemberDao;

public class MAllViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// allView.do나 allView.do?pageNum=2
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE=3, BLOCKSIZE=5;
		int startRow = (currentPage - 1) * PAGESIZE + 1;
		int endRow =  startRow + PAGESIZE -1;
		MemberDao mDao = MemberDao.getInstance();
		request.setAttribute("members", mDao.getMemberlist(startRow, endRow)); // ★뷰
		int totCnt = mDao.getMemberTotCnt(); // 회원수
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE);
		int startPage = ((currentPage - 1)/BLOCKSIZE)*BLOCKSIZE +1;
		int endPage = startPage + BLOCKSIZE -1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		request.setAttribute("BLOCKSIZE", BLOCKSIZE); // ★뷰
		request.setAttribute("startPage", startPage); // ★뷰
		request.setAttribute("endPage", endPage); // ★뷰
		request.setAttribute("pageNum", currentPage); // ★뷰
		request.setAttribute("pageCnt", pageCnt); // ★뷰
	}
}
