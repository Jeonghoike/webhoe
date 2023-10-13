<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>표현식 태그 이용</h2>
	<p>산술연산자 : 10+1 = <%=10+1 %></p>
	<p>산술연산자 : 10/0.0 = <%=10/0.0 %></p> <!-- 0으로 나누면 에러. 0.0으로 나누면 0에 가까운 수로 나눔 -->
	<p>관계연산자 : 1>2 = <%=1>2 %></p>
	<p>관계연산자 : 1==2 = <%=1==2 %></p>
	<p>관계연산자 : 1!=2 = <%=1!=2 %></p>
	<p>조건연산자 : <%=(1>2)? "1이 더 큽니다" : "1이 크지 않습니다" %></p>
	<p>로그인여부 : <%=session.getAttribute("customer")==null ? "로그인 안 함" :"로그인 함" %></p>
	<p>로그인여부 : <%=session.getAttribute("customer")!=null ? "로그인 함" :"로그인 안 함" %></p>
	<p>pageNum 파라미터 여부 : <%=request.getParameter("pagNum")==null ? "pageNum 안 옴" : "pageNum옴" %></p>
	<p>name 파라미터 값 : <%=request.getParameter("name") %></p>
	<%-- <p>name파라미터의 대문자 변경 : <%=request.getParameter("name").toUpperCase()%></p> --%>
	
	<h2>EL 표기법(표현식 안에 쓸 수 있는 모든 연산자는 다 사용 가능)</h2>
	<p>산술연산자 : 10+1 = ${10+1 }</p>
	<p>산술연산자 : 10/0.0 = ${10/0.0 } </p> <!-- 0으로 나누면 에러. 0.0으로 나누면 0에 가까운 수로 나눔 -->
	<p>관계연산자 : 1>2 = ${1>2 }</p>
	<p>관계연산자 : 1==2 = %{1 eq 2 }</p>
	<p>관계연산자 : 1!=2 = ${1!=2 }</p>
	<p>조건연산자 : ${(1>2)? "1이 더 큽니다" : "1이 크지 않습니다" }</p>
	<p>로그인 여부 : ${customer eq null? "로그인 안 함" :"로그인 함" }</p>
	<p>로그인 여부 : ${empty customer ? "로그인 안 함" :"로그인 함" }</p>
	<p>로그인 여부 : ${not empty customer? "로그인 함" :"로그인 안 함" }</p>
	<p>pageNum 파라미터 여부 : ${empty param.pageNum ? "pageNum 안 옴" : "pageNum옴" }</p>
	<p>name 파라미터 값 : ${param.name }</p>
	<p>name파라미터의 대문자 변경 : ${param.name.toUpperCase() }</p>
</body>
</html>