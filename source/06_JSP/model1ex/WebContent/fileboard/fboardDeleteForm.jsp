<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
	<style>
		#content_form{
			width:1000px; margin: 0px auto; height: 550px; 
			text-align: center;
			color: #003300;
			padding-top:50px;
		}
		#content_form input {height: 20px; padding:3px; margin: 10px 0;}
		#content_form .btn {height: 50px; padding:3px; margin: 5px 0;}
	</style>
	
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<%
			String pageNum = request.getParameter("pageNum");
			String fid = request.getParameter("fid");
			if(fid==null){
				response.sendRedirect(conPath + "/fileboard/fboardList.jsp");
			}
		%>
		<table>
			<caption><%=fid %>번 글 삭제</caption>
			<tr>
				<td>
					<fieldset>
						<legend>삭제를 위한 암호</legend>
						<form action="<%=conPath%>/board/fboardDeletePro.jsp" method="post">
							<input type="hidden" name="pageNum" value="<%=pageNum%>">
							<input type="hidden" name="bid" value="<%=fid%>">
							<p>암호<input type="password" name="bpw" required="required" autofocus="autofocus" class="btn"></p>
							<p>
								<input type="submit" value="삭제" class="btn">
								<input type="button" value="삭제취소" class="btn" onclick="history.back()">
							</p>
						</form>
					</fieldset>
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="../main/footer.jsp"/>
	
</body>
</html>