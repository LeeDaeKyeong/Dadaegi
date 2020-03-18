<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="vo.Product"%>
<%@ page import="vo.PageInfo"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>컵씨 리스트</title>
<style>
header {
	background-color: #FFFFFF;
	border: 1px solid #000000;
	top: 0;
	left: 0;
}

h2 {
	color: black;
	margin: 0 auto;
	text-align: center;
}

.wrapper {
	margin: 0 auto;
}

#left_menu {
	float: left;
}

#content {
	float: left;
}

.right {
	text-align: right;
}

img {
	width: 100px;
	height: 70px;
}

#pageList {
	margin: auto;
	width: 500px;
	text-align: center;
}

form {
	margin: auto;
	width: 400px;
	text-align: center;
}
</style>
</head>
<header>
	<div class="wrapper">
		<h2>상품관리 ${fn:substring(product_code,0,4) eq 'cake' ? '컵' : '음료'}씨</h2>
	</div>
</header>
<body>
	<br>
	<form name="f" action="${pageContext.request.contextPath }/list.pro"
		method="post">
		<input type="text" name="product_name" id="product_name"
			Placeholder="상품명을 입력하세요." /> <input type="submit" value="검색" />
	</form>

	<c:choose>

		<c:when test="${productList!=null }">
			<table>
				<tr>
					<td colspan="2" class="td_title">${fn:substring(product_code,0,4) eq 'cake' ? '컵' : '음료'}씨네</td>
				</tr>
				<c:forEach var="product" items="${productList }" varStatus="status">
					<tr>
						<td><a href="view.pro?product_name=${product.product_name }">
								<img
								src="${pageContext.request.contextPath }/images/${product.product_image }"
								id="productImage" />
						</a></td>
						<td>상품명 : ${product.product_name } 가격 : ${product.product_price } 설명
							: ${product.product_content }</td>
						<td>
							<form name="mod" action="mod.pro" method="post">
								<input type="hidden" name="product_name" id="product_name" value="${product.product_name }"/>
								<input type="submit" value="상품 수정" />
							</form>
							<form name="delete" action="delete.pro" method="post">
							<input type="hidden" name="product_name" id="product_name" value="${product.product_name }"/>
								<input type="submit" value="상품 삭제" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
			<section id="pageList">
				<c:choose>
					<c:when test="${pageInfo.page <=1 }">
						[이전]&nbsp;
					</c:when>
					<c:otherwise>
						<a href="list.pro?page=${pageInfo.page-1 }">[이전]</a>&nbsp;
					</c:otherwise>
				</c:choose>
				<c:forEach var="a" begin="${pageInfo.startPage }"
					end="${pageInfo.endPage }" step="1">
					<c:choose>
						<c:when test="${a==pageInfo.page }">
							[${a }]
						</c:when>
						<c:otherwise>
							<a href="list.pro?page=${a }">[${a }] </a>&nbsp;
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${pageInfo.page >= pageInfo.maxPage }">
						[다음]
					</c:when>
					<c:otherwise>
						<a href="list.pro?page=${pageInfo.page+1 }">[다음]</a>
					</c:otherwise>
				</c:choose>
			</section>
		</c:when>
		<c:otherwise>
			<table>
				<tr>
					<td align="center"><section id="emptyArea">컵씨가 없습니다.
							컵씨를 추가하세요!</section></td>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>