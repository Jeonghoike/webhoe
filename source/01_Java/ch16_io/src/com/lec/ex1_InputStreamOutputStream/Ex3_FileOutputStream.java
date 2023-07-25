package com.lec.ex1_InputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex3_FileOutputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt", true); // true: append 
												// 기본값(false) : 파일이 없으면 생성. 파일이 있으면 덮어씀      
//			byte[] bs = {'H', 'e', 'l', 'l', 'o', '\n'};
			String msg = "Hi, Java\n01234567\n안녕\n";
			byte[] bs = msg.getBytes(); // 스트링을 byte배열로 바꾸는 함수
//			for(byte b : bs) {
//				os.write(b);
//			}
			os.write(bs);
			System.out.println("파일 출력 완료");
		} catch (FileNotFoundException e) {
			System.out.println("폴더를 못 찾음. 예외 메세지 : " + e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os!=null) os.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}//close
		}//try-catch-finally
	}
}
