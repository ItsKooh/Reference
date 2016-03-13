<%@page import="kerson.sample.biz.user.UserDAO"%>
<%@page import="kerson.sample.biz.user.UserVO"%>
<%@page import="kerson.sample.biz.user.UserService"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	System.out.println("====> request.getParameter('id') : " + request.getParameter("id")); 
	System.out.println("====> request.getParameter('password') : " + request.getParameter("password")); 

	UserDAO dao = new UserDAO();

	// 3.입력값 SET 및 메소드 호출
	UserVO vo = new UserVO();
	vo.setId(request.getParameter("id"));
	vo.setPassword(request.getParameter("password")); 
	
	System.out.println("====> 입력값 : " + vo); 
	UserVO user = dao.getUser(vo);    
	System.out.println("====> 결과값 : " + user);
	
	if ( user.getId() != null ) {
		System.out.println("====> 로그인 성공!!");
		response.sendRedirect("getBoardList.jsp");
	} else {
		System.out.println("====> 로그인 실패");
		response.sendRedirect("login_bs.jsp");
	}

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
</body>
</html>