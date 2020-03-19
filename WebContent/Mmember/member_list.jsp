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
	<!-- 회원 리스트  -->
	<h2>회원 리스트</h2>
	<section id="listForm">
		<p>회원목록</p>
		<c:choose>
			<c:when test="${memberList ne null }">
				<form method="post">
					<table id="memberList" width="100%"
						class="table table-bordered table-hover text-center">
						<thead>
							<tr class="tr_top" height="40px">
								<td>아이디</td>
								<td>이름</td>
								<td>전화번호</td>
								<td>등급</td>
								<td>생년월일</td>
								<td>성별</td>
								<td>이메일주소</td>
								<td>주소</td>
								<td></td>
								<td></td>
							</tr>
						</thead>
						<c:forEach items="${memberList }" var="member">
							<tbody>
								<tr height="40px">
									<td>${member.member_id }</td>
									<td>${member.member_name }</td>
									<td>${member.member_phone }</td>
									<td>${member.member_rating }</td>
									<td>${member.member_birth }</td>
									<td>${member.member_gender }</td>
									<td>${member.member_email }</td>
									<td>${member.member_zip} ${member.member_addr}
										${member.member_addr_detail }</td>
									<td
										onClick="window.open('memberDetail.mem?member_id=${member.member_id}','new','width=550px,height=700px,location=no,status=no,scrollbars=no');">
										<input type="submit" value="수정" />
									</td>
									<td>
										<input type="button" onClick="location.href='Mdelete.mem?member_id=${member.member_id}'" value="삭제" />
									</td>
								</tr>
							</tbody>
						</c:forEach>
					</table>
					<br>
					<form name="f"
						action="${pageContext.request.contextPath }/memberList.mem"
						method="post">
						<select name="searchType">
							<option value="member_id">아이디</option>
							<option value="member_name">이름</option>
							<option value="member_gender">성별</option>
							<option value="member_birth">생년월일</option>
							<option value="member_addr">주소</option>
						</select> <input type="text" name="keyword" id="keyword" /> <input
							type="submit" value="검색" />
					</form>
					<!-- 페이지 처리 -->
					<section id="pageList">
						<c:choose>
							<c:when test="${pageInfo.page <=1 }">
						[이전]&nbsp;
					</c:when>
							<c:otherwise>
								<a href="memberList.mem?page=${pageInfo.page-1 }">[이전]</a>&nbsp;
					</c:otherwise>
						</c:choose>
						<c:forEach var="a" begin="${pageInfo.startPage }"
							end="${pageInfo.endPage }" step="1">
							<c:choose>
								<c:when test="${a==pageInfo.page }">
							[${a }]
						</c:when>
								<c:otherwise>
									<a href="memberList.mem?page=${a }">[${a }] </a>&nbsp;
						</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${pageInfo.page >= pageInfo.maxPage }">
						[다음]
					</c:when>
							<c:otherwise>
								<a href="memberList.mem?page=${pageInfo.page+1 }">[다음]</a>
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