<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>

	function loginForm() {
		console.log("loginForm() called");
		
		let form = document.login_form;
		
		if (form.a_id === '') {
			alert("INPUT NEW ADMIN ID");
			form.a_id.focus();
			
		} else if (form.a_pw === '') {
			alert("INPUT NEW ADMIN PW");
			form.a_pw.focus();
			
		} else {
			form.submit();
			
		}
	}

</script>