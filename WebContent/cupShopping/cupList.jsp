<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="vo.Cup"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#listForm {
	width: auto;
	border: 1px solid white;
	margin: auto;
}

h2 {
	text-align: center;
}

table {
	margin: auto;
	width: 550px;
}

.div_empty {
	background-color: red;
	width: 100%;
	height: 100%;
	text-align: center;
}

#todayImageList {
	text-align: center;
}

#productImage {
	width: 150px;
	height: 150px;
	border: none;
	margin-right: 20px;
}

#todayImage {
	width: 100px;
	height: 100px;
	border: none;
}
</style>
</head>
<body>

	<section id="listForm">
		<c:if test="${cupList != null }">
			<h2>컵씨들</h2>
			<hr>
			<p>다양하고 맛있는 컵씨들</p>
			<table>
				<tr>
					<c:forEach var="cup" items="${cupList }" varStatus="status">
						<td>
						<a href="cupView.cup?cup_index=${cup.cup_index }"> 
						<img src="${pageContext.request.contextPath }/images/${cup.product_image }" id="productImage" />
						</a> <br>
						상품명:${cup.product_name }<br> 가격:${cup.product_price }<br>
						</td>
						<c:if test="${((status.index+1) mod 4) == 0 }">
						</tr>
				<tr>
						</c:if>
					</c:forEach>
				</tr>
			</table>
		</c:if>
		<c:if test="${cupList == null }">
			<div class="div_empty">상품이 없습니다.</div>
		</c:if>
		
		
	</section>
</body>
</html>