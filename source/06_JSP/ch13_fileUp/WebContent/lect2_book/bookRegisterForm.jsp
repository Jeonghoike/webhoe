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
	<form action="<%=conPath%>/lect2_book/bookRegisterPro.jsp"
						 method="post" enctype="multipart/form-data">
		<table>
			<caption>책등록</caption>
			<tr>
				<th>책제목</th>
				<td>
					<input type="text" name="btitle" maxlength="33" required="required" 
																			autofocus="autofocus">
				</td>
			</tr>
			<tr>
				<th>가격</th>
				<td>
					<input type="number" name="bprice" min="0" max="999999" required="required">
				</td>
			</tr>
			<tr>
				<th>대표이미지</th>
				<td><input type="file" name="bimage1"></td>
			</tr>
			<tr>
				<th>추가이미지</th>
				<td><input type="file" name="bimage2"></td>
			</tr>
			<tr>
				<th>책소개</th>
				<td>
					<textarea row="5" name="bcontent"></textarea>
				</td>
			</tr>
			<tr>
				<th>할인율</th>
				<td>
					<input type="number" name="bdiscount" min="0" max="100" value="0" required="required">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="책등록" class="btn"> 
				</td>
			</tr>
		</table>
	</form>
	<hr>
	<a href="ex1_listBoard_nopaging.jsp">책 전체 리스트(게시판 스타일)</a><br>
	<a href="ex2_list.jsp">책 리스트 1page(게시판 스타일)</a><br>
	<a href="ex3_listProduct_nopaging.jsp">책 전체 리스트(제품 리스트 스타일)</a><br>
	<a href="ex4_list.jsp">책 리스트 1page(게시판 스타일)</a>
</body>
</html>