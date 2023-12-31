package com.lec.ex3supermarket;

import java.util.ArrayList;
import java.util.Scanner;

public class SuperMarketMng {
	public static void main(String[] args) {
		CustomerDao dao = CustomerDao.getInstance();
		Scanner scanner = new Scanner(System.in);
		String fn;
		ArrayList<CustomerDto> customers;
		do {
			System.out.print("1:회원가입,2:폰검색,3:물품구입,4:레벨별출력,5:전체출력,6:회원탈퇴, 그외:종료");
			fn = scanner.next(); 
			switch(fn) {
			case "1" :
				System.out.print("가입할 회원 핸드폰 번호 ?");
				String ctel = scanner.next();
				System.out.print("가입할 이름은 ? ");
				String cname = scanner.next();
				int result = dao.insertCustomer(ctel, cname);
				System.out.println(result == CustomerDao.SUCCESS? "가입성공" : "가입실패");
				break;
			case "2" :
				System.out.print("검색할 전화번호 뒷4자리나 전화번호 전체 : ");
				String searchTel = scanner.next();
				customers = dao.ctelGetCustomers(searchTel);
				if(customers.isEmpty()) {
					System.out.println(searchTel + "전화번호로 검색된 고객이 없습니다. 회원가입하세요");
				}else {
					System.out.println("아이디\t핸드폰번호\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 추천 구매액");
					for(CustomerDto customer : customers) {
						System.out.println(customer);
					}
				}
				break;
			case "3" :
				System.out.print("구매할 고객 아이디번호(아이디가 잘못 입력될 경우 구매불가)");
				int cid = scanner.nextInt();
				if(dao.getCustomer(cid) != null) { // 구매진행
					System.out.print("구매금액은 ? ");
					int price = scanner.nextInt();
					result = dao.buy(cid, price);
					if(result == CustomerDao.SUCCESS) {
						System.out.println("구매 감사합니다." + price + "원 구매후 다음과 같이 고객님 정보가 수정되었습니다");
						System.out.println("아이디\t핸드폰번호\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 추천 구매액");
						System.out.println(dao.getCustomer(cid));
					}
				}else {
					System.out.println(cid + "는 유효한 고객 아이디가 아님니다. 구매불가");
				}
				break;
			case "4" :
				System.out.print("검색하고자 하는 레벨명" + dao.getLevelnames() + "은?");
				String levelName = scanner.next();
				customers = dao.levelNameGetCustomers(levelName);
				if(customers.isEmpty()) {
					System.out.println(levelName + " 고객은 검색되지 않습니다");
				}else {
					System.out.println("아이디\t핸드폰번호\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 추천 구매액");
					for(CustomerDto customer : customers) {
						System.out.println(customer);
					}
					System.out.println("총 " + customers.size() + "명");
				}
				break;
			case "5" :
				customers = dao.GetCustomers();
				if(customers.isEmpty()) {
					System.out.println(" 고객은 검색되지 않습니다");
				}else {
					System.out.println("아이디\t핸드폰번호\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 추천 구매액");
					for(CustomerDto customer : customers) {
						System.out.println(customer);
					}
				}
				break;
			case "6" :
				System.out.print("탙퇴할 전화번호는 ?");
				ctel = scanner.next();
				result = dao.deleteCustomer(ctel);
				System.out.println(result==CustomerDao.SUCCESS? "탈퇴완료" : "유효한 전화번호가 아님니다");
			}
		}while(fn.equals("1") || fn.equals("2") || fn.equals("3") || 
			   fn.equals("4") || fn.equals("5") || fn.equals("6"));
		System.out.println("BYE");
	}
}
