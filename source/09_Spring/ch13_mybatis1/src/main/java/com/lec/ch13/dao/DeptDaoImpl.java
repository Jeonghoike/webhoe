package com.lec.ch13.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lec.ch13.dto.Dept;
@Repository
public class DeptDaoImpl implements DeptDao {
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	@Override
	public List<Dept> deptList() {
		return sessionTemplate.selectList("deptList");
	}
}
