<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="<c:url value='/resources/css/community/modify_board_form.css' />" rel="stylesheet" type="text/css">

</head>
<body>

	<h3>게시글 수정</h3>

	<form action="<%=request.getContextPath()%>/community/modifyBoardConfirm" method="post">
	
		<input type="hidden" name="cb_no" value="${communityBoardDto.cb_no}">
		
		<div>
			작성자
			<input type="text" value="${communityBoardDto.cb_id}" readonly>
		</div>
		<div>
			제목
			<input type="text" name="cb_title" value="${communityBoardDto.cb_title}">
		</div>
		<div>
			내용
			<textarea name="cb_comment">${communityBoardDto.cb_comment}</textarea>
		</div>
		<div>
			<input type="submit" value="수정">
		</div>
	</form>
	
	<a href="<%=request.getContextPath()%>/community/detailBoard?cb_no=${communityBoardDto.cb_no}">취소</a>
	
</body>
</html>