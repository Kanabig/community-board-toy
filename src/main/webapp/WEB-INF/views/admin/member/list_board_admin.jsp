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

	<jsp:include page="../../include/header.jsp" />
		
	<jsp:include page="../include/nav.jsp" />
	
	<section>
	
		<div id="section_wrap">
			
			<div class="word">
	
			<h3>관리자 전용 - 게시글 목록</h3>
			
			<table>
			
				<thead>
					<tr>
						<th>번호</th>
						<th>작성자</th>
						<th>제목</th>
						<th>등록일</th>
						<th>삭제처리</th>
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
							<td>
										<c:choose>
											<c:when test="${item.cb_deleted eq 0}">
												<c:url
													value="/member/admin/setDeletedBoard"
													var='deleted_url'>
													<c:param name="cb_no" value="${item.cb_no}" />
												</c:url>
												<a href="${deleted_url}">삭제처리</a>
											</c:when>
											<c:when test="${item.cb_deleted eq 1}">삭제완료</c:when>
										</c:choose>
									</td>
						</tr>
						
					</c:forEach>
				
				</tbody>
			
			</table>
			
			<br>
			
			<a href="<c:url value='/community/writeBoardForm' />">게시글 작성</a>
			
			</div>

		</div>
	
	</section>
	
	<jsp:include page="../../include/footer.jsp" />
	
</body>
</html>