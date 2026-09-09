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
			
				<h3>ADMIN MEMBER LIST</h3>
			
			</div>
			
			<div class="admin_list">
				<table>
					<thead>
						<tr>
							<th>계정</th>
							<th>연락처</th>
							<th>활동 시작일</th>
							<th>승인</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${adminMemberDtos}">
						<tr>
							<td>${item.a_id}</td>
							<td>${item.a_phone}</td>
							<td>${item.a_reg_date}</td>
							<td>
								<c:choose>
									<c:when test="${item.a_approval eq 0}">
										<c:url
											value="/admin/member/setAdminApproval"
											var='approval_url'>
											<c:param name="a_no" value="${item.a_no}" />
											<c:param name="a_approval" value="1" />
										</c:url>
										<a href="${approval_url}">승인처리</a>
									</c:when>
									<c:when test="${item.a_approval eq 1}">승인완료</c:when>
								</c:choose>
							</td>
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