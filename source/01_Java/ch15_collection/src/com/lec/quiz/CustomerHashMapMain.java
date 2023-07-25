package com.lec.quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class CustomerHashMapMain {
	public static void main(String[] args) {
		HashMap<String, Customer> customers = new HashMap<String, Customer>();
		Scanner scanner = new Scanner(System.in);
		String answer, name, tel, address;
		while(true) {
			System.out.print("회원가입을 진행하겠습니다(Y/N)?");
			answer = scanner.nextLine();
			if(answer.equalsIgnoreCase("n")) break;
			System.out.print("이름 ? ");
			name = scanner.nextLine();
			System.out.print("전화 ? ");
			tel = scanner.nextLine();
			System.out.print("주소 ? ");
			address = scanner.nextLine();
			customers.put(tel, new Customer(name, tel, address));
			}
		if(customers.size()==0) {
			System.out.println("가입한 회원이 없습니다");
		}else {
			Iterator<String> iterator = customers.keySet().iterator();
			while(iterator.hasNext()) {
//				String key = iterator.next();
//				System.out.println(customers.get(key));
//				String key1 = iterator.next();
//				System.out.println(customers.get(key1));
				System.out.println(customers.get(iterator.next()));
			}
		}
	}
}
