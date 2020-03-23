<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.Cup"%>
<%@ page import="vo.Cart"%>
<%@ page import="vo.Order_detail"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	function check() {
		var formRa = document.form;
		//첫번째 라디오 버튼을 선택한 경우
		if (formRa.way[0].checked == true) {
			//현재 폼의 action 값을 menu_1.html이라는 파일로 만든다
			formRa.action = "cupDirectOrder.cup";
		}
		//두번째 라디오 버튼을 선택한 경우
		else if (formRa.way[1].checked == true) {
			formRa.action = "cupDirectOrder.cup";
		} else {
			formRa.action = "#";
		}
		formRa.submit();
	}

	var product_price;
	var product_quantity;

	function init() {
		product_price = document.form.product_price.value;
		product_quantity = document.form.product_quantity.value;
		document.form.sum.value = product_price;
		change();
	}

	function add() {
		hm = document.form.product_quantity;
		sum = document.form.sum;
		hm.value++;

		sum.value = parseInt(hm.value) * product_price;
	}

	function del() {
		hm = document.form.product_quantity;
		sum = document.form.sum;
		if (hm.value > 1) {
			hm.value--;
			sum.value = parseInt(hm.value) * product_price;
		}
	}

	function change() {
		hm = document.form.product_quantity;
		sum = document.form.sum;

		if (hm.value < 0) {
			hm.value = 0;
		}
		sum.value = parseInt(hm.value) * product_price;
	}

</script>
<style type="text/css">
#listForm {
	width: 640px;
	height: auto;
	border: 1px solid white;
	margin: auto;
}

h2 {
	text-align: center;
}

img {
	width: 280px;
	height: 280px;
	border: none;
}

#content_main {
	height: 300px;
}

#content_left {
	height: 300px;
	float: left;
}

#content_right {
	width: 340px;
	float: left;
}

#desc {
	height: 170px;
	background: #F5A9A9;
}

h3 {
	text-align: left;
}

#tr_top {
	background: #F5A9A9;
	text-align: center;
}

</style>
</head>
<body onload="init();">
	<section id="listForm">
		<h2>${cup.product_name }</h2>

		<section id="content_main">
			<section id="content_left">
				<img
					src="${pageContext.request.contextPath }/images/${cup.product_image }" />
			</section>
			<section id="content_right">
				<br> <b>상품명 : </b>${cup.product_name }<br> <br>
				<b>가격 : </b>${cup.product_price }원<br> <br>
				<hr align="center" width="250px">
				<br>

				<form name="form" method="get">

					수량 : <input type=hidden name="product_price"
						value="${cup.product_price }"> <input type="text"
						name="product_quantity" value="1" size="3" onchange="change();">
					<input type="button" value=" + " onclick="add();"> <input
						type="button" value=" - " onclick="del();"><br> 금액 :
					<input type="text" name="sum" size="11" readonly>원 <br>
					<br> 
					<input type="hidden" name="product_name" value="${cup.product_name }" /> 
					<a href="javascript:form.action='${pageContext.request.contextPath }/cupCartAdd.cup?cup_index=${cup.cup_index }';form.submit()"
					style="color: white; font-size: 1.3em; font-weight: bold; background: #FFA7A7;">장바구니</a>&nbsp;&nbsp;
					<a href="cupList.cup" style="color: white; font-size: 1.3em; font-weight: bold; background: #FFA7A7;">쇼핑 계속하기</a>

					<hr align="center" width="250px">
					<input type="radio" name="way" value="online" checked="checked">딜리버리
					<input type="radio" name="way" value="offline">현장수령 <input
						type="radio" name="way" value="reservation">예약주문 <br>
					<a href="javascript:check()"
						style="color: white; font-size: 1.3em; font-weight: bold; background: #FFA7A7;">바로구매</a><br>
				</form>


			</section>
		</section>

		<p id="desc">
			<b>상품안내 </b><br>${cup.product_content }<br>
		<h3>상품문의</h3>
		<div id="commandCell" align="right">
			<button type="button" id="wbutton"
				onclick="window.open('./question/questionWriteForm.qu?item_code=V006','','width=500, height=400')">문의하기</button>
		</div>

		<table cellspacing="0" cellpadding="0">
			<tr id="tr_top" height="20px">
				<td width="50px">번호</td>
				<td width="200px">제목</td>
				<td width="100px">작성자</td>
				<td width="100px">작성일</td>
				<td>조회수</td>
			</tr>
			<tr>

			</tr>
		</table>

		<h3>상품후기</h3>
		<div id="commandCell" align="right">
			<button type="button" id="wbutton"
				onclick="window.open('./question/questionWriteForm.qu?item_code=V006','','width=500, height=400')">후기쓰기</button>
		</div>

	</section>
</body>
</html>