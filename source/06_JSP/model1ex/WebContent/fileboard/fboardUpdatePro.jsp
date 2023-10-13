<%@page import="java.util.Enumeration"%>
<%@page import="com.lec.dto.FileBoardDto"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.lec.dao.FileBoardDao"%>
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
		String path = request.getRealPath("fileboardUpload");
		int maxSize = 1024*1024*5;
		String filename = "";
		MultipartRequest mRequest = null;
		try{
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8",
									new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			int idx = 0;
			while(params.hasMoreElements()){
				String param = params.nextElement();
				filename = mRequest.getFilesystemName(param);
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		InputStream is = null;
		OutputStream os = null;
		try{
			File serverFile = new File(path + "/" + filename);
			if(serverFile.exists()){
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("C:/webhoe/source/06_JSP/model1ex/WebContent/fileboardUpload/" + filename);
				byte[] bs = new byte[(int)serverFile.length()];
				while(true){
					int readbyteCnt = is.read(bs);
					if(readbyteCnt==-1) break;
					os.write(bs, 0, readbyteCnt);
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(os!=null) os.close();
			if(is!=null) is.close();
		}
		String pageNum = mRequest.getParameter("pageNum");
		int fid = Integer.parseInt(mRequest.getParameter("fid"));
		String ftitle = mRequest.getParameter("ftitle");
		String fcontent = mRequest.getParameter("fcontent");
		String dbfilename = mRequest.getParameter("dbfilename");
		if(filename==null) filename = (dbfilename.equals("null") ? "":dbfilename);
		String fpw = mRequest.getParameter("fpw");
		String fip = request.getRemoteAddr();
		FileBoardDto fDto = new FileBoardDto(fid, null,ftitle, fcontent, filename, 0, fpw, 0, 0, 0, fip, null, null, null);
		FileBoardDao fDao = FileBoardDao.getInstance();
		int result = fDao.modifyFileBoard(fDto);
		if(result == FileBoardDao.SUCCESS){
	%>	
			<script>
				alert('글수정 성공');
				location.href='fboardList.jsp?pageNum=<%=pageNum%>';
			</script>	
	<%	}else{%>
			<script>
				alert('글수정 실패');
				history.go(-1);
			</script>
	<%	}%>
</body>
</html>