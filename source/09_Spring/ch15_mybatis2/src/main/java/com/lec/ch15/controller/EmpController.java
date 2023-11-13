package com.lec.ch15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch15.dto.Emp;
import com.lec.ch15.service.EmpService;
import com.lec.ch15.util.Paging;

@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	@RequestMapping(value = "empList", method=RequestMethod.GET)
	public String empList(String pageNum, Model model) {
		//empList.do 또는 empList.do?pageNum=2
		model.addAttribute("paging", new Paging(empService.totCnt(), pageNum, 10, 5));
		model.addAttribute("empList", empService.empList(pageNum));
		return "empList";
	}
	@RequestMapping(value = "dummyInsert50", method=RequestMethod.GET)
	public String dummy() {
		empService.dummyDataInsert50();
		return "redirect:empList.do";
	}
	@RequestMapping(value = "empDeptList", method= {RequestMethod.GET, RequestMethod.POST})
	public String empDeptList(String pageNum, Model model) {
		model.addAttribute("paging", new Paging(empService.totCnt(), pageNum, 10, 5));
		model.addAttribute("empList", empService.empDeptList(pageNum));
		return "empDeptList";
	}
	@RequestMapping(value = "detail", method= {RequestMethod.GET, RequestMethod.POST})
	public String detail(int empno, Model model) {
		model.addAttribute("empDto", empService.detail(empno));
		return "detail";
	}
	@RequestMapping(value = "update", method=RequestMethod.GET)
	public String update(int empno, Model model) {
		model.addAttribute("deptList", empService.deptList());
		model.addAttribute("empDto", empService.detail(empno));
		return "update";
	}
	@RequestMapping(value = "update", method=RequestMethod.POST)
	public String update(Emp emp, Model model) {
		model.addAttribute("modifyResult", empService.update(emp));
		return "forward:detail.do";
	}
	@RequestMapping(value = "delete", method=RequestMethod.GET)
	public String delete(int empno, Model model) {
		model.addAttribute("deleteResult", empService.delete(empno));
		return "forward:empDeptList.do";
	}
	@RequestMapping(value = "write", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("managerList", empService.managerList());
		model.addAttribute("deptList", empService.deptList());
		return "write";
	}
	@RequestMapping(value = "confirmNo", method=RequestMethod.GET)
	public String confirmNo(int empno, Model model) {
		if(empService.detail(empno)==null) {
			model.addAttribute("confirmMsg", "사용가능한 사번입니다");
		}else {
			model.addAttribute("confirmMsg", "중복된 사번은 사용불가합니다");
		}
		return "forward:write.do";
	}
	@RequestMapping(value = "write", method=RequestMethod.POST)
	public String write(Emp emp, Model model) {
		model.addAttribute("writeResult", empService.insert(emp));
		return "forward:empDeptList.do";
	}
}
