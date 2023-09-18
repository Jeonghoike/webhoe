<%@page import="java.io.IOException"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.Reader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<%
	String conPath = request.getContextPath(); // "/ch05_jsp"
	String appPath = application.getContextPath(); // "ch05_jsp"
	String absolutePath = application.getRealPath("."); // 현재 실행되는 절대 경로
%>
	<h2>conPath : <%=conPath %></h2>
	<h2>appPath : <%=appPath %></h2>
	<h2>absolutePath : <%=absolutePath %></h2>
<%
	String filePath = application.getRealPath("txt/text.txt");
	out.println(filePath + "의 내용입니다<br>");
	// 1.스트림객체생성(파일연다. 기본스트림->보조스트림)   2.읽고 화면출력     3.스트림닫는다(파일닫는다)
		Reader reader = new FileReader(filePath);  //1. 기본스트림 생성
		BufferedReader br = new BufferedReader(reader); // 보조스트림은 기본스트림을 통해 생성
		while(true) { // 2. 데이터를 한줄씩 읽는다(br.readLine())
			String linedata = br.readLine();
			if(linedata == null) break;
			out.println(linedata + "<br>");
			System.out.println(linedata);
		}
		out.println("== 파일 끝 ==");
		System.out.println("= = 파일 입력 끝 = =");
		br.close();
		reader.close();
	
	/* Reader reader = null;
	BufferedReader br = null;
	try {
		reader = new FileReader(filePath);  //1. 기본스트림 생성
		br = new BufferedReader(reader); // 보조스트림은 기본스트림을 통해 생성
		while(true) { // 2. 데이터를 한줄씩 읽는다(br.readLine())
			String linedata = br.readLine();
			if(linedata == null) break;
			out.println(linedata + "<br>");
			System.out.println(linedata);
		}
		out.println("== 파일 끝 ==");
		System.out.println("= = 파일 입력 끝 = =");
	} catch (IOException e) {
		System.out.println(e.getMessage());
	}finally {
		try { // 3. 스트림을 순서대로 닫는다
			if(br!=null) br.close();
			if(reader !=null) reader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	} */
%>
</body>
</html>