package com.lec.ch13.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch13.dto.Emp;
@Mapper
public interface EmpDao {
	public List<Emp> empList(Emp schEmp);
}
