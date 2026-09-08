<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>

	function createAccountForm() {
		console.log("createAccountForm() called");
		
		let form = document.create_account_form;
		
		if (form.a_id === '') {
			alert("INPUT NEW ADMIN ID");
			form.a_id.focus();
			
		} else if (form.a_pw === '') {
			alert("INPUT NEW ADMIN PW");
			form.a_pw.focus();
			
		} else if (form.a_phone === '') {
			alert("INPUT NEW ADMIN PHONE");
			form.a_phone.focus();
			
		} else {
			form.submit();
			
		}
	}

</script>