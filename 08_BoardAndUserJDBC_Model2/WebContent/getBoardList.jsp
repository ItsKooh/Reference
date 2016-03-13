<%@page import="java.util.List"%>
<%@page import="kerson.sample.biz.board.BoardVO"%>
<%@page import="kerson.sample.biz.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	HttpSession httpSession = request.getSession();
	List<BoardVO> boardList = (List<BoardVO>) httpSession.getAttribute("boardList"); 
%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>  
	<div class="container"> 
		<h2>
			<center>글 목록</center>
		</h2>
		<p>게시판에 등록된 글 목록을 출력합니다.</p>
		<table
			class="table table-striped table-bordered table-hover table-condensed">
			<thead>
				<tr>
					<th>#</th>
					<th>제목</th>
					<th>내용</th>
					<th>작성자</th>
					<th>조회건수</th>
				</tr>
			</thead>
			<% for ( BoardVO board : boardList ) { %>
			<tbody> 
				<tr> 
					<td><%= board.getSeq() %></td>
					<td><a href="getBoard.do?seq=<%= board.getSeq() %>"><%= board.getTitle() %></a></td>
					<td><a href="getBoard.do?seq=<%= board.getSeq() %>"><%= board.getContent() %></a></td>
					<td><%= board.getWriter() %></td> 
					<td><%= board.getCnt() %></td>
				</tr> 
			</tbody>  
			<% } %>
		</table>

		<a href="insertBoard.jsp"><button type="button" class="btn btn-info">등록</button></a> 
	</div>



</body>
</html>