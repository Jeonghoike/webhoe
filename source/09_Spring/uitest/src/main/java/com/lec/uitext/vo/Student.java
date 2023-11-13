package com.lec.uitext.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int totscore;
	private double avg;
}
