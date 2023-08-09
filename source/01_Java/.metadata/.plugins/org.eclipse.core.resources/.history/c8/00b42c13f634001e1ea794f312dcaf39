package com.lec.ex2person_dtoDao;

import java.util.ArrayList;

public class PersonDaoTest {
	public static void main(String[] args) {
		PersonDao dao = PersonDao.getInsance();
		System.out.println("직업명들 : " + dao.jnameList());
		System.out.println("1. 기능 insert 테스트");
		PersonDto dto = new PersonDto("홍홍홍", "배우", 80, 79, 90);
		int result = dao.insertPerson(dto);
		// System.out.println(result == PersonDto.SUCCESS? "입력성공":"입력실패");
		System.out.println("2. 배우 직업별 출력");
		ArrayList<PersonDto> dtos = dao.selectJname("배우");
		if(dtos.isEmpty()) {
			System.out.println("배우 직업의 사람이 등록되지 않았습니다.");
		}else {
			for(PersonDto d : dtos) { // 확장 for문
				System.out.println(d);
			}
			System.out.println("총" + dtos.size() + "명");
		}
		System.out.println("2. 개그맨 직업별 출력");
		dtos = dao.selectJname("개그맨");
		if(dtos.size()==0) {
			System.out.println("개그맨 직업의 사람이 등록되지 않았습니다.");
		}else {
			for(int idx=0 ; idx<dtos.size() ; idx++) { // 일반 for문
				System.out.println(dtos.get(idx));
			}
			System.out.println("총" + dtos.size() + "명");
		}
		System.out.println("3. 전체 출력 테스트");
		dtos = dao.selectAll();
		if(dtos.isEmpty()) {
			System.out.println("등록된 사람이 없습니다.");
		}else {
			for(int idx=0 ; idx<dtos.size() ; idx++) {
				System.out.println(dtos.get(idx));
				if(idx%3==2) {
					System.out.println("--------------------------------------------------------");
				} // if
			} // for
			System.out.println("총" + dtos.size() + "명");
		} // if
	} // main
}
