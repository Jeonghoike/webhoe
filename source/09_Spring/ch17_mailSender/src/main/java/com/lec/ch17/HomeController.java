package com.lec.ch17;

import java.util.Locale;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@Autowired
	private JavaMailSender mailSender; 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "join";
	}
	@RequestMapping(value = "textMail.do", method=RequestMethod.GET)
	public String textMail(String name, String email, Model model) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("[TEXT감사메일]" + name +"님 회원가입 감사합니다");
		String content = name + "님 회원가입 감사합니다\n <h1>태그 안 먹음</h1>"; 
		message.setText(content);
		mailSender.send(message);
		model.addAttribute("mailSendResult", "TEXT메일이 발송되었습니다");
		return "sendResult";
	}
	@RequestMapping(value = "htmlMail.do", method=RequestMethod.GET)
	public String htmlMail(final String name, final String email, Model model) {
		MimeMessagePreparator message = new MimeMessagePreparator() {
			String content = 
							"<div style=\"width:500px; margin: 0 auto;\">\n" + 
							"	<h1>"+name+"님의 회원가입 감사합니다.</h1>\n" + 
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
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
				mimeMessage.setFrom(new InternetAddress("jhi6334@gmail.com"));
				mimeMessage.setSubject("[html 감사메일]" + name + "님 회원가입감사합니다");
				mimeMessage.setText(content, "utf-8", "html");
			}
		}; // message
		mailSender.send(message);
		model.addAttribute("mailSendResult", "html 메일 발송이 완료되었습니다");
		return "sendResult";
	}
}
