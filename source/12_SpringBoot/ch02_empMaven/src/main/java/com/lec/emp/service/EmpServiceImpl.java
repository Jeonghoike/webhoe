package com.lec.emp.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lec.emp.model.Dept;
import com.lec.emp.model.Emp;
import com.lec.emp.repository.DeptRepository;
import com.lec.emp.repository.EmpRepository;
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired // 필터주입
	private DeptRepository deptRepository;
//	@Autowired // 생성자 주입
//	public EmpServiceImpl(DeptRepository deptRepository) {
//		this.deptRepository = deptRepository;
//	}
	@Autowired
	private EmpRepository empRepository;
	@Override
	public List<Dept> deptList() {
		return deptRepository.deptList();
	}

	@Override
	public List<Emp> empList(Emp schEmp) {
		if(schEmp.getEname()!=null) {
			schEmp.setEname(schEmp.getEname().toUpperCase());
		}
		if(schEmp.getJob()!=null) {
			schEmp.setJob(schEmp.getJob().toUpperCase());
		}
		return empRepository.empList(schEmp);
	}

}









