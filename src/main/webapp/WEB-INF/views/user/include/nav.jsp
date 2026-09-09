<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="<c:url value='/resources/css/user/include/nav.css'/>"
      rel="stylesheet"
      type="text/css">

<nav>

	<div id="nav_wrap">

		<%
			Object object = session.getAttribute("loginedUserMemberId");

			if (object == null) {
		%>

			<div class="menu">

				<ul>
					<li><a href="<c:url value='/user/member/createAccountForm'/>">회원가입</a></li>
					<li><a href="<c:url value='/user/member/loginForm'/>">로그인</a></li>
					<li><a href="<c:url value='/community/listBoard'/>">게시판</a></li>

					<li><a href="<c:url value='/admin/member/loginForm'/>">관리자</a></li>
				</ul>

			</div>
		<%
			} else {
		%>
			<div class="menu">

				<ul>
					<li><a href="<c:url value='/user/member/logoutConfirm'/>">로그아웃</a></li>
					<li><a href="<c:url value='/user/member/modifyAccountForm'/>">계정수정</a></li>
					<li><a href="<c:url value='/community/listBoard'/>">게시판</a></li>
					<li><a href="<c:url value='/community/writeBoardForm'/>">글쓰기</a></li>
					<li><a href="<c:url value='/admin/member/loginForm'/>">관리자</a></li>
				</ul>

			</div>

		<%
			}
		%>

		<div class="search">

			<form action="<c:url value='/community/searchBoards'/>" method="get">
				<input type="text" name="keyword" placeholder="게시글을 검색하세요.">
				<input type="submit" value="search">
			</form>

		</div>

	</div>

</nav>