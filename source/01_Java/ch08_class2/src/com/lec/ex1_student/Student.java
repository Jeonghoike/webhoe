package com.lec.ex1_student;
// 데이터(이름, 국. 영, 수,총 ,평) 생성자함수, 메소드, setter& getter
// Student s = new Student("정우성", 100, 99, 99)
public class Student {
	private String name;
	private int	   kor;
	private int    eng;
	private int    mat;
	private int    tot;
	private double avg;
	public Student() {} // 디폴투 생성자
	public Student(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		avg = tot/3.0;
	}
	public void print() {
		System.out.printf("\t%s \t %d 't %d \t %d \t %d \t %2.f\n", name, kor, eng, mat, tot, avg);
	}
	public String  infoString() {
		//return "\t"+name+"\t" +kor + "\t" + eng +"\t" + mat + "\t" + tot + "\t" + avg;
		return String.format("\t%s \t %d t %d \t %d \t %d \t %2.f", name, kor, eng, mat, tot, avg);
	}
	//getter
	public String getName() {
		return name;
	}
	public int getkor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMat() {
		return mat;
	}
	public int getTot() {
		return tot;
	}
	public double getAvg() {
		return avg;
	}
}