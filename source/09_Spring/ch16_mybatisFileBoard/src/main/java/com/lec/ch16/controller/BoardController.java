package com.lec.ch16.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch16.service.BoardService;
import com.lec.ch16.util.Paging;
import com.lec.ch16.vo.Board;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired 
	private BoardService boardService;
	@RequestMapping(value = "list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(String pageNum, Model model) {
		Paging paging = new Paging(boardService.getBoardTotCnt(), pageNum);
		model.addAttribute("boardList", boardService.boardList(paging));
		model.addAttribute("paging", paging);
		return "board/list";
	}
	@RequestMapping(value = "dummyData70Write", method=RequestMethod.GET)
	public String dummyData70Write() {
		boardService.dummyData70Write();
		return "redirect:board/list.do";
	}
	@RequestMapping(value = "write", method=RequestMethod.GET)
	public String writeView() {
		return "board/write";
	}
	@RequestMapping(value = "write", method=RequestMethod.POST)
	public String write(MultipartHttpServletRequest mRequest, Board board, HttpServletRequest request, Model model) {
		model.addAttribute("writeResult", boardService.boardWrite(mRequest, board, request));
		return "forward:list.do";
	}
	@RequestMapping(value="content", method = {RequestMethod.GET, RequestMethod.POST})
	public String content(int bid, String after, Model model) {
		model.addAttribute("contentBoard",boardService.boardContent(bid, after));
		return "board/content";
	}
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String modifyView(int bid, Model model) {
		model.addAttribute("board",boardService.boardModifyReplyView(bid));
		return "board/modify";
	}
	@RequestMapping(value = "modify", method=RequestMethod.POST)
	public String modify(MultipartHttpServletRequest mRequest, Board board, HttpServletRequest request, Model model) {
		model.addAttribute("modifyResult", boardService.boardMdify(mRequest, board, request));
		return "forward:content.do?after=u";
	}
	@RequestMapping(value = "delete", method=RequestMethod.GET)
	public String delete(int bid, Model model) {
		model.addAttribute("deleteResult", boardService.boardDelete(bid));
		return "forward:list.do";
	}
	@RequestMapping(value = "reply", method=RequestMethod.GET)
	public String replyView(int bid, Model model) {
		model.addAttribute("board", boardService.boardModifyReplyView(bid));
		return "board/reply";
	}
	@RequestMapping(value = "reply", method=RequestMethod.POST)
	public String reply(MultipartHttpServletRequest mRequest, Board board, HttpServletRequest request, Model model) {
		model.addAttribute("replyResult", boardService.boardReply(mRequest, board, request));
		return "forward:list.do";
	}
}
