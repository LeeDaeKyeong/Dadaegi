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
<script>
	function changeSelect() {
		var changeSelect = document.getElementById("order_status");
		var fm = document.MyForm;
		fm.order_status.value = fm.getVal.options[fm.getVal.selectedIndex].text;
	}
</script>
<body>
	<form id="left">
		<h2>
			<img src="images/cake.png"> 구매자정보
		</h2>
		<table>
			<tr>
				<td id="sub">id</td>
				<td colspan="3">${member.member_id }</td>
			</tr>
			<tr>
				<td id="sub">구매자명</td>
				<td colspan="3">${member.member_name }</td>
			</tr>
			<tr>
				<td id="sub">연락처</td>
				<td colspan="3">${member.member_phone }</td>
			</tr>
			<tr>
				<td id="sub">주소</td>
				<td colspan="3">${member.member_zip}${member.member_addr}
					${member.member_addr_detail }</td>
			</tr>
			<tr>
				<td id="sub">이메일</td>
				<td colspan="3">${member.member_email }</td>
			</tr>
			<tr>
				<td id="sub">생년월일</td>
				<td width="100px">${member.member_birth }</td>
				<td id="sub">성별</td>
				<td width="100px"><br> <input type="radio"
					name="member_gender" value="남" id="member_gender"
					${member.member_gender eq '남' ? 'checked' : '' }>남 <br>
					<input type="radio" name="member_gender" value="여"
					id="member_gender" ${member.member_gender eq '여' ? 'checked' : '' }>여</td>
			</tr>
			<tr>
				<td id="sub">요구사항</td>
				<td colspan="3">${orderDetailList.get(0).demand }</td>
			</tr>
		</table>
	</form>
	<form id="center" action="ordermod.sa">
		<input type="hidden" name="order_num"
			value="${orderDetailList.get(0).order_num }" /> <input type="hidden"
			name="member_id" value="${member.member_id }" />
		<h2>
			<img src="images/cupcake.png"> 주문정보
		</h2>
		<table>
			<c:choose>
				<c:when test="${orderDetailList.get(0).order_way eq '온라인' }">
					<tr>
						<td id="sub">주문상태</td>
						<td><select name="order_status">
								<option value="주문대기"
									${orderDetailList.get(0).order_status eq '주문대기' ? 'selected' : '' }>주문대기</option>
								<option value="주문완료"
									${orderDetailList.get(0).order_status eq '주문완료' ? 'selected' : '' }>주문완료</option>
								<option value="준비중"
									${orderDetailList.get(0).order_status eq '준비중' ? 'selected' : '' }>준비중</option>
								<option value="배달중"
									${orderDetailList.get(0).order_status eq '배달중' ? 'selected' : '' }>배달중</option>
								<option value="배달완료"
									${orderDetailList.get(0).order_status eq '배달완료' ? 'selected' : '' }>배달완료</option>
								<option value="주문취소"
									${orderDetailList.get(0).order_status eq '주문취소' ? 'selected' : '' }>주문취소</option>
						</select><input type="submit" value="주문 수정"></td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td id="sub">주문상태</td>
						<td><select name="order_status">
								<option value="주문대기"
									${orderDetailList.get(0).order_status eq '주문대기' ? 'selected' : '' }>주문대기</option>
								<option value="주문완료"
									${orderDetailList.get(0).order_status eq '주문완료' ? 'selected' : '' }>주문완료</option>
								<option value="준비중"
									${orderDetailList.get(0).order_status eq '준비중' ? 'selected' : '' }>준비중</option>
								<option value="전달완료"
									${orderDetailList.get(0).order_status eq '전달완료' ? 'selected' : '' }>전달완료</option>
								<option value="주문취소"
									${orderDetailList.get(0).order_status eq '주문취소' ? 'selected' : '' }>주문취소</option>
						</select><input type="submit" value="주문 수정"></td>
					</tr>
				</c:otherwise>
			</c:choose>
			<tr>
				<td id="sub">주문번호</td>
				<td>${orderDetailList.get(0).order_num }</td>
			</tr>
			<tr>
				<td id="sub">주문일자</td>
				<td>${orderDetailList.get(0).order_date }</td>
			</tr>
			<tr>
				<td id="sub">주문방법</td>
				<td>${orderDetailList.get(0).order_way }</td>
			</tr>
			<tr>
				<td colspan="2">
					<table id="subtable">
						<c:forEach items="${orderDetailList }" var="odList">
							<tr>
								<td id="sub"><img src="images/icon.jpg"></td>
								<td>${odList.product_name }</td>
								<td id="sub"><img src="images/count.jpg"></td>
								<td>${odList.product_quantity }개</td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>

		</table>
	</form>
	<form id="right" action="paymentmod.sa">
		<input type="hidden" name="order_num"
			value="${orderDetailList.get(0).order_num }" /> <input type="hidden"
			name="member_id" value="${member.member_id }" />
		<h2>
			<img src="images/cupcake (1).png"> 요금정보
		</h2>
		<table>
			<tr>
				<td id="sub">결제상태</td>
				<td><select name="payment_status">
						<option value="결제대기"
							${orderDetailList.get(0).payment_status eq '결제대기' ? 'selected' : '' }>결제대기</option>
						<option value="결제완료"
							${orderDetailList.get(0).payment_status eq '결제완료' ? 'selected' : '' }>결제완료</option>
						<option value="결제취소"
							${orderDetailList.get(0).payment_status eq '결제취소' ? 'selected' : '' }>결제취소</option>
				</select><input type="submit" value="결제수정"></td>
			</tr>
			<tr>
				<td id="sub">결제일자</td>
				<td>${orderDetailList.get(0).order_date }</td>
			</tr>
			<tr>
				<td id="sub">실 금액</td>
				<td>${orderDetailList.get(0).total_price }원</td>
			</tr>
			<tr>
				<td id="sub">적립금사용</td>
				<td>${orderDetailList.get(0).coupon }원</td>
			</tr>
			<tr>
				<td id="sub">결제수단</td>
				<td>${orderDetailList.get(0).payment_way }</td>
			</tr>
			<tr>
				<td id="sub">계산금액</td>
				<td>${orderDetailList.get(0).total_price-orderDetailList.get(0).coupon }원</td>
			</tr>
		</table>
	</form>
</body>
</html>