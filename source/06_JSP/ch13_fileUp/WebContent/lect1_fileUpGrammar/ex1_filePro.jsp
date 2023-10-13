<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
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
		String path = request.getRealPath("fileUpFolder"); // 첨부할 파일이 저장될 서버(WAS)의 폴더
		// out.println(path);
		int maxSize = 1024*1024*10; // 업로드 최대 용량 10M
		String filename = "";
		String originalFilename = "";
		try{
			MultipartRequest mRequest =  new MultipartRequest(request, path, maxSize, "utf-8", 
																new DefaultFileRenamePolicy());
			// new DefaultFileRenamePolicy() : 같은 파일을 첨부할 경우 a.jpg -> a1.jpg -> a2.jpg
			Enumeration<String> paramNames = mRequest.getFileNames(); // 파일 첨부한 파라미터 이름들
			while(paramNames.hasMoreElements()){
				String param = paramNames.nextElement(); // param="file"
				filename = mRequest.getFilesystemName(param); // 파라미터로 서버에 저장된 파일이름 
				originalFilename = mRequest.getOriginalFileName(param); // 파라미터에 첨부한 오리지널 파일이름
				System.out.println("파라미터이름 : " + param + ",서버에 저장된 파일명 : " + filename + ",사용자가 첨부한 파일이름 : " + originalFilename);
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		// 서버에 업로드한 후 소스폴더로 파일copy (path -> 소스)
		InputStream is = null;
		OutputStream os = null;
		try{
			File serverFile = new File(path + "/" + filename); // 서버에 업로드된 파일
			if(serverFile.exists()){
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("C:/webhoe/source/06_JSP/ch13_fileUp/WebContent/fileUpFolder/" + filename); //소스폴더로 복사된 파일
				byte[] bs = new byte[(int)serverFile.length()];
				while(true){
					int readbyteCnt= is.read(bs);
					if(readbyteCnt==-1) break;
					os.write(bs, 0, readbyteCnt);
				}
				System.out.println("서버에 업로드 한 파일을 소스 폴더로 복사 완료");
			}else{
				System.out.println("첨부 파일이 없어서 복사 안 함");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(os!=null) os.close();
			if(is!=null) is.close();
		}// 서버에 업로드 된 파일을 소스폴더로 복사
		if(filename!=null){
	%>	
			<h3>첨부한 오리지널 파일이름 : <%=originalFilename %></h3>
			<h3>서버에 업로드된 파일이름 : <%=filename %></h3>
			<img src="<%=conPath %>/fileUpFolder/<%=filename %>" alt="업로드파일">
	<%	}else{%>
			<h3>첨부 안 함</h3>
			<h3>첨부한 오리지널 파일이름 : <%=originalFilename %></h3>
			<h3>서버에 업로드된 파일이름 : <%=filename %></h3>
	<%	}%>
</body>
</html>