<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	background-color: lightgray;
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
	width: 40px;
	height: 40px;
}

#commandCell {
	text-align: center;
}
</style>
</head>

<body>
	<form id="member_mod" action="Mmod.mem">
		<h2>
			<img src="images/membership.jpg">회원정보수정
		</h2>
		<input type="hidden" name="member_pw" id="member_pw"
			value="${member.member_pw }" />
		<table>
			<tr>
				<td id="sub">아이디</td>
				<td colspan="3"><input type="text" name="member_id"
					id="member_id" value="${member.member_id }" /></td>
			</tr>
			<tr>
				<td id="sub">이름</td>
				<td colspan="3"><input type="text" name="member_name"
					id="member_name" value="${member.member_name }" /></td>
			</tr>
			<tr>
				<td id="sub">전화번호</td>
				<td colspan="3"><input type="text" name="member_phone"
					id="member_phone" value="${member.member_phone }" /></td>
			</tr>
			<tr>
				<td id="sub">등급</td>
				<td colspan="3"><select name="member_rating">
						<option value="관리자"
							${member.member_rating eq '관리자' ? 'selected' : '' }>관리자</option>
						<option value="우수회원"
							${member.member_rating eq '우수회원' ? 'selected' : '' }>우수회원</option>
						<option value="일반회원"
							${member.member_rating eq '일반회원' ? 'selected' : '' }>일반회원</option>
				</select></td>
			</tr>
			<tr>
				<td id="sub">생년월일</td>
				<td width="100px"><input type="text" name="member_birth"
					id="member_birth" value="${member.member_birth }" /></td>
			</tr>
			<tr>
				<td id="sub">성별</td>
				<td width="100px"><br> <input type="radio"
					name="member_gender" value="남" id="member_gender"
					${member.member_gender eq '남' ? 'checked' : '' }>남 <input
					type="radio" name="member_gender" value="여" id="member_gender"
					${member.member_gender eq '여' ? 'checked' : '' }>여</td>
			</tr>
			<tr>
				<td id="sub">이메일주소</td>
				<td colspan="3"><input type="text" name="member_email"
					id="member_email" value="${member.member_email }" /></td>
			</tr>
			<tr>
				<td id="sub">우편번호</td>
				<td colspan="3"><input type="text" name="member_zip"
					id="member_zip" value="${member.member_zip}" /></td>
			</tr>
			<tr>
				<td id="sub">주소</td>
				<td colspan="3"><input type="text" style="width: 300px;"
					name="member_addr" id="member_addr" value="${member.member_addr}" />
					<input type="text" style="width: 300px;" name="member_addr_detail"
					id="member_addr_detail" value="${member.member_addr_detail }" /></td>


			</tr>
		</table>
		<section id="commandCell">
			<input type="submit" value="수정하기" />&nbsp;&nbsp; <input type="reset"
				value="다시작성" />
		</section>
	</form>
</body>
</html>