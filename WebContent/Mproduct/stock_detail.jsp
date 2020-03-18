<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

td img {
	width: 100px;
	height: 100px;
}

#subtable {
	padding: 0px;
	margin: 0px;;
}

#subtable td {
	background-color: white;
}

#subtable img {
	width: 30px;
	height: 40px;
}

#pageList {
	text-align: center;
}
</style>
</head>
<body>
	<form id="left">
		<h2>
			<img src="images/cake.png"> 재고정보
		</h2>
		<table>
			<tr>
				<td id="sub">상품코드</td>
				<td colspan="3">${stockDetailList.get(0).product_code }</td>
			</tr>
			<tr>
				<td id="sub">상품이름</td>
				<td colspan="3">${stockDetailList.get(0).product_name }</td>
			</tr>
			<tr>
				<td id="sub">상품이미지</td>
				<td colspan="3"><img
					src="${pageContext.request.contextPath}/images/${stockDetailList.get(0).product_image }" /></td>
			</tr>
			<tr>
				<td id="sub">상품가격</td>
				<td colspan="3">${stockDetailList.get(0).product_price}원</td>
			</tr>
		</table>
	</form>

	<form id="center" action="stockadd.pro" method="post">
		<h2>
			<img src="images/cupcake.png"> 입고정보
		</h2>

		<!-- 입고 리스트 보여주는 부분 -->
		<table id="subtable">

			<c:forEach items="${instockDetailList }" var="instockDetail">
				<tr>
					<td id="sub"><img src="images/icon.jpg"></td>
					<td>${fn:substring(instockDetail.inout_date,0,4)}년
						${fn:substring(instockDetail.inout_date,5,7 )}월
						${fn:substring(instockDetail.inout_date,8,10) }일</td>
					<td id="sub"><img src="images/count.jpg"></td>
					<td>${instockDetail.inout_quantity }개</td>
				</tr>
			</c:forEach>
		</table>

		<!-- 입고 리스트 추가하는 부분 -->
		<input type="hidden" name="product_code"
			value="${instockDetailList.get(0).product_code }" /> <input
			type="hidden" name="stock_index"
			value="${instockDetailList.get(0).stock_index }" /> <input
			type="hidden" name="stock_status" value="in" /> 입고 날짜 :<input
			type="date" name="inout_date" /><br> 입고 수량 : <input type="text"
			name="inout_quantity" /> <input type="submit" value="입력" />

		<!-- 입고 리스트 페이징 처리 부분 -->
		<section id="pageList">

			<!-- 이전 페이지 -->
			<c:choose>
				<c:when test="${inpageInfo.in_page <=1 }">
					[이전]&nbsp;
				</c:when>
				<c:otherwise>
					<a
						href="stockdetail.pro?in_page=${inpageInfo.in_page-1 }&product_code=${instockDetailList.get(0).product_code}">[이전]</a>&nbsp;
				</c:otherwise>
			</c:choose>

			<!-- 현재 페이지 -->
			<c:forEach var="a" begin="${inpageInfo.in_startPage }"
				end="${inpageInfo.in_endPage }" step="1">
				<c:choose>
					<c:when test="${a==inpageInfo.in_page }">
							[${a }]
						</c:when>
					<c:otherwise>
						<a
							href="stockdetail.pro?in_page=${a }&product_code=${instockDetailList.get(0).product_code}">
							[${a }] </a>&nbsp;
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<!-- 다음 페이지 -->
			<c:choose>
				<c:when test="${inpageInfo.in_page >= inpageInfo.in_maxPage }">
						[다음]
					</c:when>
				<c:otherwise>
					<a
						href="stockdetail.pro?in_page=${inpageInfo.in_page+1 }&product_code=${instockDetailList.get(0).product_code}">[다음]</a>
				</c:otherwise>
			</c:choose>
		</section>
	</form>

	<!-- 출고 리스트 보여주는 부분 -->
	<form id="right" action="stockadd.pro" method="post">
		<h2>
			<img src="images/cupcake (1).png"> 출고정보
		</h2>
		<table id="subtable">
			<c:forEach items="${outstockDetailList }" var="outstockDetail">

				<tr>
					<td id="sub"><img src="images/icon.jpg"></td>
					<td>${fn:substring(outstockDetail.inout_date,0,4)}년
						${fn:substring(outstockDetail.inout_date,5,7 )}월
						${fn:substring(outstockDetail.inout_date,8,10) }일</td>
					<td id="sub"><img src="images/count.jpg"></td>
					<td>${outstockDetail.inout_quantity }개</td>
				</tr>

			</c:forEach>
		</table>

		<!-- 출고 리스트 추가하는 부분 -->
		<input type="hidden" name="product_code"
			value="${outstockDetailList.get(0).product_code }" /> <input
			type="hidden" name="stock_index"
			value="${outstockDetailList.get(0).stock_index }" /> <input
			type="hidden" name="stock_status" value="out" /> 출고 날짜 :<input
			type="date" name="inout_date" /><br> 출고 수량 : <input type="text"
			name="inout_quantity" /> <input type="submit" value="입력" />

		<!-- 출고 리스트 페이징 처리 부분 -->
		<section id="pageList">

			<!-- 이전 페이지 -->
			<c:choose>
				<c:when test="${outpageInfo.out_page <=1 }">
						[이전]&nbsp;
					</c:when>
				<c:otherwise>
					<a
						href="stockdetail.pro?out_page=${outpageInfo.out_page-1 }&product_code=${outstockDetailList.get(0).product_code}">[이전]</a>&nbsp;
					</c:otherwise>
			</c:choose>

			<!-- 현재 페이지 -->
			<c:forEach var="a" begin="${outpageInfo.out_startPage }"
				end="${outpageInfo.out_endPage }" step="1">
				<c:choose>
					<c:when test="${a==outpageInfo.out_page }">
							[${a }]
						</c:when>
					<c:otherwise>
						<a
							href="stockdetail.pro?out_page=${a }&product_code=${outstockDetailList.get(0).product_code}">[${a }]
						</a>&nbsp;
						</c:otherwise>
				</c:choose>
			</c:forEach>

			<!-- 다음 페이지 -->
			<c:choose>
				<c:when test="${outpageInfo.out_page >= outpageInfo.out_maxPage }">
						[다음]
					</c:when>
				<c:otherwise>
					<a
						href="stockdetail.pro?out_page=${outpageInfo.out_page+1 }&product_code=${outstockDetailList.get(0).product_code}">[다음]</a>
				</c:otherwise>
			</c:choose>
		</section>
	</form>

</body>
</html>