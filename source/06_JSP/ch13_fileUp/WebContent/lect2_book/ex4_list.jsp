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
	<%
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null){
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 9, BLOCKSIZE = 2;
		int startRow = (currentPage - 1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE -1;
		BookDao bDao = BookDao.getInstance();
		ArrayList<BookDto> books = bDao.listBook(startRow, endRow);
	%>
	<table>
		<caption>책 리스트</caption>
		<tr>
			<%
				if(books.isEmpty()){
					out.print("<td>책이 없습니다.</td>");
				}else{
					for(int i=0 ; i<books.size() ; i++){
						int bid = books.get(i).getBid();
						int price = books.get(i).getBprice();
						int discount = books.get(i).getBdiscount();
						int disPrice = price * (100 - discount) / 100;
						// 3개 출력했으면 <tr></tr>추가하고 3개출력
						if(i!=0 && i%3==0){
							out.print("</tr><tr>");
						}// if
			%>
						<td>
							<a href="content.jsp?bid=<%=bid%>&pageNum=<%=pageNum%>">
								<img src="<%=conPath%>/bookImg/<%=books.get(i).getBimage1()%>"><br>
								<%=bid %>.<%=books.get(i).getBtitle() %><br>
							</a>
							<del><%=price %></del><br>
							<b><%=disPrice %>원(<%=discount %>%할인)</b>
						</td>
			<%			
						// if(i%3==2){out.print("</tr><tr>");} // 3의 배수로 끝나면 tr한 행이 그냥 추가
					}// for
				}// if
			%>
		</tr>
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
				[<a href="ex4_list.jsp?pageNum=<%=startPage-1%>">이전</a>]	
		<%	}
			for(int i=startPage; i<=endPage ; i++){
				if(i == currentPage){
					out.print(" [ <b>" + i + "</b> ] ");
				}else{
					out.print(" [ <a href='ex4_list.jsp?pageNum=" + i + "'>" + i + "</a> ] ");
				}
			}
			if(endPage < pageCnt){
		%>
				[<a href="ex4_list.jsp?pageNum=<%=endPage+1%>">다음</a>]		
		<%	}%>
			
	</div>
	<hr>
	<a href="ex1_listBoard_nopaging.jsp">책 전체 리스트(게시판 스타일)</a><br>
	<a href="ex2_list.jsp">책 리스트 1page(게시판 스타일)</a><br>
	<a href="ex3_listProduct_nopaging.jsp">책 전체 리스트(제품 리스트 스타일)</a><br>
	<a href="ex4_list.jsp">책 리스트 1page(게시판 스타일)</a>
</body>
</html>