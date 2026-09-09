<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="<c:url value='/resources/css/community/detail_board.css' />" rel="stylesheet" type="text/css">

</head>
<body>

	<h3>게시글 상세</h3>
	
	    <table border="1">
	
	        <tr>
	            <th>번호</th>
	            <td>${communityBoardDto.cb_no}</td>
	        </tr>
	        <tr>
	            <th>작성자</th>
	            <td>${communityBoardDto.cb_id}</td>
	        </tr>
	        <tr>
	            <th>제목</th>
	            <td>${communityBoardDto.cb_title}</td>
	        </tr>
	        <tr>
	            <th>내용</th>
	            <td>${communityBoardDto.cb_comment}</td>
	        </tr>
	        <tr>
	            <th>등록일</th>
	            <td>${communityBoardDto.cb_reg_date}</td>
	        </tr>
	        <tr>
	            <th>수정일</th>
	            <td>${communityBoardDto.cb_mod_date}</td>
	        </tr>
	
	    </table>
	
	    <br>
	    <a href="<%=request.getContextPath()%>/community/listBoard">목록</a>
	    
	    <c:if test="${sessionScope.loginedUserMemberId eq communityBoardDto.cb_id}">
	    
		    <a href="<%=request.getContextPath()%>/community/modifyBoardForm?cb_no=${communityBoardDto.cb_no}">수정</a>
		    <a href="<%=request.getContextPath()%>/community/deleteBoardConfirm?cb_no=${communityBoardDto.cb_no}">삭제</a>
		    
		</c:if>

</body>
</html>