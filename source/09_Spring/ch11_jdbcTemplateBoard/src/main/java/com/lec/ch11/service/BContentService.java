package com.lec.ch11.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lec.ch11.dao.BoardDao;
@Service
public class BContentService implements BService {
	@Autowired
	private BoardDao boardDao;
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap(); //
		int bid = (Integer) map.get("bid");
		String after = (String)map.get("after"); // "u"(수정완료 후)이거나 null(list에서 옴)
		if(after==null) {
			boardDao.hitUp(bid);
		}
		model.addAttribute("contentBoard", boardDao.getBoardNotHitUp(bid));
	}
}
