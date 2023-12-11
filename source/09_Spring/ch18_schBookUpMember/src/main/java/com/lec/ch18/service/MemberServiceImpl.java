package com.lec.ch18.service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.lec.ch18.repository.MemberRepository;
import com.lec.ch18.vo.Member;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private JavaMailSender javaMailSender;
	@Override
	public int idConfirm(String mid) {
		return memberRepository.idConfirm(mid);
	}

	@Override
	public int joinMember(final Member member, HttpSession httpSession) {
		int result = memberRepository.joinMember(member); // DB저장
		if(result == 1) {
			httpSession.setAttribute("mid", member.getMid());
			MimeMessagePreparator message = new MimeMessagePreparator() {
				String content = 
								"<div style=\"width:500px; margin: 0 auto;\">\n" + 
								"	<h1>"+member.getMname()+"님의 회원가입 감사합니다.</h1>\n" + 
								"	<div>\n" + 
								"		<p>아무개 사이트에서만 쓰실 수 있는 감사쿠폰을 드립니다</p>\n" + 
								"       <img src=\"https://t1.daumcdn.net/daumtop_chanel/op/20170315064553027.png\" />\n" + 
								"		<hr color=\"red\">\n" + 
								"	</div>\n" + 
								"	<div>\n" + 
								"		<p style=\"color:red;\">빨간 글씨 부분</p>\n" + 
								"		<p style=\"color:blue\">파란 글씨 부분</p>\n" + 
								"		<img src=\"http://localhost:8090/ch17/img/coupon.jpg\">\n" + 
								"	</div>\n" + 
								"	<p>서울시 어떤구 몰라17길 51 어떤빌딩 4층</p>\n" + 
								"</div>";

				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(member.getMmail()));
					mimeMessage.setFrom(new InternetAddress("jhi63334@gmail.com"));
					mimeMessage.setSubject(member.getMname()+"님 회원가입 감사합니다");
					mimeMessage.setText(content, "utf-8", "html");
				}
			};
			javaMailSender.send(message);
		}
		return result;
	}

	@Override
	public String loginCheck(String mid, String mpw, HttpSession httpSession) {
		String result = "로그인 성공";
		Member member = memberRepository.getDetailMember(mid);
		if(member == null) {
			result = "유효하지 않은 아이디입니다";
		}else if(!member.getMpw().equals(mpw)){
			result = "비밀번호가 맞지 않습니다";
		}else {
			httpSession.setAttribute("member", member);
		}
		return result;
	}

	@Override
	public Member getDetailMember(String mid) {
		return memberRepository.getDetailMember(mid);
	}

	@Override
	public int modifyMember(Member member, HttpSession httpSession) {
		httpSession.setAttribute("member", member);
		return memberRepository.modifyMember(member);
	}

}
