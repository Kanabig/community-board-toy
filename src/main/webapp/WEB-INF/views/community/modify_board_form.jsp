<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="<c:url value='/resources/css/community/modify_board_form.css' />" rel="stylesheet" type="text/css">

</head>
<body>

	<section>

	    <div id="section_wrap">
	    
	        <div class="word">
	            <h3>게시글 수정</h3>
	        </div>
	        
	        <div class="modify_board_form">
	
	            <form action="<c:url value='/community/modifyBoardConfirm' />" method="post">

	                <input type="hidden" name="cb_no" value="${communityBoardDto.cb_no}">
	
	                <table>
	
	                    <tr>
	                        <th>작성자</th>
	                        <td><input type="text" value="${communityBoardDto.cb_id}" readonly></td>
	                    </tr>
	
	                    <tr>
	                        <th>제목</th>
	                        <td><input type="text" name="cb_title" value="${communityBoardDto.cb_title}" required></td>
	                    </tr>
	
	                    <tr>
	                        <th>내용</th>
	                        <td><textarea name="cb_comment" required>${communityBoardDto.cb_comment}</textarea></td>
	                    </tr>
	
	                </table>
	
	                <div class="buttons">
	
	                    <input type="submit" value="수정">
	
	                    <a href="<c:url value='/community/detailBoard'>
	                    <c:param name='cb_no' value='${communityBoardDto.cb_no}' />
	                    </c:url>">취소</a>
	
	                </div>
	
	            </form>
	
	        </div>
	
	    </div>
	
	</section>
	
</body>
</html>