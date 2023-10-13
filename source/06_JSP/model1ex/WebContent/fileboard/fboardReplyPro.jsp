<%@page import="com.lec.dto.FileBoardDto"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.Enumeration"%>
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
			File serverFile = new File (path + "/" + filename);
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
		int fgroup = Integer.parseInt(mRequest.getParameter("fgroup"));
		int fstep = Integer.parseInt(mRequest.getParameter("fstep"));
		int findent = Integer.parseInt(mRequest.getParameter("findent"));
		String cid = mRequest.getParameter("cid");
		String ftitle = mRequest.getParameter("ftitle");
		String fcontent = mRequest.getParameter("fcontent");
		String fpw = mRequest.getParameter("fpw");
		String fip = request.getRemoteAddr();
		FileBoardDto fDto = new FileBoardDto(fid, cid, ftitle, fcontent, filename, 0, fpw, fgroup,
				fstep, findent, fip, null, null, null); 
		FileBoardDao fDao = FileBoardDao.getInstance();
		int result = fDao.replyFileBoard(fDto);
		if(result==FileBoardDao.SUCCESS){
	%>	
			<script>
				alert('<%=fid%>번 답변글 성공');
				location.href='fboardList.jsp?pageNum=<%=pageNum%>';
			</script>	
	<%	}else{%>
			<script>
				alert('답변글쓰기 실패');
				history.go(-1);
			</script>
	<%	}%>
</body>
</html>