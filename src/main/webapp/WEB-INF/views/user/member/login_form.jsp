<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../../include/title.jsp" />

<link href="<c:url value='/resources/css/user/login_form.css'/>" rel="stylesheet" type="text/css">

<jsp:include page="../include/login_form_js.jsp" />

</head>
<body>

	<jsp:include page="../../include/header.jsp" />
	
	<jsp:include page="../include/nav.jsp" />

	<section>
	
	<div id="section_wrap">
	
		<div class="word">
			<h3>LOGIN FORM</h3>
		</div>
		
		<div class="login_form">
		
			<form
				action="<c:url value='/user/member/loginConfirm' />"
				name="login_Form"
				method="post">
			
			<input type="text" name="u_id" placeholder="아이디를 입력하세요"><br>
			<input type="password" name="u_pw" placeholder="비밀번호를 입력하세요"><br>
			
			<input type="button" value="로그인" onclick="loginForm()">
			<input type="reset" value="초기화">
			
			</form>
		
		</div>
	
	</div>
	
	
	</section>

	<jsp:include page="../../include/footer.jsp" />
	

</body>
</html>