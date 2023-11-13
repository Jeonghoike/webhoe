package com.lec.ch13.dao;

import java.util.List;

import com.lec.ch13.dto.Emp;

public interface EmpDao {
	public List<Emp> empList(Emp schEmp);
}
