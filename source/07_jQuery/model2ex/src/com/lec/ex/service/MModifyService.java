package com.lec.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("memberPhotoUp");
		int maxSize = 1024*1024; // 사진 업로드 제한 용량 : 1M
		String mphoto = ""; // 첨부된 파일이름을 저장할 변수
		int result = MemberDao.FAIL; // DB정보수정 결과를 저장할 변수
		MultipartRequest mRequest;
		try {
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames(); // 파라미터이름들
			//while(params.hasMoreElements()) {
				String param = params.nextElement(); // mphoto
				mphoto = mRequest.getFilesystemName(param); // 첨부한 파일명
			//}
			// mRequest를 이용하여 파라미터를 받아와서 DB에 수정 적용
			String dbMphoto = mRequest.getParameter("dbMphoto");
			// 현비밀번호를 맞게 입력했는지 여부는 자바스크립트로 뷰단에서 체크하고 넘어왔기 때문에 여기서는 체크 안 함
			// hidden으로 넘어온 dbMphoto가 없을 경우 session에서 가져오면 됨
//			HttpSession session = request.getSession();
//			String dbMphoto=null;
//			MemberDto sessionMember = (MemberDto)session.getAttribute("member");
//			if(sessionMember!=null) {
//			dbMphoto = sessionMember.getMphoto();
//			}
			String mid = mRequest.getParameter("mid");
			String oldMpw = mRequest.getParameter("oldMpw");
			String mpw = mRequest.getParameter("mpw");
			if(mpw.equals("")) {//정보수정시 새비밀번호를 입력하지 않은 겨우 현비밀번호
				mpw = oldMpw;
			}
			String mname = mRequest.getParameter("mname");
			String memail = mRequest.getParameter("memail");
			// 정보수정시 사진첨부 안 하면, 기존의 사진(dbMphoto)으로
			mphoto = mphoto==null? dbMphoto : mphoto;
			String mbirthStr = mRequest.getParameter("mbirth");
			Date mbirth = null;
			if(!mbirthStr.equals("")) {
				mbirth = Date.valueOf(mbirthStr);
			}
			String maddress = mRequest.getParameter("maddress");
			// DB에 정보 수정
			MemberDao mDao = MemberDao.getInstance();
			MemberDto mDto = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, null);
			result = mDao.modifyMember(mDto);
			if(result == MemberDao.SUCCESS) { // 수정 성공시, 세션도 수정
				HttpSession session = request.getSession();
				session.setAttribute("member", mDto);
				request.setAttribute("modifyResult", "회원 정보 수정 성공");
			}else {
				request.setAttribute("modifyErrorMsg", "회원정보 수정 실패(정보가 길거나 mid check)");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		File serverFile =new File(path + "/" + mphoto);
		if(serverFile.exists() && !mphoto.equals("NOIMG.JPG") && result==MemberDao.SUCCESS) {
			InputStream is = null;
			OutputStream os = null;
			try{
				is = new FileInputStream(serverFile); // 서버에 업로드된 파일
				os = new FileOutputStream("D:/webPro/source/07_jQuery/model2ex/WebContent/memberPhotoUp/"
								+ mphoto);
				byte[] bs = new byte[(int)serverFile.length()];
				while(true){
					int readByteCnt = is.read(bs);
					if(readByteCnt==-1) break;
					os.write(bs, 0, readByteCnt);
				}
				System.out.println(mphoto +" 복사 완료");
			}catch(Exception e){
				System.out.println(e.getMessage());
			}finally{
				try {
					if(os!=null) os.close();
					if(is!=null) is.close();
				}catch (IOException e) {
					System.out.println(e.getMessage());
				} // close
			}
		}		
	}
}
