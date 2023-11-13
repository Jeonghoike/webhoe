package com.lec.ch16.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lec.ch16.util.Paging;
import com.lec.ch16.vo.Board;

public interface BoardService {
	public List<Board> boardList(Paging paging);
	public int getBoardTotCnt();
	public int boardWrite(Board board, HttpServletRequest request);
	public Board boardContent(int bid, String after);
	// 수정후 content.do?after=u
	public Board boardModifyReplyView(int bid);
	public int boardMdify(Board board, HttpServletRequest request);
	public int boardDelete(int bid);
	public int boardReply(Board board, HttpServletRequest request);
	public void dummyData70Write();
}
