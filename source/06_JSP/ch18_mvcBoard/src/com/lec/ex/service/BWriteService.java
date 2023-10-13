package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;
import com.lec.ex.dto.BoardDto;

public class BWriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// bname, btitle, bcontent파라미터 받고, bip도 가져와서 dao통해 write
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bip = request.getRemoteAddr(); // 127.0.0.1(IPv4)
		// BoardDto dto = new BoardDto(0, bname, btitle, bcontent, null, 0, 0, 0, 0, bip);
		BoardDao bDao = new BoardDao();
		// bDao.writeBoard(dto);
		request.setAttribute("writeResult", bDao.writeBoard(bname, btitle, bcontent, bip));
	}

}
