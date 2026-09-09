<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../../include/title.jsp" />

<link href="<c:url value='/resources/css/user/modify_account_form.css'/>" rel="stylesheet" type="text/css">

<jsp:include page="../include/modify_account_form_js.jsp" />

</head>
<body>

	<jsp:include page="../../include/header.jsp" />
	
	<jsp:include page="../include/nav.jsp" />

	<section>
	
	<div id="section_wrap">
	
		<div class="word">
		
			<h3>MODIFY ACCOUNT FORM</h3>
			
		</div>
		
		<div class="modify_account_form">
		
			<form
                    action="<c:url value='/user/member/modifyAccountConfirm'/>"
                    name="modify_account_form"
                    method="post">

                  
                    <input type="hidden"
                           name="u_no"
                           value="${loginedUserMemberDto.u_no}">

                 
                    <input type="text"
                           value="${loginedUserMemberDto.u_id}"
                           readonly>
                    <br>

             
                    <input type="text"
                           name="u_phone"
                           value="${loginedUserMemberDto.u_phone}"
                           placeholder="비밀번호를 입력하세요.">
                    <br>

                    <input type="button"
                           value="수정" onclick="modifyAccountForm()">

                    <input type="reset"
                           value="reset">
			
			</form>
		
		</div>
	
	</div>
	
	
	</section>

	
	<jsp:include page="../../include/footer.jsp" />

</body>
</html>