<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
form {
	width: auto;
	height: auto;
	margin-right: 1.5625%;
	margin-bottom: 20px;
	margin-top: 20px;
	padding: 3%;
	border: 1px dotted #333;
	border-radius: 10px;
}

table:first-child {
	margin-left: 2.083%
}

table h2 {
	padding-left: 30px;
}

tr {
	margin: 10px;
	height: 50px;
}

#sub {
	background-color: lightgray;
	width: 100px;
	text-align: center;
}

body {
	font-family: 'Malgun Gothic';
	font-size: 9pt;
}

#bottom {
	border: none;
	clear: both;
	text-align: center;
}

a {
	text-decoration: none;
}

#subtable {
	padding: 0px;
	margin: 0px;;
}

#subtable td {
	background-color: white;
}

img {
	width: 40px;
	height: 40px;
}

#commandCell {
	text-align: center;
}
</style>
</head>

<body>
	<form id="pointDetail">
		<h2>적립금 내역 상세</h2>
		<table>
			<tr>
				<td id="sub">적립금 번호</td>
				<td colspan="3">${coupon.coupon_index }</td>
			</tr>
			<tr>
				<td id="sub">회원 아이디</td>
				<td colspan="3">${coupon.member_id }</td>
			</tr>
			<tr>
				<td id="sub">적립 일자</td>
				<td colspan="3">${coupon.coupon_date }</td>
			</tr>
			<tr>
				<c:choose>
					<c:when test="${coupon.order_num eq 0 }">
						<td id="sub">예약번호</td>
						<td colspan="3">${coupon.reservation_num }</td>
					</c:when>
					<c:otherwise>
						<td id="sub">주문번호</td>
						<td colspan="3">${coupon.order_num }</td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<td id="sub">주문금액</td>
				<td colspan="3">${coupon.total_price }</td>
			</tr>
			<tr>
				<td id="sub">적립금액</td>
				<td colspan="3">${coupon.coupon_price }</td>
			</tr>
		</table>
		<section id="commandCell">
			<input type="button" value="닫기" onClick="window.close()" />
		</section>
	</form>
</body>
</html>