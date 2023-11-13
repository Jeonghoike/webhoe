package com.lec.ch10.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lec.ch10.dao.BoardDao;

@Service
public class BlistService implements BService {
	@Autowired
	private BoardDao boardDao;
	@Override
	public void execute(Model model) {
		// ${pageNum}가 필요
		Map<String, Object> map = model.asMap(); // model을 map으로 변경
		String pageNum = (String)map.get("pageNum");
		if(pageNum==null) pageNum = "1";
		final int PAGESIZE = 10, BLOCKSIZE=10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE - 1;
		// BoardDao boardDao = new BoardDao(); 의존 관계의 객체를 주입받아 씀
		// 뷰에 출력될 boardlist
		model.addAttribute("boardList", boardDao.listBoard(startRow, endRow));
		int orderNum = startRow; // 첫 라인에 출력하게 될 순차번호
		int totCnt = boardDao.getBoardTotCnt(); // 등록된 글 갯수
		int inverseNum = totCnt - startRow + 1; // 첫라인에 출력하게 될 역순번호
		model.addAttribute("orderNum", orderNum);
		model.addAttribute("inverseNum", inverseNum);
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE); 
		int startPage = ((currentPage -1)/BLOCKSIZE)*BLOCKSIZE +1; // jsp 때 공식
		startPage = currentPage - (currentPage-1)%BLOCKSIZE; // 다른공식
		int endPage = startPage + BLOCKSIZE - 1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		// 뷰에 출력될 page관련 변수
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("BLOCKSIZE", BLOCKSIZE);
		model.addAttribute("pageCnt", pageCnt);
		model.addAttribute("pageNum", currentPage);
	}

}
