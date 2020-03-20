<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"
	type="text/javascript"></script>
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
	$(document).ready(
			function() {
				// 옵션추가 버튼 클릭시
				$("#addItemBtn").click(
						function() {
							// item 의 최대번호 구하기
							var lastItemNo = $("#memberList tr:last").attr(
									"class").replace("item", "");

							var newitem = $("#memberList tr:eq(1)").clone();
							newitem.removeClass();
							newitem.find("td:eq(0)").attr("rowspan", "1");
							newitem.addClass("item"
									+ (parseInt(lastItemNo) + 1));

							$("#memberList").append(newitem);
						});

				// 항목추가 버튼 클릭시
				$(".addBtn").live("click", function() {
					var clickedRow = $(this).parent().parent();
					var cls = clickedRow.attr("class");

					// tr 복사해서 마지막에 추가
					var newrow = clickedRow.clone();
					newrow.find("td:eq(0)").remove();
					newrow.insertAfter($("#example ." + cls + ":last"));

					// rowspan 조정
					resizeRowspan(cls);
				});

				// 삭제버튼 클릭시
				$(".delBtn").live(
						"click",
						function() {
							var clickedRow = $(this).parent().parent();
							var cls = clickedRow.attr("class");

							// 각 항목의 첫번째 row를 삭제한 경우 다음 row에 td 하나를 추가해 준다.
							if (clickedRow.find("td:eq(0)").attr("rowspan")) {
								if (clickedRow.next().hasClass(cls)) {
									clickedRow.next().prepend(
											clickedRow.find("td:eq(0)"));
								}
							}

							clickedRow.remove();

							// rowspan 조정
							resizeRowspan(cls);
						});

				// cls : rowspan 을 조정할 class ex) item1, item2, ...
				function resizeRowspan(cls) {
					var rowspan = $("." + cls).length;
					$("." + cls + ":first td:eq(0)").attr("rowspan", rowspan);
				}
			});

	function fn_delRow(chkObjNm) {

		if ($("input[name=" + chkObjNm + "]").is(":checked")) {

			if (confirm("삭제 하시겠습니까?")) {

				for (var i = $("[name='" + chkObjNm + "']:checked").length - 1; i > -1; i--) {

					$("[name='" + chkObjNm + "']:checked").eq(i).closest("tr")
							.remove();

				}

			}

		} else {

			alert("선택된 데이터가 없습니다.");

		}

	}
</script>
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

#memberList {
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

#commandCell {
	text-align: center;
}
</style>
<body>
	<!-- 회원등급 리스트  -->
	<h2>회원등급 리스트</h2>
	<section id="listForm">
		<p>회원등급목록</p>
		<c:choose>
			<c:when test="${ratingList ne null }">
				<form method="post">
					<table id="memberList" width="100%"
						class="table table-bordered table-hover text-center">
						<thead>
							<tr class="tr_top" height="40px">
								<td><input type="checkbox" id="allCheck" name="allCheck"
									onclick="checkAll(this.form)" /></td>
								<td>등급명</td>
								<td>결제조건</td>
								<td>등급 할인율</td>
								<td>등급 조건</td>
								<td>회원수</td>
								<td>회원보기</td>
								<td>수정</td>
							</tr>
						</thead>
						<c:forEach items="${ratingList }" var="rating">

							<tbody>
								<tr height="40px" class="item1">
									<td><input type="checkbox" id="remove" name="remove"
										value="" /></td>
									<td>${rating.member_rating }</td>
									<td>${rating.rating_payment }</td>
									<td>${rating.rating_discount }%</td>
									<td>${rating.rating_content }</td>
									<td>${rating.rating_count }명</td>
									<td
										onClick="window.open('memberRating.mem?member_rating=${rating.member_rating}','new','width=550px,height=500px,location=no,status=no,scrollbars=no');"><input
										type="button" value="회원보기" /></td>
									<td
										onClick="window.open('ratingDetail.mem?member_rating=${rating.member_rating}','new','width=550px,height=700px,location=no,status=no,scrollbars=no');">
										<input type="submit" value="수정" />
									</td>
								</tr>
							</tbody>
						</c:forEach>
					</table>
					<br>
					<section id="commandCell">
						<input type="button" id="addItemBtn" value="등록" /> <input
							type="button" onClick="window.open('ratingDelete.mem?member_rating=${rating.member_rating});" value="삭제" />
					</section>

					<!-- 페이지 처리 -->
					<section id="pageList">
						<c:choose>
							<c:when test="${pageInfo.page <=1 }">
						[이전]&nbsp;
					</c:when>
							<c:otherwise>
								<a href="qnalist.qn?page=${pageInfo.page-1 }">[이전]</a>&nbsp;
					</c:otherwise>
						</c:choose>
						<c:forEach var="a" begin="${pageInfo.startPage }"
							end="${pageInfo.endPage }" step="1">
							<c:choose>
								<c:when test="${a==pageInfo.page }">
							[${a }]
						</c:when>
								<c:otherwise>
									<a href="qnalist.qn?page=${a }">[${a }] </a>&nbsp;
						</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${pageInfo.page >= pageInfo.maxPage }">
						[다음]
					</c:when>
							<c:otherwise>
								<a href="qnalist.qn?page=${pageInfo.page+1 }">[다음]</a>
							</c:otherwise>
						</c:choose>
					</section>
			</c:when>
			<c:otherwise>
				<table>
					<tr>
						<td align="center"><section id="emptyArea">등록된 등급이
								없습니다.</section></td>
					</tr>
				</table>
				</form>
			</c:otherwise>
		</c:choose>
	</section>
</body>
</html>