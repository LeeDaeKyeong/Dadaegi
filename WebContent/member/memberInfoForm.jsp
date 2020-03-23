<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.Member, java.util.*"%>
<%@ page import="vo.PageInfo"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table.type02 {
	border-collapse: separate;
	border-spacing: 0;
	line-height: 1.5;
	border-top: 1px solid #ccc;
	border-left: 1px solid #ccc;
	margin: 20px 10px;
}

table.type02 th {
	text-align: center;
	width: 150px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	border-right: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	border-top: 1px solid #fff;
	border-left: 1px solid #fff;
	background: #F5A9A9;
}

table.type02 td {
	width: 350px;
	padding: 10px;
	vertical-align: top;
	border-right: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
}

h1 {
	text-align: left;
}
</style>
</head>
<body>
	<h1>내 정보</h1>
	사용가능 포인트 ${member.coupon_price }점 &nbsp;
	<button type="button" onclick="location='memberPoint.mem'">자세히</button>
	<table class="type02">
		<tr>
			<th scope="row">아이디</th>
			<td>${member.member_id }</td>
		</tr>
		<tr>
			<th scope="row">회원등급</th>
			<td>${member.member_rating }</td>
		</tr>
		<tr>
			<th scope="row">이름</th>
			<td>${member.member_name }</td>
		</tr>
		<tr>
			<th scope="row">생년월일</th>
			<td>${member.member_birth }</td>
		</tr>
		<tr>
			<th scope="row">성별</th>
			<td>${member.member_gender }</td>
		</tr>
		<tr>
			<th scope="row">전화번호</th>
			<td>${member.member_phone }</td>
		</tr>
		<tr>
			<th scope="row">이메일</th>
			<td>${member.member_email }</td>
		</tr>
		<tr>
			<th scope="row">주소</th>
			<td>${member.member_addr }&nbsp;${member.member_addr_detail }</td>
		</tr>

		<tr>
			<td colspan="2" align="center"><a
				href="memberMod.mem?member_id=${member.member_id}"
				style="color: black; font-size: 1.3em; font-weight: bold;">수정</a>&nbsp;&nbsp;
				<a href="memberDelete.mem?member_id=${member.member_id }" style="color: black; font-size: 1.3em; font-weight: bold;">탈퇴</a>&nbsp;&nbsp;
				<a href="main.cup" style="color: black; font-size: 1.3em; font-weight: bold;">메인화면</a></td>
		</tr>
	</table>
</body>
</html>