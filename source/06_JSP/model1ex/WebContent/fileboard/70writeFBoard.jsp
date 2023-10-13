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
	<%--
		FileBoardDao fbDao = FileBoardDao.getInstance();
		FileBoardDto fbDto = new FileBoardDto();
		for(int i=0 ; i<70 ; i++){
			if(i%3==0){
				fbDto.setCid("aaa");
			}else if(i%3==1){
				fbDto.setCid("bbb");
			}else{
				fbDto.setCid("ccc");
			}
			fbDto.setFtitle("for문 돌려 강제로 입력한 글 "+i);
			fbDto.setFcontent("내용"+i);
			if(i%10 == 0){
				fbDto.setFilename("1.docx");
			}else{
				fbDto.setFilename(null);
			}
			fbDto.setFpw("111");
			fbDto.setFip("192.168.20.44");
			fbDao.writeFBoard(fbDto);
		}
		response.sendRedirect("fboardList.jsp");
	--%>
</body>
</html>