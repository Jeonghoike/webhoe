package com.lec.ex1_InputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// (1)파일연다  (2)데이터를읽는다(read(byte[])) (3)파일을닫는다
public class Ex02_FileInputStreamByteArray {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			// (1)파일연다
			is = new FileInputStream("D:/webPro/source/01_Java/ch16_io/txtFile/inTest.txt");// 상대경로, 절대경로 모두 가능
			// (2)데이터를읽는다(read(byte[]))
			byte[] bs = new byte[10];
			while(true) {
				int readByteCount = is.read(bs); // bs 배열만큼 읽고 읽은 byte 수를 리턴. 파일의 끝은 -1
				if(readByteCount == -1) break;
				for(int i=0 ; i< readByteCount ; i++) {
					System.out.print((char)bs[i]);
					//System.out.printf("%3d/", bs[i]);
				}
				//System.out.println();//개행
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일 못 찾음. 예외 메세지 : "+e.getMessage());
		} catch (IOException e) {
			System.out.println("읽기권한이 없거나 닫히지 않은 파일의 경우 예외 메세지 : "+e.getMessage());
		} finally {
			try {
				if(is!=null) is.close(); // (3)파일을닫는다
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
