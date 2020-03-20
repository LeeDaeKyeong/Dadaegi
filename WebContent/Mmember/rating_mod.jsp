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
	<form id="rating_mod" action="ratingMod.mem">
		<h2>
			등급 정보수정
		</h2>
		<table>
			<tr>
				<td id="sub">회원등급</td>
				<td colspan="3"><input type="text" name="member_rating"
					id="member_rating" value="${rating.member_rating }" /></td>
			</tr>
			<tr>
				<td id="sub">등급 결제조건</td>
				<td colspan="3"><select name="rating_payment">
						<option value="모든결제"
							${rating.rating_payment eq '모든결제' ? 'selected' : '' }>모든결제</option>
						<option value="현금결제"
							${rating.rating_payment eq '현금결제' ? 'selected' : '' }>현금결제</option>
						<option value="카드결제"
							${rating.rating_payment eq '카드결제' ? 'selected' : '' }>카드결제</option>
						</select></td>
			</tr>
			<tr>
				<td id="sub">등급 적립율</td>
				<td colspan="3"><input type="text" name="rating_discount"
					id="rating_discount" value="${rating.rating_discount }" />%</td>
			</tr>
			<tr>
				<td id="sub">등급 조건</td>
				<td colspan="3"><textarea id="rating_content"
						name="rating_content" cols="40" rows="15">${rating.rating_content }</textarea> 
				</td>
			</tr>
		</table>
		<section id="commandCell">
			<input type="submit" value="수정하기" />&nbsp;&nbsp; <input type="reset"
				value="다시작성" />
		</section>
	</form>
</body>
</html>