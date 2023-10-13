<%@page import="com.lec.dao.BookDao"%>
<%@page import="com.lec.dto.BookDto"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="jdk.management.resource.internal.inst.FileInputStreamRMHooks"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.Enumeration"%>
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
		String path = request.getRealPath("bookImg");
		out.println("서버에 저장될 폴더 : " + path + "<br>");
		int maxSize = 1024*1024*3;
		String[] images = {"",""};
		MultipartRequest mRequest = null;
		try{
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8",
										new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			int idx = 0;
			while(params.hasMoreElements()){
				String param = params.nextElement();
				images[idx] = mRequest.getFilesystemName(param);
				System.out.println(idx+"번째 처리한 파라미터 : " + param + "/파일명 : " + images[idx]);
				idx++;
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		for(String filename : images){
			InputStream is = null;
			OutputStream os = null;
			try{
				File serverFile = new File(path + "/" + filename);
				if(serverFile.exists()){
					is = new FileInputStream(serverFile);
					os = new FileOutputStream("C:/webhoe/source/06_JSP/model1ex/WebContent/bookImg/" + filename);
					byte[] bs = new byte[(int)serverFile.length()];
					while(true){
						int readbyteCnt= is.read(bs);
						if(readbyteCnt==-1) break;
						os.write(bs, 0, readbyteCnt);
					}
					System.out.println(filename +"복사 완료");
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}finally{
				if(os!=null) os.close();
				if(is!=null) is.close();
			}
		}

		String btitle =mRequest.getParameter("btitle");
		int bprice = Integer.parseInt(mRequest.getParameter("bprice"));
		String bimage1 = images[1]==null ? "noImg.png" : images[1];
		String bimage2 = images[0]!=null ? images[0] : "NOTHING.JPG"; 
		String bcontent = mRequest.getParameter("bcontent");
		int bdiscount = Integer.parseInt(mRequest.getParameter("bdiscount"));
		BookDto book = new BookDto(0, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, null);
		BookDao bDao = BookDao.getInstance();
		int result = bDao.insertBook(book);
		if(result==BookDao.SUCCESS){
	%>
			<script>
				alert('책등록 성공');
				location.href='<%=conPath%>/book/bookList.jsp';
			</script>
	<%	}else{%>
			<script>
				alert('책등록 실패');
				hitory.go(-1);
			</script>
	<%  }%>
</body>
</html>