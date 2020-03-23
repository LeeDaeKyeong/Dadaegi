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
</style>
<body>
	<!-- 쪽지 리스트  -->
	<h2>쪽지 리스트</h2>
	<section id="listForm">
		<p>쪽지목록</p>
		<c:choose>
			<c:when test="${noteList ne null }">
				<form method="post">
					<table id="memberList" width="100%"
						class="table table-bordered table-hover text-center">
						<thead>
							<tr class="tr_top" height="40px">
								<td>받는사람</td>
								<td>보낸사람</td>
								<td>내용</td>
								<td>보낸날짜</td>
								<td></td>
								<td></td>
							</tr>
						</thead>
						<c:forEach items="${noteList }" var="note">
							<tbody>
								<tr height="40px">
									<td>${note.recv_id }</td>
									<td>${note.send_id }</td>
									<td>${note.note_content }</td>
									<td>${note.send_date }</td>
									<td
										onClick="window.open('memberDetail.mem?member_id=${member.member_id}','new','width=550px,height=700px,location=no,status=no,scrollbars=no');">
										<input type="submit" value="상세보기" />
									</td>
									<td>
										<input type="button" onClick="location.href='Mdelete.mem?member_id=${member.member_id}'" value="삭제" />
									</td>
								</tr>
							</tbody>
						</c:forEach>
					</table>
					<!-- 페이지 처리 -->
					<section id="pageList">
						<c:choose>
							<c:when test="${pageInfo.page <=1 }">
						[이전]&nbsp;
					</c:when>
							<c:otherwise>
								<a href="noteList.mem?page=${pageInfo.page-1 }">[이전]</a>&nbsp;
					</c:otherwise>
						</c:choose>
						<c:forEach var="a" begin="${pageInfo.startPage }"
							end="${pageInfo.endPage }" step="1">
							<c:choose>
								<c:when test="${a==pageInfo.page }">
							[${a }]
						</c:when>
								<c:otherwise>
									<a href="noteList.mem?page=${a }">[${a }] </a>&nbsp;
						</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${pageInfo.page >= pageInfo.maxPage }">
						[다음]
					</c:when>
							<c:otherwise>
								<a href="noteList.mem?page=${pageInfo.page+1 }">[다음]</a>
							</c:otherwise>
						</c:choose>
					</section>
			</c:when>
			<c:otherwise>
				<table>
					<tr>
						<td align="center"><section id="emptyArea">등록된 회원이
								없습니다.</section></td>
					</tr>
				</table>
				</form>
			</c:otherwise>
		</c:choose>
	</section>
</body>
</html>