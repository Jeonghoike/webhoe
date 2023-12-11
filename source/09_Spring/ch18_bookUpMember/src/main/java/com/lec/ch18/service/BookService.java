package com.lec.ch18.service;
import java.util.List;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.lec.ch18.vo.Book;
public interface BookService {
	public List<Book> mainList();
	public List<Book> bookList(String pageNum);
	public int totCntBook();
	public Book getDetailBook(int bnum);
	public int registerBook(MultipartHttpServletRequest mRequest, Book book);
	public int registerBook(MultipartHttpServletRequest mRequest); 
	public int modifyBook(MultipartHttpServletRequest mRequest, Book book);
	//public int modifyBook(MultipartHttpServletRequest mRequest);
}
