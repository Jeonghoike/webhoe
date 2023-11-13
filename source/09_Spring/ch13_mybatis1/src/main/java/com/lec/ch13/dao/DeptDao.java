package com.lec.ch13.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lec.ch13.dto.Dept;
@Repository
public interface DeptDao {
	public List<Dept> deptList();
}
