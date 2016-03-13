<%@page import="kerson.sample.biz.board.BoardVO"%>
<%@page import="kerson.sample.biz.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	request.setCharacterEncoding("EUC-KR");

	BoardDAO dao = new BoardDAO();
	
	BoardVO vo = new BoardVO();
	vo.setTitle(request.getParameter("title"));
	vo.setContent(request.getParameter("content"));
	vo.setWriter(request.getParameter("writer"));    
	
	System.out.println("====> 입력값 : " + vo.toString());
	
	dao.insertBoard(vo);
	
	response.sendRedirect("getBoardList.jsp"); 
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
</body>
</html>