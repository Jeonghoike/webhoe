package com.lec.ch15.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.ch15.dao.DeptDao;
import com.lec.ch15.dao.EmpDao;
import com.lec.ch15.dto.Dept;
import com.lec.ch15.dto.Emp;
import com.lec.ch15.util.Paging;
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private DeptDao deptDao;
	@Autowired
	private EmpDao empDao;
	@Override
	public List<Dept> deptList() {
		return deptDao.deptList();
	}
	@Override
	public List<Emp> empList(String pageNum) {
		Paging paging = new Paging(empDao.totCnt(), pageNum, 10, 5);
		Emp emp = new Emp();
		emp.setStartRow(paging.getStartRow()); // emp 객체에 startRow 셋팅
		emp.setEndRow(paging.getEndRow()); // emp 객체에 endRow 셋팅
		return empDao.empList(emp);
	}

	@Override
	public List<Emp> empDeptList(String pageNum) {
		Paging paging = new Paging(empDao.totCnt(), pageNum, 10, 5);
		Emp emp = new Emp();
		emp.setStartRow(paging.getStartRow()); // emp 객체에 startRow 셋팅
		emp.setEndRow(paging.getEndRow()); // emp 객체에 endRow 셋팅
		return empDao.empDeptList(emp);
	}

	@Override
	public int totCnt() {
		return empDao.totCnt();
	}

	@Override
	public Emp detail(int empno) {
		return empDao.detail(empno);
	}

	@Override
	public List<Emp> managerList() {
		return empDao.managerList();
	}

	@Override
	public int insert(Emp emp) {
		return empDao.insert(emp);
	}

	@Override
	public int update(Emp emp) {
		return empDao.update(emp);
	}

	@Override
	public int delete(int empno) {
		return empDao.delete(empno);
	}

	@Override
	public void dummyDataInsert50() {
		Emp emp = new Emp();
		for(int i=6000 ; i<6050 ; i++) {
			emp.setEmpno(i);
			if(i%2 == 0) {
				emp.setEname("홍길동");
				emp.setJob("MANAGER");
			}else {
				emp.setEname("신길동");
				emp.setJob("SALESMAN");
			}
			emp.setMgr("7369");
			emp.setHiredate(Date.valueOf("2023-11-10"));
			emp.setSal(i);
			emp.setDeptno(40);
			int result = empDao.insert(emp);
			System.out.println(result==1? i+"번째 사원등록성공": i+"번째실패");
		}
	}
}
