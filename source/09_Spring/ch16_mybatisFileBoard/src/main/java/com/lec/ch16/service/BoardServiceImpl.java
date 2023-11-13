package com.lec.ch16.service;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch16.repository.BoardRepository;
import com.lec.ch16.util.Paging;
import com.lec.ch16.vo.Board;
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardRepository boardRepository;
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	String backupPath = "C:/webhoe/source/09_Spring/ch16_mybatisFileBoard/src/main/webapp/upload/";
	@Override
	public List<Board> boardList(Paging paging) {
		Board board = new Board();
		board.setStartRow(paging.getStartRow());
		board.setEndRow(paging.getEndRow());
		return boardRepository.boardList(board);
	}

	@Override
	public int getBoardTotCnt() {
		return boardRepository.getBoardTotCnt();
	}
	
	@Override
	public int boardWrite(MultipartHttpServletRequest mRequest, HttpServletRequest request) {
		String uploadPath = mRequest.getRealPath("upload");
		String bfileName = null;
		Iterator<String> params = mRequest.getFileNames();
		String param = params.next();
		MultipartFile mfile = mRequest.getFile(param);
		bfileName = mfile.getOriginalFilename(); // 업로드한 파일명
		if(bfileName!=null && !bfileName.equals("")) {
			//첨부			
			if(new File(uploadPath + bfileName).exists()) {
				// 첨부파일과 같은 이름의 파일이 서버에 존재 : 현재밀리세컨+파일이름
				bfileName = System.currentTimeMillis() + bfileName;
			} // 중복된 파일 변경
			try {
				mfile.transferTo(new File(uploadPath + bfileName));
				logger.info("서버에 저장된 파일 : " + uploadPath + bfileName);
				logger.info("복사될 파일 : " + backupPath + bfileName);
				boolean result = filecopy(uploadPath+bfileName, backupPath+bfileName);
				logger.info(result ? "백업성공":"백업실패");
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
		Board board = new Board();
		board.setBname(mRequest.getParameter("bname"));
		board.setBtitle(mRequest.getParameter("btitle"));
		board.setBcontent(mRequest.getParameter("bcontent"));
		board.setBfileName(bfileName);
		board.setBip(request.getRemoteAddr());
		return boardRepository.boardWrite(board);
	}

	private boolean filecopy(String string, String string2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int boardWrite(MultipartHttpServletRequest mRequest, Board board, HttpServletRequest request) {
		board.setBip(request.getRemoteAddr());
		return boardRepository.boardWrite(board);
	}

	@Override
	public Board boardContent(int bid, String after) {
		if(after==null) {
			boardRepository.boardHitUp(bid);
		}
		return boardRepository.getBoardDto(bid);
	}

	@Override
	public Board boardModifyReplyView(int bid) {
		return boardRepository.getBoardDto(bid);
	}

	@Override
	public int boardMdify(MultipartHttpServletRequest mRequest, Board board, HttpServletRequest request) {
		board.setBip(request.getRemoteAddr());
		return boardRepository.boardModify(board);
	}

	@Override
	public int boardDelete(int bid) {
		return boardRepository.boardDelete(bid);
	}

	@Override
	public int boardReply(MultipartHttpServletRequest mRequest, Board board, HttpServletRequest request) {
		board.setBip(request.getRemoteAddr());
		boardRepository.boardPreReplyStep(board);
		return boardRepository.boardReply(board);
	}

	@Override
	public void dummyData70Write() {
		Board board = new Board();
		for(int i=1 ; i<=70 ; i++){
			board.setBname("홍길동" + i);
			board.setBtitle("제목 " + i);
			board.setBip("192.168.1." + i);
			int result = boardRepository.boardWrite(board);
			System.out.println(result==1? i+"번째 성공": i+"번째 실패");
		}
	}
}
