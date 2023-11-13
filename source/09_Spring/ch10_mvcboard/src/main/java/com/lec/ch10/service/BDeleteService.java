package com.lec.ch10.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lec.ch10.dao.BoardDao;
@Service
public class BDeleteService implements BService {
	@Autowired
	private BoardDao boardDao;
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int bid = (Integer)map.get("bid");
		int result = boardDao.deleteBoard(bid);
		String deleteMsg = result==BoardDao.SUCCESS? bid+"번 글 삭제 성공" : bid+"번글 삭제실패";
		model.addAttribute("deleteMsg", deleteMsg);
	}

}
