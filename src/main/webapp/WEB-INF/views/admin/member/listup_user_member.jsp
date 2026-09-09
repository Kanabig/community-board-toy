<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../../include/title.jsp" />

<link href="<c:url value='/resources/css/admin/listup_admins.css' />" rel="stylesheet" type="text/css">

</head>
<body>


	<jsp:include page="../../include/header.jsp" />
		
	<jsp:include page="../include/nav.jsp" />
	
	<section>
	
		<div id="section_wrap">
			
			<div class="word">
			
				<h3>USER MEMBER LIST</h3>
			
			</div>
			
			<div class="user_list">
				<table>
					<thead>
						<tr>
							<th>계정</th>
							<th>연락처</th>
							<th>활동 시작일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${userMemberDtos}">
						<tr>
							<td>${item.u_id}</td>
							<td>${item.u_phone}</td>
							<td>${item.u_reg_date}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>
	
	</section>
	
	<jsp:include page="../../include/footer.jsp" />

</body>
</html>