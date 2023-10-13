<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<%
			// main.jsp -> main.jsp?pageNum=1  main.jsp?pageNum=2		
			// 회원 정보 리스트를 table에 출력(paging 기능 추가)
			String pageNum = request.getParameter("pageNum");
			if(pageNum==null){
				pageNum = "1";
			}
			int currentPage = Integer.parseInt(pageNum);
			final int PAGESIZE = 5, BLOCKSIZE = 2;
			int startRow = (currentPage - 1) * PAGESIZE + 1;
			int endRow = startRow + PAGESIZE -1;
			CustomerDao cDao = CustomerDao.getInstance();
			ArrayList<CustomerDto> customers = cDao.listCustomer(startRow, endRow);
		%>
		<table>
			<tr style="height:60px;"><th>회원ID</th><th>비밀번호</th><th>이름</th><th>이메일</th><th>주소</th></tr>
			<%if(customers.size()==0){ %>
				<tr><td colspan="5">회원이 없습니다</td></tr>
			<%}else{
				for(CustomerDto c : customers){
					out.print("<tr style='height:60px;'><td>"+c.getCid()+"</td>");
					out.print("<td>"+c.getCpw()+"</td>");
					out.print("<td>"+c.getCname()+"</td>");
					out.print("<td>"+(c.getCemail()==null? "": c.getCemail())+"</td>");
					out.print("<td>"+(c.getCaddress()==null? "": c.getCaddress())+"</td></tr>");
				}
			}
			%>
		</table>
		<div class="paging">
			<%
				int totcnt = cDao.getCustomerTotalCnt();
				int pageCnt = (int)Math.ceil((double)totcnt/PAGESIZE); // 페이지수
				int startPage = ((currentPage-1)/BLOCKSIZE)*BLOCKSIZE +1; 
				int endPage   = startPage + BLOCKSIZE -1;
				if(endPage>pageCnt) endPage = pageCnt;
				if(startPage > BLOCKSIZE){%>
					[<a href="main.jsp?pageNum=<%=startPage-1%>"> 이전 </a>]
			<%}
				for(int i=startPage ; i<=endPage ; i++){
					if(i==currentPage){%>
						[ <b><%=i %></b> ]			
			<%	}else{%>
						[ <a href="main.jsp?pageNum=<%=i%>"> <%=i %> </a>]
			<%	}
				}
				if(endPage<pageCnt){ %>
					[ <a href="main.jsp?pageNum=<%=endPage+1%>">다음</a> ]
			<%}%>
		</div>	
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>