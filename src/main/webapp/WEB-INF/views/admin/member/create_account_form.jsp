<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../../include/title.jsp" />

<link href="<c:url value='/resources/css/admin/create_account_form.css' />" rel="stylesheet" type="text/css">

<jsp:include page="../include/create_account_form_js.jsp" />

</head>
<body>

	<jsp:include page="../../include/header.jsp" />
	
	<jsp:include page="../include/nav.jsp" />
	
	<section>
	
		<div id="section_wrap">
			
			<div class="word">
			
				<h3>CREATE ACCOUNT FORM</h3>
			
			</div>
			
			<div class="create_account_form">
			
				<form
					action="<c:url value='/admin/member/createAccountConfirm'/>"
					name="create_account_form"
					method="post">
				
					<input type="text" name="a_id" placeholder="INPUT NEW ADMIN ID"><br>
					<input type="password" name="a_pw" placeholder="INPUT NEW ADMIN PW"><br>
					<input type="text" name="a_phone" placeholder="INPUT NEW ADMIN PHONE"><br>
					<input type="button" value="create account" onclick="createAccountForm();">
					<input type="reset" value="reset">
				
				</form>
			
			</div>
			
		</div>
	
	</section>
	
	<jsp:include page="../../include/footer.jsp" />

</body>
</html>