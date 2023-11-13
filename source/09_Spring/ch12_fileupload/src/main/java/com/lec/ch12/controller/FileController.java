package com.lec.ch12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.lec.ch12.service.FileUpService;

@Controller
public class FileController {
	@Autowired
	private FileUpService fileUpService;
	@RequestMapping(value="fileup.do", method=RequestMethod.GET)
	public String fileup() {
		return "fileup";
	}
	@RequestMapping(value="fileup", method=RequestMethod.POST)
	public ModelAndView fileup(MultipartHttpServletRequest mRequest,
			ModelAndView mav) {
		// 서비스 함수 호출
		if(fileUpService.fileUp(mRequest, mav)) {
			mav.addObject("fileUpResult", "파일업로드 성공");
		}else {
			mav.addObject("fileUpResult", "파일업로드 안 됨");
		}
		mav.setViewName("fileResult");
		return mav;
	}
}
