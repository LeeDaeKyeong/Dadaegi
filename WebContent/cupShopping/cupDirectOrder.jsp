<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="vo.Cup"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
table {
	width: 70%;
	border-collapse: collapse;
}

.aa td {
	border-bottom: 1px solid #444444;
	padding: 2px;
}

.tr_top {
	background-color: #F5A9A9;
}
</style>
<script>
function depointf(f,v,t){
	var depoint = f.depoint.value;
	if(isNaN(depoint)){
		alert('잘못 입력하셨습니다.');
		f.depoint.value="";
		f.depoint.focus();
	}else if(parseInt(depoint)>parseInt(v)){
		alert('사용 가능 포인트 초과');
		f.depoint.value="";
		f.depoint.focus();
	}else{
		document.getElementById("usepoint").innerHTML = depoint;
		document.getElementById("allprice").innerHTML = parseInt(f.totalMoney.value)-parseInt(depoint);
	}
}
	function sample6_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var fullAddr = ''; // 최종 주소 변수
						var extraAddr = ''; // 조합형 주소 변수

						// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							fullAddr = data.roadAddress;

						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							fullAddr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
						if (data.userSelectedType === 'R') {
							//법정동명이 있을 경우 추가한다.
							if (data.bname !== '') {
								extraAddr += data.bname;
							}
							// 건물명이 있을 경우 추가한다.
							if (data.buildingName !== '') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
							fullAddr += (extraAddr !== '' ? ' (' + extraAddr
									+ ')' : '');
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('userAddr1').value = data.zonecode; //5자리 새우편번호 사용
						document.getElementById('userAddr2').value = fullAddr;

						// 커서를 상세주소 필드로 이동한다.
						document.getElementById('userAddr3').focus();
					}
				}).open();
	}
</script>
<body>
	<div class="pageform">
		<h3>결제</h3>
		<hr color="#F5A9A9" size="5">
		
		<div class="mypage">
			<form action="orderComplate.cup" name="orderform" method="post"
				onsubmit="return chkForm(this)">
				<div id="order_info">
					<div id="grade">
						<b id="grade_deco">|</b> 결제상품
					</div>
					<table cellspacing="0" cellpadding="0" id="order_sheet" class="aa">
						<tr id="order_top_menu" class="tr_top">
							<td id="leftalign">상품명</td>
							<td>단가</td>
							<td>수량</td>
							<td>총 가격</td>
							<td>적립</td>
						</tr>

						<tr>
							<td id="leftalign">${product_name }</td>
							<td>${param.product_price }원</td>
							<td>${param.product_quantity }개</td>
							<td>${(param.product_price)*(param.product_quantity) }원</td>
							<td>--점 <input type="hidden" id="od_item_code"
								name="od_item_code" value="${cup.cart_index }"> <input
								type="hidden" id="od_item_name" name="od_item_name"
								value="${cup.product_name }"> <input type="hidden"
								id="od_price" name="od_price" value="${cup.product_price }">
								<input type="hidden" id="order_num" name="order_num" value="${order_page.order_num }" >
								
								<jsp:useBean id="toDay" class="java.util.Date" />
								<fmt:formatDate value='${toDay}' pattern='yyyy-MM-dd' var="nowDate"/>
								<input type="hidden" id="payment_date" name="payment_date" value="${toDay }" >
								<input type="hidden" id="payment_status" name="payment_status" value="주문완료" >
							</td>
						</tr>
					</table>


					<input type="hidden" id="parcel" name="parcel" value="3000" /> <br>
					<div id="grade">
						<b id="grade_deco">|</b>포인트 사용
					</div>
					<div id="point" style="background-color: #fff; padding: 10px;">
						사용 가능 포인트 <b>1032</b> 점 중 <input type="text" id="coupon"
							name="coupon" size="5" value="0" />
						<button type="button" onClick="depointf(this.form,1032)"
							id="wbutton">사용</button>
					</div>
					<p class="right">
						<font size="3em">총 &nbsp;${(param.product_price)*(param.product_quantity) }원</font><br>
						<input type="hidden" id="total_price" name="total_price"
							value="12000"> <font size="2em">포인트 사용 <font
							color="red" id="usepoint"></font>원
						</font><br> <br> <font size="4em"><b>총 결제금액 <b
								id="grade_deco"> <span id="allprice">${(param.product_price)*(param.product_quantity) }</span></b>원
						</b></font>
					</p>
				</div>


				<br>
				<div id="grade">
					<b id="grade_deco">|</b>배송지 정보
				</div>
				<table class="mytable" cellspacing="0" cellpadding="0">
					<tr>
						<td id="td_left"><label for="userName">주문인</label></td>
						<td>${member.member_name }</td>
					</tr>
					<tr>
						<td id="td_left"><label for="receiver">받는 사람</label></td>
						<td><input type="text" id="receiver" name="receiver"
							value=${member.member_name }></td>
					</tr>
					<tr>
						<td id="td_left"><label for="userID">연락처</label></td>
						<td><input type="text" id="phone" name="phone"
							value=${member.member_phone }></td>
					</tr>
					<tr>
						<td id="td_left"><label for="userID">이메일</label></td>
						<td><input type="text" id="email" name="email"
							value=${member.member_email }></td>
					</tr>
					<tr>
						<td rowspan="3" id="td_left"><label for="userID">주소</label></td>
						<td><input type="text" name="userAddr1" id="userAddr1"
							size="7" value=${member.member_zip } />
							<button type="button" onclick="sample6_execDaumPostcode()"
								id="gbutton" style="width: 70px;">주소검색</button></td>
					</tr>
					<tr>
						<td><input type="text" name="userAddr2" id="userAddr2"
							value="${member.member_addr }" size="40"></td>
					</tr>
					<tr>
						<td><input type="text" name="userAddr3" id="userAddr3"
							value="${member.member_addr_detail }" size="40"> <script
								src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
						</td>
					</tr>
					<tr>
						<td id="td_left"><label for="userID">추가 요구사항</label></td>
						<td><input type="text" id="demand" name="demand" size="50"></td>
					</tr>
				</table>


				<br>
				<div id="grade">
					<b id="grade_deco">|</b>결제방법
				</div>

				<div id="paymentform">
					<input type="radio" name="payment" value="계좌이체" checked="checked"
						id="payment" />&nbsp;계좌이체&nbsp; &nbsp;&nbsp;&nbsp; <input
						type="radio" name="payment" value="무통장입금">&nbsp;무통장입금&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="payment" value="신용카드">&nbsp;신용카드&nbsp;
					<hr color="#F5A9A9">
				</div>
				
				
				<br> <br>
				<a href="javascript:orderform.submit()">결제</a>
				<button id="bbutton" type="submit">결제</button>
				<button id="sbutton" type="button" onclick="location.href='cupCartList.cup'">돌아가기</button>
			</form>
		</div>
	</div>

</body>
</html>