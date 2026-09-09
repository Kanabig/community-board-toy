<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>

<link href="<c:url value='/resources/css/community/list_board.css' />" rel="stylesheet" type="text/css">

</head>
<body>
	
	<h3>게시글 목록</h3>
	
	<table>
	
		<thead>
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>등록일</th>
			</tr>
		</thead>
		
		<tbody>
		
			<c:forEach var="board" items="${communityBoardDtos}">
				
				<tr>
					<td>${board.cb_no}</td>
					<td>${board.cb_id}</td>
					<td>
						<a href="<c:url value='/community/detailBoard'>
						<c:param name='cb_no' value='${board.cb_no}'/>
						</c:url>">
						${board.cb_title}
						</a>
					</td>
					<td>${board.cb_reg_date}</td>					
				</tr>
				
			</c:forEach>
		
		</tbody>
	
	</table>
	
	<br>
	
	<a href="<c:url value='/community/writeBoardForm' />">게시글 작성</a>
	
</body>
</html>