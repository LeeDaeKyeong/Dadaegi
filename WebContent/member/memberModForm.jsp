<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.Member" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>회원 정보 수정 페이지</title>
<style>
table {
	margin: auto;
	width: 500px;
	border: 1px solid gray;
	text-align: center;
}

.td_title {
	font-weight: bold;
	font-size: x-large;
}
</style>
</head>
<body>
	<form name="modifyform" action="memberModPro.mem" method="post">
		<table border=1>
			<tr>
				<td colspan="2" class="td_title">회원 정보 수정 페이지</td>
			</tr>
			<tr>
				<td><label for="member_id">아이디 : </label></td>
				<td align=left>${member.getMember_id()}<input type="hidden"
					value="${member.getMember_id()}" name="member_id" id="member_id" required readonly />
				</td>
			</tr>
			<tr>
				<td><label for="pass">비밀번호 : </label></td>
				<td align=left><input type="password" name="pass" id="pass"
					value="${member.getMember_pw()}" required /></td>
			</tr>
			<tr>
				<td><label for="name">이름 : </label></td>
				<td align=left><input type="text" name="name" id="name"
					value="${member.getMember_name()}" /></td>
			</tr>
			<tr>
				<td><label for="birth">생년월일 : </label></td>
				<td align=left><input type="text" name="birth" id="birth"
					value="${member.getMember_birth()}" /></td>
			</tr>
			<tr>
				<td><label for="gender1"></label>성별 :</td>
				<td align=left>
					<input type="radio" name="gender" value="남" id="gender1" 
					
					${member.member_gender eq '남' ? 'checked' : '' } />남자
					 <input type="radio" name="gender" value="여" id="gender"
					 
					${member.member_gender eq '여' ? 'checked' : '' } />여자
				</td>
			</tr>
			<tr>
				<td><label for="phone">전화번호 : </label></td>
				<td align=left><input type="text" name="phone" id="phone"
					value="${member.getMember_phone()}" /></td>
			</tr>
			<tr>
				<td><label for="email">이메일 주소 : </label></td>
				<td align=left><input type="text" name="email" id="email"
					value="${member.getMember_email()}" /></td>
			</tr>
			<tr>
				<td colspan="2"><a href="javascript:modifyform.submit()">수정하기</a>&nbsp;&nbsp;
					<a href="javascript:modifyform.reset()">초기화</a>&nbsp;&nbsp; <a
					href="javascript:location.href='memberInfo.mem?member_id=${member.member_id }'">돌아가기</a></td>
			</tr>
		</table>
	</form>
</body>
</html>
