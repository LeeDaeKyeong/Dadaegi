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
	border: 1px white solid;
	margin: auto;
}

#pageList {
	text-align: center;
}

#totalsaleList {
	margin: auto 0;
	border: 1px solid #000000;
	width: 700px;
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
				<form method="post">
					<table id="totalsaleList" width="100%"
						class="table table-bordered table-hover text-center">
						<thead>
							<tr class="tr_top" height="40px">
								<td>주문번호</td>
								<td>적립내역</td>
								<td>구분</td>
								<td>적립금</td>
								<td>적립일자</td>
							</tr>
						</thead>
						<c:set var="total" value="0"/>
						<c:forEach items="${pointSearch }" var="coupon">
							<c:set var="total" value="${total+coupon.coupon_price }"/>
							<tbody>
								<tr height="40px">
									<td>${coupon.order_num }</td>
									<td>${coupon.coupon_content }</td>
									<td>${coupon.inout_coupon }</td>
									<td>${coupon.coupon_price }</td>
									<td>${coupon.coupon_date }</td>
								</tr>
							</tbody>
							
						</c:forEach>
						
					</table>
</body>
</html>