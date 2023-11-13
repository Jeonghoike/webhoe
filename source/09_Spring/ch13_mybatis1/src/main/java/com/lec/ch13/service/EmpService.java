package com.lec.ch13.service;

import java.util.List;

import com.lec.ch13.dto.Dept;
import com.lec.ch13.dto.Emp;

public interface EmpService {
	public List<Dept> deptList();
	public List<Emp> empList(Emp schEmp);
}
