<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<% // 5_guguOut.jsp?su=6 파라미터값은 스트링으로 전달
		int su = Integer.parseInt(request.getParameter("su"));
	%>
	<table>
		<caption><%=su %>단 구구단</caption>
		<%for(int i=1 ; i<10 ; i++){ %>
			<tr>
				<%-- <td><%=su %> * <%=i %> = <%=su *i%></td>--%>
				<td><%= su + " * " + i + " = " + (su*i) %></td>
			</tr>
		<%} %>
	</table>
	<%=request.getParameter("su") %>
</body>
</html>