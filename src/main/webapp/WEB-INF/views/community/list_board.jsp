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

	<section>
	
		<div class="community_layout">
	
			<div class="side_ad">
			
				<div class="ad_text">광고</div>
				
				<a href="<c:url value='/community/listBoard' />">
					<img src="<c:url value='/resources/img/community/jeongho_banner.png' />" alt="정호 커뮤니티 배너">
				</a>
	
			</div>
			<div id="section_wrap">
			
				<div class="word">
					<h3>게시글 목록</h3>
				</div>
			
				<div class="search">
				
					<form action="<c:url value='/community/searchBoards' />" method="get">
					
						<input type="text" name="keyword" value="${keyword}" placeholder="검색어를 입력하세요.">
						<input type="submit" value="검색">
						<a href="<c:url value='/community/listBoard' />">전체목록</a>
					
					</form>
					
				</div>	
				<div class="board_list">
			
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
				
				</div>
				
				<div class="paging">
	
					<c:if test="${currentPage > 1}">
						<a href="<c:url value='/community/listBoard'>
							<c:param name='page' value='${currentPage - 1}' />
						</c:url>">
							이전
						</a>
					</c:if>
				
					<c:forEach begin="1" end="${totalPage}" var="pageNum">
				
						<a class="${currentPage == pageNum ? 'active' : ''}"
						   href="<c:url value='/community/listBoard'>
							<c:param name='page' value='${pageNum}' />
						   </c:url>">${pageNum}</a>
				
					</c:forEach>
				
					<c:if test="${currentPage < totalPage}">
						<a href="<c:url value='/community/listBoard'>
							<c:param name='page' value='${currentPage + 1}' />
						</c:url>">다음</a>
					</c:if>
				
				</div>
				
				<div class="buttons">
		            <a href="<c:url value='/community/writeBoardForm' />">게시글 작성</a>
		        </div>
		        
			</div>
			
		</div>
		
	</section>
	
</body>
</html>