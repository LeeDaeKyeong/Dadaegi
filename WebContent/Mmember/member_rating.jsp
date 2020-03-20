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
form {
	width: auto;
	height: auto;
	margin-right: 1.5625%;
	margin-bottom: 20px;
	margin-top: 20px;
	padding: 3%;
	border: 1px dotted #333;
	border-radius: 10px;
}

table h2 {
	padding-left: 30px;
}

tr {
	margin: 10px;
	height: 50px;
}

td {
	text-align: center;
}

#sub {
	background-color: lightgray;
	width: 100px;
	text-align: center;
}

body {
	font-family: 'Malgun Gothic';
	font-size: 9pt;
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
	width: 40px;
	height: 40px;
}

#commandCell {
	text-align: center;
}
</style>
<body>
	<!-- 등급별 회원 리스트  -->
	<h2>등급별 회원 리스트</h2>
	<section id="listForm">
		<p>회원목록</p>

		<form method="post">
			<c:choose>
				<c:when test="${memberRatingList ne null }">
					<table id="qnaList" width="100%"
						class="table table-bordered table-hover text-center">
						<thead>
							<tr class="tr_top" height="40px">
								<td id="sub">아이디</td>
								<td id="sub">이름</td>
								<td id="sub">회원등급</td>
							</tr>
						</thead>
						<c:forEach items="${memberRatingList }" var="memberrating">
							<tbody>
								<tr height="40px">
									<td>${memberrating.member_id }</td>
									<td>${memberrating.member_name }</td>
									<td>${memberrating.member_rating }</td>
								</tr>
							</tbody>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<table>
						<tr>
							<td align="center"><section id="emptyArea">등록된 회원이
									없습니다.</section></td>
						</tr>
					</table>

				</c:otherwise>
			</c:choose>
		</form>
		<section id="commandCell">
			<input type="button" value="닫기" onClick="window.close()" />
		</section>
	</section>
</body>
</html>