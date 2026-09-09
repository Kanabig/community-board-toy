<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript">

	function loginForm() {
		console.log('loginForm()');

	let form = document.login_Form;
	if (form.u_id.value == '') {
		alert('아이디를 필수로 입력하셔야됩니다.');
		form.u_id.focus();
		
	} else if (form.u_pw.value == '') {
		alert('비밀번호를 필수로 입력하셔야됩니다.');
		form.u_pw.focus();
		
	} else {
		form.submit();
	}
	
	}
</script>