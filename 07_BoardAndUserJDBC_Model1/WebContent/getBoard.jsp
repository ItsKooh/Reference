<%@page import="kerson.sample.biz.board.BoardVO"%>
<%@page import="kerson.sample.biz.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	request.setCharacterEncoding("EUC-KR");

	BoardDAO dao = new BoardDAO();
	
	BoardVO vo = new BoardVO();    
	System.out.println("====> �Է°� : " + request.getParameter("seq"));
	vo.setSeq(Integer.parseInt(request.getParameter("seq")));
	System.out.println("====> �Է°� : " + vo.toString());

	BoardVO board = dao.getBoard(vo);
	System.out.println("====> ����� : " + board.toString());
%>

<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">    

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]--> 
  </head>
<title>�� ���</title>  
</head>
<script type="text/javascript">

	function updateClick() {
		document.getElementById("chgDvcd").value = "U";
	}
	
	function deleteClick() {
		document.getElementById("chgDvcd").value = "D";
	}
	
	
</script>
<body>  
	<div class="container"> 
		<h2>
			<center>�� �󼼳���</center>
		</h2>
		<form class="form-signin" action="updateBoard_proc.jsp" method="post">  
			<input type="text" id="seq" name="seq" value="<%= board.getSeq() %>" style="display:none;">
			<input type="text" id="chgDvcd" name="chgDvcd" style="display:none;">
			<div class="form-group">
				<label for="usr">����:</label> 
				<input type="text" class="form-control" id="title" name="title" value="<%= board.getTitle() %>">
			</div>
			<div class="form-group">  
				<label for="comment">����:</label>
				<textarea class="form-control" rows="5" id="content" name="content" ><%= board.getContent() %></textarea>
			
			</div>
			<div class="form-group">
				<label for="pwd">�ۼ���:</label> 
				<input type="text" class="form-control" id="writer" name="writer" value="<%= board.getWriter() %>">
			</div> 
			<button type="submit" class="btn btn-warning" name="update" onclick="updateClick()">����</button>
			<button type="submit" class="btn btn-danger" name="delete" onclick="deleteClick()">����</button>
			<a href="getBoardList.jsp"><button type="button" class="btn btn-default">�� ���</button></a>
		</form>
	</div>
</body>
</html>