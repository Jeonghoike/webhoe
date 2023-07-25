package com.lec.ex3_bufferReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

// 사용자로부터 파일이름을 입력(scanner) -> 해당 파일이름이 존재하는지 check 함수 -> 해당 파일을 console 출력
public class Ex02_filenameConsolePrint {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("읽어올 파일명은? : "); // abc.txt => txtFile/abc.txt
		String filename = scanner.next();
		scanner.close();
		File file = new File("txtFile/" + filename);
		if(file.exists()) {
			try {
				reader = new FileReader(file); // 1.스트림 생성 (기본스트림)
				br =new BufferedReader(reader); // 기본스트림을 통해 보조스트림 생성
				while(true) { // 2. 보조스트림을 통해 1줄식 read
					String linedata = br.readLine();
					if(linedata == null) break;
					System.out.println(linedata);
				}
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if(br!=null) br.close();
					if(reader != null) reader.close();
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}else {
			System.out.println("입력하신 파일은 존재하지 않습니다");
		}
	}
}
