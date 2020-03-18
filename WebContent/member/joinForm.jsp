<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리 시스템 회원 가입 페이지</title>
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
<script>
var chkId=false;
var idcheck;

function chkForm(f){
	if(!chkId || idcheck!=f.member_id.value.trim()){
		alert("아이디 중복확인을 하세요!");
		return false;
	}
	if(f.member_pw.value.trim()==""){
		alert("비밀번호를 입력하세요.");
		f.member_pw.focus();
		return false;
	}
	if(f.pass.value.trim()!=f.passChk.value.trim()){
		alert("비밀번호가 일치하지 않습니다.");
		f.member_pw.value="";
		f.passChk.value="";
		f.member_pw.focus();
		return false;
	}
	f.submit();
}
	
	

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
<body>
	<form name="joinform" action="memberJoinProcess.mem" method="post"
		onsubmit="return chkForm(this);">
		<table border=1>
			<tr>
				<td colspan="2" class="td_title">회원 가입 페이지</td>
			</tr>
			<tr>
				<td><label for="member_id">아이디 : </label></td>
				<td align=left><input type="text" name="member_id" id="member_id" required />
				<input type="button" name="idCheck" value="아이디 중복확인" id="idCheck"
				onclick="window.open('idCheck.mem?openInit=true','','width=300,height=200')"/>
				</td>
			</tr>
			<tr>
				<td><label for="member_pw">비밀번호</label></td>
				<td align=left><input type="password" name="member_pw" size="10"
					id="member_pw" /></td>
			</tr>
			<tr>
				<td><label for="name">이름</label></td>
				<td align=left><input type="text" name="member_name" size="10"
					id="member_name" /></td>
			</tr>
			<tr>
				<td><label for="name">전화번호</label></td>
				<td align=left><input type="text" name="member_phone" size="12"
					id="member_phone" /></td>
			</tr>
			<tr>
				<td><label for="name">생년월일</label></td>
				<td align=left><input type="text" name="member_birth" size="12"
					id="member_birth" /></td>
			</tr>
			<tr>
				<td><label for="gender1"></label>성별</td>
				<td align=left><input type="radio" name="member_gender"
					value="남" id="member_gender" />남자 <input type="radio"
					name="member_gender" value="여" checked id="member_gender" />여자</td>
			</tr>
			<tr>
				<td><label for="email">이메일 주소</label></td>
				<td align=left><input type="text" name="member_email"
					id="member_email" /></td>
			</tr>

			<tr>
				<td rowspan="3" id="td_left"><label for="userID">주소</label></td>
				<td align=left><input type="text" name="member_zip" id="member_zip"
					size="7" />
					<button type="button" onclick="sample6_execDaumPostcode()"
						id="gbutton" style="width: 70px;">주소검색</button></td>
			</tr>
			<tr>
				<td align=left><input type="text" name="member_addr" id="member_addr"
					size="40"></td>
			</tr>
			<tr>
				<td align=left><input type="text" name="member_addr_detail"
					id="member_addr_detail" size="40" Placeholder="상세주소를 입력하세요">
					<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
				</td>
			</tr>


			<tr>
				<td colspan="2"><a href="javascript:joinform.submit()">회원가입</a>&nbsp;&nbsp;
					<a href="javascript:joinform.reset()">다시작성</a></td>
			</tr>
		</table>
	</form>
</body>
</html>