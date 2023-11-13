package com.lec.ch10.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lec.ch10.dao.BoardDao;
import com.lec.ch10.vo.BoardDto;
@Service
public class BWriteService implements BService {
	@Autowired
	private BoardDao boardDao;
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap(); // model을 map화
		BoardDto bDto = (BoardDto) map.get("bDto");
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		bDto.setBip(request.getRemoteAddr()); // ip
		model.addAttribute("writeResult", boardDao.writeBoard(bDto));
	}
}
