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
	var count1 = 0;

	function show_content1(v) {
		var name = "re_content" + v;
		var name2 = "rere_content" + v;
		if (document.getElementById(name).style.display == "none") {
			document.getElementById(name).style.display = "table-row";
			if (document.getElementById(name2) != null)
				document.getElementById(name2).style.display = "table-row";
			count1++;
			return;
		} else if (document.getElementById(name).style.display == "table-row") {
			document.getElementById(name).style.display = "none";
			if (document.getElementById(name2) != null)
				document.getElementById(name2).style.display = "none";
			count1--;
			return;
		}

	}

	function check() {
		var form = document.form1;
		//첫번째 라디오 버튼을 선택한 경우
		if (form.way[0].checked == true) {
			//현재 폼의 action 값을 menu_1.html이라는 파일로 만든다
			form.action = "cupDirectOrder.cup";
		}
		//두번째 라디오 버튼을 선택한 경우
		else if (form.way[1].checked == true) {
			form.action = "cupDirectOrder.cup";
		} else {
			form.action = "#";
		}
		form.submit();
	}
	
	function goto_url(act) {
		document.itemform.action = act;
		var product_quantity = document.getElementById("product_quantity").value;
		var stock = document.getElementById("stock").value;
		var reg_qty = /^[1-9]{1}$|^[1-4]{1}[0-9]{1}$|^50$/;
		if (!reg_qty.test(product_quantity)) {
			alert("1~50의 숫자만 가능합니다.");
			document.product_quantity.value="";
			document.product_quantity.focus();
			return false;
		}
		if (parseInt(product_quantity)>parseInt(stock)) {
			alert("주문 가능 개수 초과\n"+stock+"개 이하 주문가능");
			document.product_quantity.value="";
			document.product_quantity.focus();
			return false;
		}
		document.itemform.submit();
	}

var qnt;
function qnt(f) {
	qnt = $('#product_quantity').val();
//	alert(qnt);
}

function cart() {
//	alert(qnt);
	location.href="cupCartAdd.cup?cup_index=${cup.cup_index }&product_quantity="+qnt;
	
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

#commandList {
	text-align: center;
}

#desc {
	height: 170px;
	background: #F5A9A9;
}

h3 {
	text-align: left;
}
</style>
</head>
<body>
	<section id="listForm">
		<h2>${cup.product_name }의 상세정보</h2>

		<section id="content_main">
			<section id="content_left">
				<img
					src="${pageContext.request.contextPath }/images/${cup.product_image }" />
			</section>
			<section id="content_right">
				<br>
				<br> <b>상품명 : </b>${cup.product_name }<br>
				<br> <b>가격 : </b>${cup.product_price }원<br>
				<br>
				<hr align="center" width="250px">
				<br> 
				
				<form action="${pageContext.request.contextPath }/cupDirectOrder.cup"
					name="form1" method="post">
				<b>수량 : </b><input type="text" id="product_quantity"
					name="product_quantity" onchange="qnt(this)" size="1" value="1" />개<br>
					
				<br>
				
					<input type="radio" name="way" value="online" checked="checked">딜리버리
					<input type="radio" name="way" value="offline">현장수령 
					<input type="radio" name="way" value="reservation">예약주문
					 
					<input type="hidden" name="product_name" value="${cup.product_name }" />
					<input type="hidden" name="product_price" value="${cup.product_price }" /> 
					<input type="hidden" name="product_quantity" value="${order_detail.product_price }" />
						
					<hr align="center" width="250px">

					
				</form>
				
				<form action="${pageContext.request.contextPath }/cupCartList.cup" name="form2" method="post">
					<input type="hidden" id="product_quantity" name="product_quantity" value="${product_quantity}" />
					<a href="javascript:void(0);" onclick="cart()">장바구니</a>&nbsp;&nbsp;
				</form>

				<nav id="commandList">					
					<a href="javascript:check()">바로구매</a><br>
					<a href="cupList.cup">쇼핑 계속하기</a>
				</nav>
			</section>
		</section>

		<p id="desc">
			<b>상품안내 : </b><br>${cup.product_content }<br>
		<div class="review" id="reboard">
			<h3>&nbsp;&nbsp;상품문의</h3>
			<div id="commandCell" align="right">
				<button type="button" id="wbutton"
					onclick="window.open('./question/questionWriteForm.qu?item_code=V006','','width=500, height=400')">문의하기</button>
			</div>


		</div>

		<h3>&nbsp;&nbsp;상품후기</h3>
		<div id="commandCell" align="right">
			<button type="button" id="wbutton"
				onclick="window.open('./question/questionWriteForm.qu?item_code=V006','','width=500, height=400')">후기쓰기</button>
		</div>



	</section>
</body>
</html>