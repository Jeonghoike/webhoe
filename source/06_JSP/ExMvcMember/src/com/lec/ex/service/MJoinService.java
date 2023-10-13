package com.lec.ex.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;

public class MJoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		String mbirthStr = request.getParameter("mbirth");
		Date mbirth = null;
		String maddress = request.getParameter("maddress");
		MemberDao mDao = MemberDao.getInstance();
		int result = MemberDao.FAIL;
		result = mDao.midConfirm(mid);
		if(result == MemberDao.NONEXISTENT) {
			MemberDto newMember = new MemberDto(mid, mpw, mname, memail, mbirth, maddress, null);
			result = mDao.joinMember(newMember);
			if(result == MemberDao.SUCCESS) {
				HttpSession session = request.getSession();
				session.setAttribute("mid", mid);
				request.setAttribute("joinResult", "회원가입 완료되었습니다");
			}else {
				request.setAttribute("joinErrorMsg", "정보가 너무 길어 회원가입 실패");
			}
		}else {
			request.setAttribute("joinErrorMsg", "중복된 ID는 회원가입이 불가합니다");
		}
	}

}
