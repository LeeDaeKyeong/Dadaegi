<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.Product"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>컵씨 상세보기</title>
<style>
h2 {
	text-align: center;
}

img {
	width: 280px;
	height: 280px;
	border: none;
}

#productInfoForm {
	width: 640px;
	height: 400px;
	border: 1px solid pink;
	margin: auto;
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
	background: pink;
}

#commandList {
	text-align: center;
}
</style>
</head>
<body>
	<section id="productInfoForm">
		<h2>${product.product_name }의상세정보</h2>
		<section id="content_main">
			<section id="content_left">
				<img
					src="${pageContext.request.contextPath}/images/${product.product_image }" />
			</section>
			<section id="content_right">
				${fn:substring(product.product_code,0,4) eq 'cake' ? '컵' : '음료'}씨 번호 : ${product.cup_index } <br> 상품 코드 :
				${product.product_code } <br> 상품명 : ${product.product_name } <br>
				상품 가격 : ${product.product_price } <br> 상품 등록일 :  ${product.product_date } <br> 
				상품 상태 : ${fn:substring(product.product_status,3,4) eq '1'? '활성':'비활성'} 
					
				<p id="desc">상품 설명 : ${product.product_content }</p>
			</section>
			<div style="clear: both"></div>
			<nav id="commandList">
				
				<a href="list.pro?product_code=cake">컵씨 리스트</a> 
				<a href="list.pro?product_code=drink">음료씨 리스트</a> 
				
				<a href="mod.pro?product_name=${product.product_name }">수정</a>
				<a href="delete.pro?product_name=${product.product_name }">삭제</a>
			</nav>
		</section>
	</section>
</body>
</html>