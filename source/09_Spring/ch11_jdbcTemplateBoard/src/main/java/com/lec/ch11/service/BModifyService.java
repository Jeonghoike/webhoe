package com.lec.ch11.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lec.ch11.dao.BoardDao;
import com.lec.ch11.vo.BoardDto;
@Service
public class BModifyService implements BService {
	@Autowired
	private BoardDao boardDao;
	@Override
	public void execute(Model model) {		
		Map<String, Object> map = model.asMap();
		BoardDto boardDto = (BoardDto)map.get("boardDto");
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		boardDto.setBip(request.getRemoteAddr());
		model.addAttribute("modifyResult", boardDao.modifyBoard(boardDto));
	}
}
