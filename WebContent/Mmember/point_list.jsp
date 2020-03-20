<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
#listForm {
	width: 100%;
	border: 1px pink solid;
	margin: auto;
}

#pageList {
	text-align: center;
}

#memberPointList {
	margin: auto 0;
	border: 1px solid #000000;
	width: 1000px;
	margin: auto;
	text-align: center;
}

.tr_top {
	background-color: #F6F6F6;
	text-align: center;
}
</style>
<body onload="init()">
	<section id="listForm">
		<p>적립금 목록</p>
		<form method="post">
			<table id="memberPointList" width="100%"
				class="table table-bordered table-hover text-center">
				<thead>
					<tr class="tr_top" height="40px">
						<td>적립일자</td>
						<td>적립내역</td>
						<td>적립금액</td>
						<td>회원ID</td>
						<td>회원명</td>
						<td></td>
						<td></td>
					</tr>
				</thead>
				<c:set var="total" value="0" />

				<c:forEach items="${memberPointList }" var="pointList">
					<input type="hidden" name="coupon_index"
						value="${pointList.coupon_index }" />
					<c:set var="total" value="${total+pointList.coupon_price }" />
					<tbody>
						<tr height="40px">
							<td>${pointList.coupon_date }</td>
							<td><c:choose>
									<c:when
										test="${pointList.order_num eq 0 and pointList.reservation_num eq 0 }">
									${pointList.coupon_content }
									</c:when>
									<c:when test="${pointList.reservation_num eq 0}">
									${pointList.coupon_content }(${pointList.order_num })
									</c:when>
									<c:when test="${pointList.order_num eq 0}">
									${pointList.coupon_content}(${pointList.reservation_num})
									</c:when>

									<c:otherwise>

									</c:otherwise>
								</c:choose></td>
							<td>${pointList.coupon_price }원</td>
							<td>${pointList.member_id }</td>
							<td>${pointList.member_name }</td>
							<c:choose>
								<c:when test="${pointList.coupon_content eq '신규회원 적립금' }">
									<td>-</td>
								</c:when>
								<c:otherwise>
									<td
										onClick="window.open('pointDetail.mem?coupon_index=${pointList.coupon_index}&order_num=${pointList.order_num}&reservation_num=${pointList.reservation_num }','new','width=550px,height=500px,location=no,status=no,scrollbars=no');"><input
										type="button" value="상세보기" /></td>
								</c:otherwise>
							</c:choose>
							<td
								onClick="location.href='pointDelete.mem?member_id=${pointList.member_id}&coupon_index=${pointList.coupon_index }'"><input
								type="button" value="삭제" /></td>
						</tr>
					</tbody>

				</c:forEach>

			</table>
			총 적립금 : ${total }원
</body>
</html>