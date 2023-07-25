package com.lec.ex2_ReaderWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex01_FileReader {
	public static void main(String[] args) {
		Reader reader = null;
		try {
			reader = new FileReader("txtFile/inTest.txt"); // 1. 상대경로의 파일을 연다
			// reader = new FileReader("D:\\webPro\\source\\01_Java\\ch16_io\\txtFile\\inTest.txt"); // 절대경로
			// 2. 데이터를 읽는다
			while(true) {
				int i = reader.read(); // 2바이트 단위로 읽음
				if(i==-1) break;
				System.out.print((char)i/* + "(" + i + ")"*/);
			}
			System.out.println("DONE");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try { // 3. 파일을 닫는다
				if(reader!=null) reader.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} // close
		}//try-catch-finally
	}
}
