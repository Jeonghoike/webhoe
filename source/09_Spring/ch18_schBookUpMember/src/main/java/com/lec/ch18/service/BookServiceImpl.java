package com.lec.ch18.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch18.repository.BookRepository;
import com.lec.ch18.util.Paging;
import com.lec.ch18.vo.Book;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;
	String backupPath = "C:/webhoe/source/09_Spring/ch18_bookUpMember/src/main/webapp/bookImgFileUpload/";
	private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	@Override
	public List<Book> mainList() {
		return bookRepository.mainList();
	}

	@Override
	public List<Book> bookList(String pageNum, Book book) {
		Paging paging = new Paging(bookRepository.totCntBook(book), pageNum, 3, 3);
		book.setStartRow(paging.getStartRow());
		book.setEndRow(paging.getEndRow());
		return bookRepository.bookList(book);
	}

	@Override
	public int totCntBook(Book book) {
		return bookRepository.totCntBook(book);
	}

	@Override
	public Book getDetailBook(int bnum) {
		return bookRepository.getDetailBook(bnum);
	}

	@Override
	public int registerBook(MultipartHttpServletRequest mRequest, Book book) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames();
		String[] bimg = new String[2];
		int idx = 0;
		 while(params.hasNext()) {
			 String param = params.next();
			 MultipartFile mFile = mRequest.getFile(param); // 파라미터에 첨부된 파일 객체
			 bimg[idx] = mFile.getOriginalFilename();
			 if(bimg[idx] != null && !bimg[idx].equals("")) { // 첨부
				 if(new File(uploadPath + bimg[idx]).exists()) {
					 // 서버에 같은 파일이름이 있을 경우
					 bimg[idx] = System.currentTimeMillis() + "_" +  bimg[idx];
				 }
				 try {
					mFile.transferTo(new File(uploadPath + bimg[idx]));
					System.out.println("서버파일 : " + uploadPath + bimg[idx]);
					System.out.println("백업파일 : " + backupPath + bimg[idx]);
					boolean result = filecopy(uploadPath + bimg[idx], backupPath + bimg[idx]);
					System.out.println(result ? idx+"번째 백업성공":idx+"번째 백업실패");
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			 }else {
				 
			 }
			 idx++;
		}
		book.setBimg1(bimg[0]);
		book.setBimg2(bimg[1]);
		return bookRepository.registerBook(book);
	}
	
	@Override
	public int registerBook(MultipartHttpServletRequest mRequest) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames(); // tempBimg1, tempBimg2
		String[] bimg = new String[2];
		int idx = 0;
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터에 첨부된 파일 객체
			bimg[idx] = mFile.getOriginalFilename();
			if(bimg[idx]!=null && !bimg[idx].equals("")) {
				if(new File(uploadPath + bimg[idx]).exists()) {
					// 서버에 같은 파일이름이 있을 경우(첨부파일과)
					bimg[idx] = System.currentTimeMillis() + "_" + bimg[idx];
				}
				try {
					mFile.transferTo(new File(uploadPath + bimg[idx])); // 서버에 저장
					System.out.println("서버파일 : " + uploadPath + bimg[idx]);
					System.out.println("백업파일 : " + backupPath + bimg[idx]);
					boolean result = filecopy(uploadPath + bimg[idx], backupPath + bimg[idx]);
					System.out.println(result ? idx+"번째 백업성공":idx+"번째 백업실패");
				}  catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}else {
				// 파일 첨부 안 하면 bimg[idx] = ""이다
			}
			idx++;
		}
		Book book = new Book();
		book.setBtitle(mRequest.getParameter("btitle"));
		book.setBwriter(mRequest.getParameter("bwriter"));
		book.setBrdate(Date.valueOf(mRequest.getParameter("brdate")));
		book.setBinfo(mRequest.getParameter("binfo"));
		book.setBimg1(bimg[0]);
		book.setBimg2(bimg[1]);
		return bookRepository.registerBook(book);
	}
	
	@Override
	public int modifyBook(MultipartHttpServletRequest mRequest, Book book) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames(); 
		String[] bimg = new String[2];
		int idx = 0;
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터에 첨부된 파일 객체
			bimg[idx] = mFile.getOriginalFilename(); 
			if(bimg[idx]!=null && !bimg[idx].equals("")) { // 첨부함
				if(new File(uploadPath + bimg[idx]).exists()) {
					// 서버에 같은 파일이름이 있을 경우(첨부파일과)
					bimg[idx] = System.currentTimeMillis() + "_" + bimg[idx];
				}//if
				try {
					mFile.transferTo(new File(uploadPath + bimg[idx])); // 서버에 저장
					System.out.println("서버파일 : " + uploadPath + bimg[idx]);
					System.out.println("백업파일 : " + backupPath + bimg[idx]);
					boolean result = filecopy(uploadPath + bimg[idx], backupPath + bimg[idx]);
					System.out.println(result ? idx+"번째 백업성공":idx+"번째 백업실패");
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}else {
				// 파일 첨부 안 하면 bimg[idx] = "" 빈스트링으로 들어감
			}//if
			idx++;
		}
		book.setBimg1(bimg[0]);
		book.setBimg2(bimg[1]);
		return bookRepository.modifyBook(book);
	}
	private boolean filecopy(String serverFile, String backupFile) {
		boolean isCopy = false;
		InputStream is = null;
		OutputStream os = null;
		try {
			File file = new File(serverFile);
			is = new FileInputStream(file);
			os = new FileOutputStream(backupFile);
			byte[] bs = new byte[(int)file.length()];
			while(true) {
				int nReadBytes = is.read(bs);
				if(nReadBytes == -1) break;
				os.write(bs, 0, nReadBytes);
			}
			isCopy = true;
		} catch (IOException e) {
			logger.error(e.getMessage());
		}finally {
			try {
				if(is!=null) is.close();
				if(os!=null) os.close();
			}catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
		return isCopy;
	}
}
