package com.lec.quiz;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberTestMain_outputStream {
	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<Member>();
		Scanner scanner = new Scanner(System.in);
		String answer, name, tel, birthStr, address; // ����ڿ��� ���� ������
		Date birthday;
		while(true) {
			System.out.println("ȸ�������ϽǷ���(��, ��ġ������ N) ?");
			if(scanner.next().equalsIgnoreCase("n")) break;
			System.out.print("�̸� ?");
			name = scanner.next();
			System.out.print("��ȭ ?");
			tel = scanner.next();
			System.out.println("���� (yyyy-MM-dd) ?");
			birthStr = scanner.next(); // "1998-07-19" / 
			birthday = toDate(birthStr);
			birthday = toDateTodayIsBirthDayChk(name, birthStr);
			System.out.print("�ּ� ?");
			address = scanner.nextLine();
			// members�� add
			members.add(new Member(name, tel, birthday, address));
		}
		// mambers�� ������ �ܼ�Ǯ�� & �������(outputStream)
		// mambers�� ������ �ܼ�Ǯ�� & �������(writer)
		// mambers�� ������ �ܼ�Ǯ�� & �������(PrintWriter)
		OutputStream os = null;
		try {
			os = new FileOutputStream("src/com/lec/quiz/member.txt");
			for(Member member : members) {
				System.out.println(member);
				os.write(member.toString().getBytes());
			}
			String msg = "\t\t\t...����" + members.size() +  "�� ����";
			System.out.println(msg);
			os.write(msg.getBytes());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
				try {
					if(os!=null) os.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
		}
	}// main
	private static Date toDate(String birthStr) { 
		// �Ű������� ���� "1995-01-01"�� Date������ ��ȯ�Ͽ� return
		Date result = null;
		StringTokenizer tokenizer = new StringTokenizer(birthStr, "-");
		if(tokenizer.countTokens() == 3) { 
			// ��������� ����� �Է�(��ū�� ������ 3)
			int year  = Integer.parseInt(tokenizer.nextToken());
			int month = Integer.parseInt(tokenizer.nextToken()) - 1;
			int day   = Integer.parseInt(tokenizer.nextToken());
			//result = new Date(year-1900, month, day);
			result = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
		}else {
			System.out.println("������� ������ �ùٸ��� �ʾ� �Էµ��� �ʾҽ��ϴ�");
		}
		return result;
	}
	private static Date toDateTodayIsBirthDayChk(String name, String birthStr) { 
		// �Ű������� ���� "1995-01-01"�� Date������ ��ȯ�Ͽ� retrun
		Date result = null;
		StringTokenizer tokenizer = new StringTokenizer(birthStr, "-");
		if(tokenizer.countTokens()==3) {
			// ��������� ����� �Է�(��ū�� ������ 3)
			int year = Integer.parseInt(tokenizer.nextToken());
			int month = Integer.parseInt(tokenizer.nextToken()) - 1;
			int day = Integer.parseInt(tokenizer.nextToken());
			result = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());	
			Date today = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("mm-dd");
			String todayStr = sdf.format(today);
			String resultStr =sdf.format(result);
			resultStr = birthStr.substring(birthStr.indexOf("-")+1);
			if(todayStr.equals(resultStr)) {
				System.out.println(name + "�� ������ �����̽ñ���. ���ϵ���� �ڡڡڡڡ�");
			}
		}else {
			System.out.println("������� ������ �ùٸ��� �ʾ� �Էµ��� �ʾҽ��ϴ�");
		}
		return result;
	}
}
