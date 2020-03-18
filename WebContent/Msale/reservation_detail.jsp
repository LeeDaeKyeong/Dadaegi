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
	width: 29.17%;
	height: auto;
	float: left;
	margin-right: 1.5625%;
	margin-bottom: 20px;
	margin-top: 20px;
	padding: 0.5%;
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
	background-color: pink;
	width: 100px;
	text-align: center;
}

body {
	font-family: 'Malgun Gothic';
	font-size: 9pt;
}

form {
	
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
	width: 30px;
	height: 40px;
}
</style>
</head>
<body>
	<form id="left">
		<h2>
			<img src="images/cake.png"> 예약자정보
		</h2>
		<table>
			<tr>
				<td id="sub">id</td>
				<td colspan="3">${member.member_id }</td>
			</tr>
			<tr>
				<td id="sub">예약자명</td>
				<td colspan="3">${member.member_name }</td>
			</tr>
			<tr>
				<td id="sub">연락처</td>
				<td colspan="3">${member.member_phone }</td>
			</tr>
			<tr>
				<td id="sub">이메일</td>
				<td colspan="3">${member.member_email }</td>
			</tr>
			<tr>
				<td id="sub">생년월일</td>
				<td width="100px">${member.member_birth }</td>
				<td id="sub">성별</td>
				<td width="100px"><input type="radio" name="member_gender"
					value="남" id="member_gender"
					${member.member_gender eq '남' ? 'checked' : '' }>남 <br>
					<input type="radio" name="member_gender" value="여"
					id="member_gender" ${member.member_gender eq '여' ? 'checked' : '' }>여</td>
			</tr>
			<tr>
				<td id="sub">요구사항</td>
				<td colspan="3">${reservationDetailList.get(0).demand }</td>
			</tr>
		</table>
	</form>
	<form id="center" action="reservationmod.sa">
		<input type="hidden" name="reservation_num"
			value="${reservationDetailList.get(0).reservation_num }" /> <input
			type="hidden" name="member_id" value="${member.member_id }" />
		<h2>
			<img src="images/cupcake.png"> 예약정보
		</h2>
		<table>
			<tr>
				<td id="sub">예약상태</td>
				<td><select name="reservation_status">
						<option value="예약대기"
							${reservationDetailList.get(0).reservation_status eq '예약대기' ? 'selected' : '' }>예약대기</option>
						<option value="예약완료"
							${reservationDetailList.get(0).reservation_status eq '예약완료' ? 'selected' : '' }>예약완료</option>
						<option value="예약취소"
							${reservationDetailList.get(0).reservation_status eq '예약취소' ? 'selected' : '' }>예약취소</option>
				</select><input type="submit" value="예약 수정"></td>
			</tr>
			<tr>
				<td id="sub">예약번호</td>
				<td>${reservationDetailList.get(0).reservation_num }</td>
			</tr>
			<tr>
				<td id="sub">예약일자</td>
				<td>${reservationDetailList.get(0).reservation_date }</td>
			</tr>
			<tr>
				<td colspan="2">
					<table id="subtable">
						<c:forEach items="${reservationDetailList }" var="rdList">
							<tr>
								<td id="sub"><img src="images/icon.jpg"></td>
								<td>${rdList.product_name }</td>
								<td id="sub"><img src="images/count.jpg"></td>
								<td>${rdList.product_quantity }개</td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
	</form>
	<form id="right" action="reservationpaymod.sa">
		<input type="hidden" name="reservation_num"
			value="${reservationDetailList.get(0).reservation_num }" /> <input
			type="hidden" name="member_id" value="${member.member_id }" />
		<h2>
			<img src="images/cupcake (1).png"> 요금정보
		</h2>
		<table>
			<tr>
				<td id="sub">결제상태</td>
				<td><select name="payment_status">
						<option value="결제대기"
							${reservationDetailList.get(0).payment_status eq '결제대기' ? 'selected' : '' }>결제대기</option>
						<option value="결제완료"
							${reservationDetailList.get(0).payment_status eq '결제완료' ? 'selected' : '' }>결제완료</option>
						<option value="결제취소"
							${reservationDetailList.get(0).payment_status eq '결제취소' ? 'selected' : '' }>결제취소</option>
				</select><input type="submit" value="결제수정"></td>
			</tr>
			<tr>
				<td id="sub">실 금액</td>
				<td>${reservationDetailList.get(0).total_price }원</td>
			</tr>
			<tr>
				<td id="sub">적립금사용</td>
				<td>${reservationDetailList.get(0).coupon }원</td>
			</tr>
			<tr>
				<td id="sub">결제수단</td>
				<td>${reservationDetailList.get(0).payment_way }</td>
			</tr>
			<tr>
				<td id="sub">계산금액</td>
				<td>${reservationDetailList.get(0).total_price-reservationDetailList.get(0).coupon }원</td>
			</tr>
		</table>
	</form>
</body>
</html>