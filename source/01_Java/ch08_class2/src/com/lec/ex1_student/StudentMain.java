package com.lec.ex1_student;
public class StudentMain {
	public static void main(String[] args) {
		Student s1 = new Student("정우성", 90, 90, 90);
		Student s2 = new Student("김하늘", 90, 90, 91);
		Student s3 = new Student("황정민", 80, 80, 80);
		Student s4 = new Student("강동원", 80, 80, 81);
		Student s5 = new Student("마동석", 99, 99, 99);
		Student[] students = {s1, s2, s3, s4, s5};
		String[] title = {"이름","국어","영어","수학","총점","평균"};
		// int totKor = 0, totEng=0, totMat=0, totTot=0, totAvg=0;
		int[] total = new int[5]; // 0번idx:국어누적, 1번idx:영어누적... 4번idx:평균누적
		line();
		System.out.println("\t\t\t성 적 표");
		line('-');
		for(String t : title) {
			System.out.print("\t" + t);
		}
		System.out.println();
		line('-');
		for(int idx=0 ; idx<students.length ; idx++) {
			System.out.println(students[idx].infoString());
			// students[idx].print();
			total[0] += students[idx].getkor(); // 국어 누적
			total[1] += students[idx].getEng(); // 영어 누적
			total[2] += students[idx].getMat(); // 수학 누적
			total[3] += students[idx].getTot(); // 합계 누적
			total[4] += students[idx].getAvg(); // 평균 누적
			//total[4] = total[4] + (int)students[idx].getAvg();
		}
		line('-');
		System.out.print("\t총점");
		for(int tot : total) {
			System.out.printf("\t%4d", tot);
		}
		System.out.print("\n\t평균");
		for(int tot : total) {
			System.out.printf("\t%.1f", (double)tot/students.length);
		}
		System.out.println();// 개행
		line();
	}
	
	private static void line(char c) { // c를 라인으로 뿌리기
		System.out.print('\t');
		for(int i=0 ; i<50 ; i++) {
			System.out.print(c);
		}
		System.out.println();
		
	}
	private static void line() { // 진하고 긴 라인 뿌리기
		for(int i=0 ; i<65 ; i++) {
			System.out.print('■');
		}
		System.out.println();
	}

}
