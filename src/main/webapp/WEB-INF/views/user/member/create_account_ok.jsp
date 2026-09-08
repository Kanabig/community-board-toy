<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<jsp:include page="../../include/header.jsp" />
	
	<jsp:include page="../include/nav.jsp" />

	<section>
	
		<div class="word">
			<h3>CREATE ACCOUNT SUCCESS!!</h3>
		</div>
		
		<div class="others">
				<a href="<c:url value='/user/member/createAccountForm'/>">create account</a>
				<a href="<c:url value='#none'/>">login</a>
			</div>
	
	</section>

</body>
</html>