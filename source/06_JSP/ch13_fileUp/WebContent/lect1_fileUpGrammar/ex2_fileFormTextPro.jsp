<%@page import="java.util.Arrays"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
		String path = request.getRealPath("fileUpFolder");
		int maxSize = 1024*1024*5; // 최대 업로드 용량 5M
		String[] filenames = {"","",""};
		String[] oriFilenames = {"","",""};
		String name = null; int age = 0;
		try{
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8",
																new DefaultFileRenamePolicy());
			Enumeration<String> paramNames = mRequest.getFileNames();
			int idx = 0;
			while(paramNames.hasMoreElements()){
				String param = paramNames.nextElement(); // 파라미터 이름
				filenames[idx] = mRequest.getFilesystemName(param); // 해당 파라미터 이름으로 저장된 파일이름
				oriFilenames[idx] = mRequest.getOriginalFileName(param); // 해당 파라미터 이름으로 첨부한 오리지널이름
				System.out.println(idx + "번째 파라미터 : " + param + 
						",서버에 저장된 파일 : " + filenames[idx] + ", 첨부한 오리지널 파일이름 : " + oriFilenames[idx]);
				idx++;
			}
			name = mRequest.getParameter("name");
			age = Integer.parseInt(mRequest.getParameter("age"));
			// DB
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		// DB
		// 파일 복사
		for(String filename : filenames){
			InputStream is = null;
			OutputStream os = null;
			try{
				File serverFile = new File(path + "/" + filename); // 서버에 업로드된 파일
				if(serverFile.exists()){
					is = new FileInputStream(serverFile);
					os = new FileOutputStream("C:/webhoe/source/06_JSP/ch13_fileUp/WebContent/fileUpFolder/" + filename); // 소스폴더로 복사된 파일
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
	%>
	
	<h3><%=Arrays.toString(filenames) %></h3>
	<h3><%=Arrays.toString(oriFilenames) %></h3>
	<h3>0번째 첨부</h3>
	<h4><%=path %>/fileUpFolder/<%=filenames[2] %></h4>
	<%if(filenames[2]!=null){ %>
	<img src="<%=conPath%>/fileUpFolder/<%=filenames[2]%>">
	<%} %>
	
	<h3>1번째 첨부</h3>
	<h4><%=path %>/fileUpFolder/<%=filenames[1] %></h4>
	<%if(filenames[1]!=null){ %>
		<img src="<%=conPath%>/fileUpFolder/<%=filenames[1]%>">
	<%} %>
	
	<h3>2번째 첨부</h3>
	<h4><%=path %>/fileUpFolder/<%=filenames[0] %></h4>
	<%if(filenames[0]!=null){ %>
		<img src="<%=conPath%>/fileUpFolder/<%=filenames[0]%>">
	<%} %>
	<h3>이름 : <%=name %></h3>
	<h3>나이 : <%=age %></h3>
</body>
</html>