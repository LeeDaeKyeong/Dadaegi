<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.Cart"%>
<%@ page import="vo.Cup"%>
<%@ page import="dao.CupDAO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#listForm {
	width: 640px;
	border: 1px red solid;
	margin: auto;
}

h2 {
	text-align: center;
}

table {
	width: 550px;
	margin: auto;
}

.tr_top {
	background-color: #F5A9A9;
}

.div_empty {
	text-align: center;
	background-color: skyblue;
}

.td_command {
	text-align: right;
}

#todayImageList {
	text-align: center;
}

#productImage {
	width: 150px;
	height: 150px;
	border: none;
}

#cartImage {
	width: 70px;
	height: 70px;
	border: none;
}

#select {
	text-align: right;
}

#commandList {
	text-align: center;
}

#upImage {
	width: 15px;
}

#downImage {
	width: 15px;
}
</style>
<script>
	function checkAll(theForm) {
		if (theForm.remove.length == undefined) {
			theForm.remove.checked = theForm.allCheck.checked;
		} else {
			for (var i = 0; i < theForm.remove.length; i++) {
				theForm.remove[i].checked = theForm.allCheck.checked;
			}
		}
	}

	function checkQty(product_name, product_quantity) {
		if (product_quantity != 1) {
			location.href = "cupCartQtyDown.cup?product_name="
					+ encodeURIComponent(product_name);
		}
	}
</script>
</head>
<body>
	<jsp:include page="/common/loginCheck.jsp"></jsp:include>
	<c:if test="${startMoney!=null }">
		<c:set var="startMoney" value="${startMoney }"></c:set>
	</c:if>
	<c:if test="${endMoney!=null }">
		<c:set var="endMoney" value="${endMoney }"></c:set>
	</c:if>
	<section id="listForm">
		<c:if test="${cartList!=null && cartList.size()>0 }">
			<h2>장바구니 목록</h2>
			<form method="post">
				<table>
					<tr id="select">
						<td colspan="6"><select id="startMoney" name="startMoney">
								<option>=최하=</option>
								<c:choose>
									<c:when test="${startMoney==1000 }">
										<option selected="selected">1000</option>
										<option>2000</option>
										<option>3000</option>
										<option>4000</option>
										<option>5000</option>
									</c:when>
									<c:when test="${startMoney==2000 }">
										<option>1000</option>
										<option selected="selected">2000</option>
										<option>3000</option>
										<option>4000</option>
										<option>5000</option>
									</c:when>
									<c:when test="${startMoney==3000 }">
										<option>1000</option>
										<option>2000</option>
										<option selected="selected">3000</option>
										<option>4000</option>
										<option>5000</option>
									</c:when>
									<c:when test="${startMoney==4000 }">
										<option>1000</option>
										<option>2000</option>
										<option>3000</option>
										<option selected="selected">4000</option>
										<option>5000</option>
									</c:when>
									<c:when test="${startMoney==5000 }">
										<option>1000</option>
										<option>2000</option>
										<option>3000</option>
										<option>4000</option>
										<option selected="selected">5000</option>
									</c:when>
									<c:otherwise>
										<option>1000</option>
										<option>2000</option>
										<option>3000</option>
										<option>4000</option>
										<option>5000</option>
									</c:otherwise>
								</c:choose>
						</select> <select id="endMoney" name="endMoney">
								<option>=최고=</option>
								<c:choose>
									<c:when test="${endMoney==1000 }">
										<option selected="selected">1000</option>
										<option>2000</option>
										<option>3000</option>
										<option>4000</option>
										<option>5000</option>
									</c:when>
									<c:when test="${endMoney==2000 }">
										<option>1000</option>
										<option selected="selected">2000</option>
										<option>3000</option>
										<option>4000</option>
										<option>5000</option>
									</c:when>
									<c:when test="${endMoney==3000 }">
										<option>1000</option>
										<option>2000</option>
										<option selected="selected">3000</option>
										<option>4000</option>
										<option>5000</option>
									</c:when>
									<c:when test="${endMoney==4000 }">
										<option>1000</option>
										<option>2000</option>
										<option>3000</option>
										<option selected="selected">4000</option>
										<option>5000</option>
									</c:when>
									<c:when test="${endMoney==5000 }">
										<option>1000</option>
										<option>2000</option>
										<option>3000</option>
										<option>4000</option>
										<option selected="selected">5000</option>
									</c:when>
									<c:otherwise>
										<option>1000</option>
										<option>2000</option>
										<option>3000</option>
										<option>4000</option>
										<option>5000</option>
									</c:otherwise>
								</c:choose>
						</select> <input type="submit" value="검색" formaction="dogCartSearch.dog" />
						</td>
					</tr>
					<tr class="tr_top">
						<td><input type="checkbox" id="allCheck" name="allCheck"
							onclick="checkAll(this.form)" /></td>
						<td>번호</td>
						<td>상품 이미지</td>
						<td>상품명</td>
						<td>가격</td>
						<td>수량</td>

					</tr>
					<c:forEach var="cart" items="${cartList }" varStatus="status">
						<tr>
							<td><input type="checkbox" id="remove" name="remove" value="${cart.product_name }" /></td>
							<td>${status.index+1 }<!-- 번호값 계산  --></td>
							<td><img src="${pageContext.request.contextPath }/images/${cart.product_image }" id="cartImage" /></td>
							<td>${cart.product_name }</td>
							<td>${cart.product_price }</td>
							<td>
							<input type="text" id="product_quantity" name="product_quantity" size="1" value="${product_quantity }" />개
							</td>

						</tr>
					</c:forEach>
					
					<tr>
						<td colspan="5" style="text-align: center;">총 금액 :
							${totalMoney }원</td>
					</tr>
					<tr>
						<td colspan="5" style="text-align: center;"><input
							type="submit" value="선택삭제" formaction="cupCartRemove.cup" /></td>
					</tr>
				</table>
			</form>
		</c:if>
		<c:if test="${cartList==null }">
			<section class="div_empty">상품 정보가 없습니다.</section>
		</c:if>
		<nav id="commandList">
			<a href="cupWay.cup">주문하기</a>&nbsp; 
			<a href="cupList.cup">쇼핑 계속하기</a>
		</nav>
	</section>
</body>
</html>