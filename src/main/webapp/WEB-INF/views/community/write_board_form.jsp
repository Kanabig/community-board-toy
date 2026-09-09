<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>

<link href="<c:url value='/resources/css/community/write_board_form.css' />" rel="stylesheet" type="text/css">

</head>
<body>
	
	<h3>게시글 작성</h3>
	
	<form action="<%=request.getContextPath()%>/community/writeBoardConfirm" method="post">
	
		<div>
			제목
			<input type="text" name="cb_title">
		</div>
		
		<div>
			내용
			<textarea name="cb_comment"></textarea>
		</div>
		
		<div>
			<input type="submit" value="글 등록">
		</div>
	
	</form>
	
</body>
</html>