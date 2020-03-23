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
<script>
function sample6_execDaumPostcode() {
	new daum.Postcode(
			{
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

					// 각 주소의 노출 규칙에 따라 주소를 조합한다.
					// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					var fullAddr = ''; // 최종 주소 변수
					var extraAddr = ''; // 조합형 주소 변수

					// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
					if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
						fullAddr = data.roadAddress;

					} else { // 사용자가 지번 주소를 선택했을 경우(J)
						fullAddr = data.jibunAddress;
					}

					// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
					if (data.userSelectedType === 'R') {
						//법정동명이 있을 경우 추가한다.
						if (data.bname !== '') {
							extraAddr += data.bname;
						}
						// 건물명이 있을 경우 추가한다.
						if (data.buildingName !== '') {
							extraAddr += (extraAddr !== '' ? ', '
									+ data.buildingName : data.buildingName);
						}
						// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
						fullAddr += (extraAddr !== '' ? ' (' + extraAddr
								+ ')' : '');
					}

					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					document.getElementById('member_zip').value = data.zonecode; //5자리 새우편번호 사용
					document.getElementById('member_addr').value = fullAddr;

					// 커서를 상세주소 필드로 이동한다.
					document.getElementById('member_addr_detail').focus();
				}
			}).open();
}
</script>
</head>
<body>
<h1>회원 정보 수정</h1>
	<form name="modifyform" action="memberModPro.mem" method="post">
		<table class="type02">
			<tr>
				<th scope="row"><label for="member_id">아이디</label></th>
				<td align=left>${member.getMember_id()}<input type="hidden"
					value="${member.getMember_id()}" name="member_id" id="member_id" required readonly />
				</td>
			</tr>
			<tr>
				<th scope="row"><label for="pass">비밀번호</label></th>
				<td align=left><input type="password" name="member_pw" id="member_pw"
					value="${member.getMember_pw()}" required /></td>
			</tr>
			<tr>
				<th scope="row"><label for="name">이름</label></th>
				<td align=left><input type="text" name="member_name" id="member_name"
					value="${member.getMember_name()}" /></td>
			</tr>
			<tr>
				<th scope="row"><label for="birth">생년월일</label></th>
				<td align=left><input type="text" name="member_birth" id="member_birth"
					value="${member.getMember_birth()}" /></td>
			</tr>
			<tr>
				<th scope="row"><label for="gender1"></label>성별</th>
				<td align=left>
					<input type="radio" name="member_gender" value="남" id="gender1" 
					
					${member.member_gender eq '남' ? 'checked' : '' } />남자
					 <input type="radio" name="member_gender" value="여" id="gender"
					 
					${member.member_gender eq '여' ? 'checked' : '' } />여자
				</td>
			</tr>
			<tr>
				<th scope="row"><label for="phone">전화번호</label></th>
				<td align=left><input type="text" name="member_phone" id="member_phone"
					value="${member.getMember_phone()}" /></td>
			</tr>
			<tr>
				<th scope="row"><label for="email">이메일</label></th>
				<td align=left><input type="text" name="member_email" id="member_email"
					value="${member.getMember_email()}" /></td>
			</tr>
			<tr>
				<th scope="row" rowspan="3" id="td_left"><label for="userID">주소</label></th>
				<td align=left><input type="text" name="member_zip" id="member_zip"
					size="7" value="${member.getMember_zip()}" />
					<button type="button" onclick="sample6_execDaumPostcode()"
						id="gbutton" style="width: 70px;">주소검색</button></td>
			</tr>
			<tr>
				<td align=left><input type="text" name="member_addr" id="member_addr"
					size="40" value="${member.getMember_addr()}"></td>
			</tr>
			<tr>
				<td align=left><input type="text" name="member_addr_detail"
					id="member_addr_detail" size="40" value="${member.member_addr_detail }" Placeholder="상세주소를 입력하세요">
					<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<a href="javascript:modifyform.submit()"style="color: black; font-size: 1.3em; font-weight: bold;">수정하기</a>&nbsp;&nbsp;
					<a href="javascript:modifyform.reset()"style="color: black; font-size: 1.3em; font-weight: bold;">초기화</a>&nbsp;&nbsp; 
					<a href="javascript:location.href='memberInfo.mem?member_id=${member.member_id }'"style="color: black; font-size: 1.3em; font-weight: bold;">돌아가기</a></td>
			</tr>
		</table>
	</form>
</body>
</html>
