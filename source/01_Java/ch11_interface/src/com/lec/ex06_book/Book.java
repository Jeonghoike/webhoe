package com.lec.ex06_book;
// Book book = new Book("890-ㅁ1", "JAVA", "신윤권");
public class Book implements ILendable {
	private String bookNo; // 청구번호
	private String bookTitle; // 책이름
	private String writer; // 저자
	private String borrower; // 대출인
	private String checkOutDate; // 대출일(07-07)
	private byte state; // 대출가능(0), 대출중(1)
	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
//		borrower = null;
//		checkOutDate = null;
//		state = 0;
	}
	@Override
	public void checkOut(String borrewer, String checkOutDate) { // 대출
		if(state == STATE_BORROWED) { // 대출중인 상태이면 메세지 뿌리고 끝
			System.out.println(bookTitle + "도서는 대출중입니다");
			return;
		}
		// state이 0(STATE_NORMAL)라서 대출 진행
		this.borrower = borrewer;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; // 대출중 상태로 전환
		System.out.println(bookTitle + "도서가 대출되었습니다");
		System.out.println("대출인 :" + borrewer + "\t대출일" + checkOutDate);
	}
	@Override
	public void checkIn() { // 반납
		if(state == STATE_NORMAL) { // 대출가능한 책이면 메세지 뿌리고 메소드 끝
			System.out.println(bookTitle + "도서는 반납이 완료된 책입니다. 확인하세요");
			return;
		}
		// state가 대출중 (1)이라 반납처리
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle + "도서가 반납 완료되었습니다");
	}
	@Override
	public void printState() { // "890-ㅁ1 JAVA (신윤권저) 대출가능"
//		if(state == STATE_BORROWED) {
//			System.out.println(bookNo + "\t" + bookTitle + "(" + writer +"저) - 대출중");
//		}else if(state==STATE_NORMAL) {
//			System.out.println(bookNo + "\t" + bookTitle + "(" + writer +"저) - 대출가능");
//		}else {
//			System.out.println(bookNo + "\t" + bookTitle + "(" + writer +"저) - 유령상태");
//		}
		String msg = bookNo + "\t" + bookTitle + "(" + writer + "저)";
		msg += state==STATE_BORROWED? "대출중(대출일: "+ checkOutDate + ")":"대출가능";
		System.out.println(msg);
	}
	public String getBookNo() {
		return bookNo;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public String getWriter() {
		return writer;
	}
	public String getBorrower() {
		return borrower;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public byte getState() {
		return state;
	}

}
