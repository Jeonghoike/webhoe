package com.lec.ex6_person;

public class PersonTestMain {
	public static void main(String[] args) {
		int i = 10;
		// int[] arr = {10, 20, 30};
		int[] arr = new int[3];
		arr[0]=10; arr[1]=20; arr[2]=30;
		PersonInfo p1 = new PersonInfo("全辨悼", 20, 'm');
//		PersonInfo[] person = {new PersonInfo("全辨鉴", 22, 'f'), 
//								p1,
//								new PersonInfo("脚辨悼", 33, 'm')};
		PersonInfo[] person = new PersonInfo[3];
		person[0] = new PersonInfo("全辨鉴", 22, 'f');
		person[1] = p1;
		person[2] = new PersonInfo("脚辨悼", 33, 'm');
		for(int idx=0 ; idx<person.length ; idx++) {
			// person[idx].print();
			System.out.println(person[idx].infoPrint());
			System.out.println("-----------");
		}
		for(PersonInfo p : person) {
			//p.print();
			System.out.println(p.infoPrint());
			System.out.println("~~~~~~~~~~~");
		}
	}
}
