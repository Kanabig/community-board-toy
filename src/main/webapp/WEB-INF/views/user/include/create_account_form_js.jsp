<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript">

	function createAccountForm() {
		console.log('createAccounForm()');

	let form = document.create_account_form;
	if (form.u_id.value == '') {
		alert('아이디를 필수로 입력하셔야됩니다.');
		form.u_id.focus();
		
	} else if (form.u_pw.value == '') {
		alert('비밀번호를 필수로 입력하셔야됩니다.');
		form.u_pw.focus();
		
	} else if (form.u_pw.value != form.u_pw_again.value) {
		alert('입력하신 비밀번호와 일치해야합니다');
		form.u_pw_again.focus();

	} else if (form.u_phone.value == '') {
		alert('입력하신 비밀번호와 일치해야합니다');
		form.u_phone.focus();

	} else {
		form.submit();
	}
	
	}
</script>