<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		table {width:400px; margin: 0 auto;}
		table th, input[type=button] { width:100px; background-color: #43BDE6; color:white; padding: 10px; text-align: center;}
		table td { background-color: #AFE0F0; padding: 10px; text-align: center; }
		table caption{padding: 5px 5px 10px; font-size: 1.2em; font-weight: bold;}
		input[type=text]:FOCUS { background-color: lightyellow; outline: 0;}
		#stockCnt{color:red;}
	</style>
	<script src="https://code.jquery.com/jquery-3.6.4.js"></script>
	<script>
		$(document).ready(function() {
			$('input[name=pname]').keyup(function() {
				$.ajax({
					url : 'productStock.jsp',
					type : 'post',
					data : 'pname=' + $(this).val(),
					dataType : 'html',
					success : function(data){
						$('#stockCnt').html(data);
					},
					error : function(code){
						$('#stockCnt').text(code.status);
					}
				});
			});
		});
	</script>
</head>
<body>
	<table>
		<caption>오늘의 예제</caption>
		<tr>
			<th>물건명</th>
			<td>
				<input type="text" name="pname">
				<span id="stockCnt"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span>
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<input type="button" value="재고량 확인" id="confirm">
			</th>
		</tr>
	</table>	
</body>
</html>