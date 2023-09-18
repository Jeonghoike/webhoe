<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<% // 파라미터 받기 "___5" => "5" 
		String num = request.getParameter("num");
		if(num!=null){
			num = num.trim();
		}
	%>
	<fieldset>
		<legend>숫자 입력</legend>
		<form action="">
			자연수
			<input type="number" min="1" name="num" value="<%=num!=null? num : ""%>">
			<%-- <input type="number" min="1" name="num" value="<%=
			                                               			if(num!=null){
			                                               				out.print(num);
			                                               			}
			                                                    %>"> --%>
			<input type="submit" value="누적">
		</form>
	</fieldset>
	<%
		if(num!=null){
			int n = Integer.parseInt(num);
			int tot = 0;
			for(int i=1 ; i<=n ; i++){
				tot += i;
			}
			out.println("<h2>1부터 " + n + "까지 누적합은" + tot + "입니다</h2>");
			System.out.println("1부터 " + n + "까지 누적합은 " + tot);
	%>
		<h2>1부터<%=n %>까지 누적합은<%=tot %>입니다</h2>
	<%}%>
</body>
</html>