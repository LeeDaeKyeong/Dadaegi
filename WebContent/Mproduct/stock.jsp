<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
#listForm {
	width: 100%;
	border: 1px pink solid;
	margin: auto;
}

#pageList {
	text-align: center;
}

#stockList {
	margin: auto 0;
	border: 1px solid #000000;
	width: 1000px;
	margin: auto;
	text-align: center;
}

.tr_top {
	background-color: pink;
	text-align: center;
}

img {
	width: 50px;
	height: 50px;
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
</script>
<form method="post">
	<body>
		<h2>재고 리스트</h2>

		<section id="listForm">
			<p>재고목록</p>
			<c:choose>
				<c:when test="${stockList ne null }">
					<table id="stockList" width="100%"
						class="table table-bordered table-hover text-center">
						<thead>
							<tr class="tr_top" height="40px">
								<td>상품코드</td>
								<td>상품이미지</td>
								<td>상품명</td>
								<td>상품가격</td>
								<td>상품입고</td>
								<td>상품출고</td>
								<td>상품재고</td>
							</tr>
						</thead>
						<c:set var="tmp_code" value="" />
						<tbody>
							<c:forEach items="${stockList }" var="stock">


								<c:if test="${tmp_code ne stock.product_code }">
									<tr height="40px" onmouseover="this.style.background='#F6F6F6'"
										onmouseout="this.style.background='white'">
										<td style="cursor: pointer;"
											onClick="window.open('stockdetail.pro?product_code=${stock.product_code}','new','width=1300px,height=800px,location=no,status=no,scrollbars=no');">${stock.product_code }</td>
										<td style="cursor: pointer;"
											onClick="window.open('stockdetail.pro?product_code=${stock.product_code}','new','width=1300px,height=800px,location=no,status=no,scrollbars=no');"><img
											src="${pageContext.request.contextPath }/images/${stock.product_image }"></td>
										<td style="cursor: pointer;"
											onClick="window.open('stockdetail.pro?product_code=${stock.product_code}','new','width=1300px,height=800px,location=no,status=no,scrollbars=no');">${stock.product_name }</td>
										<td style="cursor: pointer;"
											onClick="window.open('stockdetail.pro?product_code=${stock.product_code}','new','width=1300px,height=800px,location=no,status=no,scrollbars=no');">${stock.product_price }</td>
								</c:if>
								<c:if test="${stock.stock_status eq 'in'}">
									<c:set var="indata" value="${stock.inout_quantity }" />
									<td style="cursor: pointer;"
										onClick="window.open('stockdetail.pro?product_code=${stock.product_code}','new','width=1300px,height=800px,location=no,status=no,scrollbars=no');">${ stock.inout_quantity eq null ? '0' : stock.inout_quantity }개</td>
								</c:if>
								<c:if test="${stock.stock_status eq 'out' }">
									<td style="cursor: pointer;"
										onClick="window.open('stockdetail.pro?product_code=${stock.product_code}','new','width=1300px,height=800px,location=no,status=no,scrollbars=no');">${stock.inout_quantity eq null ? '0' :
										stock.inout_quantity }개</td>
									<td style="cursor: pointer;"
										onClick="window.open('stockdetail.pro?product_code=${stock.product_code}','new','width=1300px,height=800px,location=no,status=no,scrollbars=no');">${indata-stock.inout_quantity }개</td>
									</tr>

								</c:if>

								<c:set var="tmp_code" value="${stock.product_code }" />


							</c:forEach>
						</tbody>
					</table>
					<section id="pageList">
						<c:choose>
							<c:when test="${pageInfo.page <=1 }">
						[이전]&nbsp;
					</c:when>
							<c:otherwise>
								<a href="stock.pro?page=${pageInfo.page-1 }">[이전]</a>&nbsp;
					</c:otherwise>
						</c:choose>
						<c:forEach var="a" begin="${pageInfo.startPage }"
							end="${pageInfo.endPage }" step="1">
							<c:choose>
								<c:when test="${a==pageInfo.page }">
							[${a }]
						</c:when>
								<c:otherwise>
									<a href="stock.pro?page=${a }">[${a }] </a>&nbsp;
						</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${pageInfo.page >= pageInfo.maxPage }">
						[다음]
					</c:when>
							<c:otherwise>
								<a href="stock.pro?page=${pageInfo.page+1 }">[다음]</a>
							</c:otherwise>
						</c:choose>
					</section>
				</c:when>
				<c:otherwise>
					<table>
						<tr>
							<td align="center"><section id="emptyArea">등록된 재고가
									없습니다.</section></td>
						</tr>
					</table>
				</c:otherwise>
			</c:choose>
		</section>
</form>
</body>
</html>