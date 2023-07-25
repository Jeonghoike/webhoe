package com.lec.quiz;

import java.util.ArrayList;
import java.util.Scanner;
// N(n)�� �Է��� ������ �� �̸�, ��ȭ, �ּҸ� �Է¹޾� arrayList add
// N(n)�� �Է��ϸ� ������ ������ ���(arrayList for���� ���)
public class CustomerArrayListMain {
	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<Customer>(); // ������ ȸ������ add
		Scanner scanner = new Scanner(System.in);
		String answer, name, tel, address;
		// N(n)�� �Է��� ������ �� �̸�, ��ȭ, �ּҸ� �Է¹޾� arrayList add
		while(true) {
			System.out.print("ȸ�������� �����ϰڽ��ϱ�(Y/N)? ");
			answer = scanner.nextLine();
			if(answer.equalsIgnoreCase("n")) break;
			//�̸�, ��ȭ��ȣ, �ּ� �Է¹޾� customer��ü ����� customer.add�ϱ�
			System.out.print("�̸� ? ");
			name = scanner.nextLine();
			System.out.print("��ȭ ? ");
			tel = scanner.nextLine();
			System.out.print("�ּ� ? ");
			address = scanner.nextLine();
			// customers.add();
			customers.add(new Customer(name, tel, address));
//			Customer customer = new Customer(); // customer.name=null, address=null
//			System.out.print("�̸� ?");
//			customer.setName(scanner.nextLine());
//			System.out.print("��ȭ ? ");
//			customer.setTel(scanner.nextLine());
//			System.out.print("�ּ� ? ");
//			customer.setAddress(scanner.nextLine());
//			customers.add(customer);
		}
		// N(n)�� �Է��ϸ� ������ ������ ���(arrayList for���� ���)
		if(customers.size()==0) {
			System.out.println("������ ȸ���� �����ϴ�");
		}else {
			// customers ���(Ȯ�� for��, �Ϲ� for�� ��ΰ��� 
			for(Customer customer : customers) {
				System.out.println(customer);
			}
		}
	}
}
