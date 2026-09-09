<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>

<link href="<c:url value='/resources/css/community/write_board_form.css' />" rel="stylesheet" type="text/css">

</head>
<body>
	
	<section>

	    <div id="section_wrap">
	
	        <div class="word">
	            <h3>게시글 작성</h3>
	        </div>
	        <div class="write_board_form">
	
	            <form action="<c:url value='/community/writeBoardConfirm' />" method="post">
	
	                <table>
	
	                    <tr>
	                        <th>제목</th>
	                        <td><input type="text" name="cb_title" placeholder="제목을 입력하세요." required></td>
	                    </tr>
	
	                    <tr>
	                        <th>내용</th>
	                        <td><textarea name="cb_comment" placeholder="내용을 입력하세요." required></textarea></td>
	                    </tr>
	                    
	                </table>
	
	                <div class="buttons">
	
	                    <input type="submit"value="등록">
	                    <a href="<c:url value='/community/listBoard' />">취소</a>
	
	                </div>
	
	            </form>
	
	        </div>
	
	    </div>
	
	</section>
	
</body>
</html>