<%@page import="com.lec.book.BookDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.book.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<% // ex2_list.jsp(1페이지) ex2_list.jsp?pageNum=3
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null){
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 6, BLOCKSIZE = 2;
		int startRow = (currentPage - 1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE -1;
		BookDao bDao = BookDao.getInstance();
		ArrayList<BookDto> books = bDao.listBook(startRow, endRow);
	%>
	<table>
		<caption>책 리스트(board style)</caption>
		<tr><th>책ID</th><th>책이름</th><th>책표지</th><th>가격</th><th>할인율</th></tr>
		<%
			if(books.size()==0){
				out.print("<tr><td colspan='5'>해당페이지 책이 없습니다</td></tr>");
			}else{
				for(BookDto book : books){
					int bid = book.getBid();
					int price = book.getBprice();
					int discount = book.getBdiscount();
					int disPrice = price * (100-discount) / 100;
					out.print("<tr>");
					// 책ID
					out.print("<td>" + bid + "</td>");
					// 책이름(클릭시 상세보기 content.jsp?bid=2)
					out.print("<td><a href='content.jsp?bid=" + bid + "&pageNum="+pageNum+"'>" + book.getBtitle() + "</a></td>");
					// 책표지(클릭시 상세보기)
					out.print("<td><a href='content.jsp?bid=" + bid +"&pageNum="+pageNum+"'>");
					out.print("<img src='../bookImg/" + book.getBimage1() + "' alt='대표이미지' width='15'>");
					out.print("</a></td>");
					// 책가격
					out.print("<td><del>" + price + "</del><b>" + disPrice + "원</b></td>");
					// 할인율
					out.print("<td>" + discount + "</td>");
					out.print("</tr>");
				}
			}
		%>
	</table>
	<div class="paging">
		<%
			int pageCnt = (int)Math.ceil((double)bDao.getBookTotalCnt()/PAGESIZE);
			int startPage = ((currentPage -1)/BLOCKSIZE)*BLOCKSIZE + 1;
			int endPage = startPage + BLOCKSIZE - 1;
			if(endPage > pageCnt){
				endPage = pageCnt;
			}
			if(startPage > BLOCKSIZE){ // [이전]
		%>	
				[<a href="ex2_list.jsp?pageNum=<%=startPage-1%>">이전</a>]	
		<%	}
			for(int i=startPage; i<=endPage ; i++){
				if(i == currentPage){
					out.print(" [ <b>" + i + "</b> ] ");
				}else{
					out.print(" [ <a href='ex2_list.jsp?pageNum=" + i + "'>" + i + "</a> ] ");
				}
			}
			if(endPage < pageCnt){
		%>
				[<a href="ex2_list.jsp?pageNum=<%=endPage+1%>">다음</a>]		
		<%	}%>
			
	</div>
	<hr>
	<a href="ex1_listBoard_nopaging.jsp">책 전체 리스트(게시판 스타일)</a><br>
	<a href="ex2_list.jsp">책 리스트 1page(게시판 스타일)</a><br>
	<a href="ex3_listProduct_nopaging.jsp">책 전체 리스트(제품 리스트 스타일)</a><br>
	<a href="ex4_list.jsp">책 리스트 1page(게시판 스타일)</a>
</body>
</html>