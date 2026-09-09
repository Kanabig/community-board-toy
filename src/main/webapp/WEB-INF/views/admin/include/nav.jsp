<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="<c:url value='/resources/css/admin/include/nav.css' />" rel="stylesheet" type="text/css">

<nav>

	<div id="nav_wrap">
	
		<%
			Object object = session.getAttribute("loginedAdminMemberId");
		
			if (object != null) {
				String loginedAdminMemberId = String.valueOf(object);
		%>		
		
		<div class="menu">
			<ul>
				<li><a href="<c:url value='/admin/member/logoutConfirm' />">로그아웃</a></li>
				<li><a href="<c:url value='/admin/member/listupAdminMember' />">관리자목록</a></li>
				<li><a href="<c:url value='/admin/member/listupUserMember' />">사용자목록</a></li>
				<li><a href="<c:url value='/community/adminListBoard' />">관리자게시판</a></li>
			</ul>
		</div>
		
		<%
			} else {
		%>
		
		<div class="menu">
			<ul>
				<li><a href="<c:url value='/admin/member/loginForm' />">로그인</a></li>
				<li><a href="<c:url value='/admin/member/createAccountForm' />">회원가입</a></li>
			</ul>
		</div>
		
		<%
			}
		%>
		
	</div>

</nav>