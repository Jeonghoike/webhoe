<%@page import="com.lec.ex.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
	<% // productStock.jsp?pname=공책
		String pname = request.getParameter("pname");
		ProductDao pDao = ProductDao.getInstance();
		int pStock = pDao.getProductStock(pname);
		if(pStock == -1){
			out.print("없는 제품");
		}else{
			out.print(pStock + "개 재고");
		}
	%>
</body>
</html>