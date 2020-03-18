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

#totalsaleList {
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
		<p>매출 목록</p>
				<form method="post">
					<table id="totalsaleList" width="100%"
						class="table table-bordered table-hover text-center">
						<thead>
							<tr class="tr_top" height="40px">
								<td>일자</td>
								<td>주문건수</td>
								<td>매출</td>
								<td>적립금</td>
								<td>결제방법</td>
							</tr>
						</thead>
						<c:set var="total" value="0"/>
						<c:forEach items="${totalsaleList }" var="totalList">
							<c:set var="total" value="${total+totalList.total_price }"/>
							<tbody>
								<tr height="40px">
									<td>${totalList.order_date }</td>
									<td>${totalList.order_num }건</td>
									<td>${totalList.total_price }원</td>
									<td>${totalList.coupon }원</td>
									<td>${totalList.payment_way }</td>
								</tr>
							</tbody>
							
						</c:forEach>
						
					</table>
					총 매출 : ${total }원
</body>
</html>