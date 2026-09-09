<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript">

	function modifyAccountForm() {
		console.log('modifyAccountForm()');

	let form = document.modify_account_form;

	if (form.u_phone.value == '') {
		alert('전화번호를 필수로 입력하셔야됩니다.');
		form.u_phone.focus();

	} else {
		form.submit();
	}
	
	}
</script>