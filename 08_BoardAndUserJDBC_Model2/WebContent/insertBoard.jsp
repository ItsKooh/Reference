<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<title>글 등록</title>   
</head>
<body>  
	<div class="container">
		<h2>
			<center>글 작성</center>
		</h2>
		<form action="insertBoard.do" method="post">   
			<div class="form-group">
				<label for="usr">제목:</label> 
				<input type="text" class="form-control" id="title" name="title">
			</div>
			<div class="form-group">  
				<label for="comment">내용:</label>
				<textarea class="form-control" rows="5" id="content" name="content"></textarea>
			
			</div>
			<div class="form-group">
				<label for="pwd">작성자:</label> 
				<input type="text" class="form-control" id="writer" name="writer"> 
			</div>  
			<button type="submit" class="btn btn-info">등록</button>
			<a href="getBoardList.do"><button type="button" class="btn btn-default">글 목록</button></a>
		</form>
		
	</div>
</body>
</html>