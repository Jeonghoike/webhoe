package com.lec.ch18.service;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ch18.dao.MemberDao;
import com.lec.ch18.dto.MemberDto;
public class MemberJoinService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 파라미터(id, pw, name,birth) 받아 dao를 통해 join 수행후 결과를 request에 set 
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String birthStr = request.getParameter("birth");// ""나 "1999-12-12"
		Date   birth = null;
		if(!birthStr.equals("")) { // 생일을 입력한 경우
			birth = Date.valueOf(birthStr);
			// birth = Timestamp.valueOf(birthStr + " 00:00:00");
		}
		MemberDto newMember = new MemberDto(id, pw, name, birth, null);
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.joinMember(newMember);
		request.setAttribute("joinResult", result);
		if(result==MemberDao.SUCCESS) {
			request.setAttribute("joinMsg", "가입성공");
		}else {
			request.setAttribute("joinMsg", "가입실패");
		}
	}
}












