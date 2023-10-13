package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;

public class BListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// pageNum파라미터 받아 startRow, endRowm startPagem endPage계산. dao를 통해 list
		// list.do나 list.do?pageNum=11
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 10, BLOCKSIZE=10;
		int startRow = (currentPage -1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE - 1;
		BoardDao bDao = new BoardDao();
		request.setAttribute("list", bDao.listBoard(startRow, endRow)); // 글목록 뷰페이지로 전달
		int totCnt = bDao.getBoardTotCnt(); // 글갯수
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE); // 전체 페이지 수
		int startPage = ((currentPage-1) / BLOCKSIZE) * BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE - 1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		request.setAttribute("BLOCKSIZE", BLOCKSIZE); // 이전을 출력할지 여부
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", currentPage);
		request.setAttribute("pageCnt", pageCnt); // 다음을 출력할지 여부
	}
}
