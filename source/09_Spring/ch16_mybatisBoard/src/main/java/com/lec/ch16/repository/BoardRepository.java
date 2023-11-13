package com.lec.ch16.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch16.vo.Board;
@Mapper
public interface BoardRepository {
	public List<Board> boardList(Board board);
	public int getBoardTotCnt();
	public int boardWrite(Board board);
	public int boardHitUp(int bid);
	public Board getBoardDto(int bid);
	public int boardModify(Board board);
	public int boardDelete(int bid);
	public int boardPreReplyStep(Board board);
	public int boardReply(Board board);
}
