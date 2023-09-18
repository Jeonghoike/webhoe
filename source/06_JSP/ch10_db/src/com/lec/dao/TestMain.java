package com.lec.dao;

import java.util.ArrayList;

import com.lec.dto.DeptDto;

public class TestMain {
	public static void main(String[] args) {
		DeptDao dao = DeptDao.getInstance();
		ArrayList<DeptDto> deptList = dao.deptList();
		for(DeptDto dept : deptList) {
			System.out.println(dept);
		}
	}
}
