package com.lec.ch18.repository;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.lec.ch18.vo.Book;
@Mapper
public interface BookRepository {
	public List<Book> mainList();
	public List<Book> bookList(Book book);
	public int totCntBook();
	public Book getDetailBook(int bnum);
	public int registerBook(Book book);
	public int modifyBook(Book book);
}
