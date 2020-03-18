<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선택에 따른 페이지 이동</title>
<script language="javascript">
	function check() {
		var form = document.form1;
		//첫번째 라디오 버튼을 선택한 경우
		if (form.way[0].checked == true) {
			//현재 폼의 action 값을 menu_1.html이라는 파일로 만든다
			form.action = "cupOrder.cup";
		}
		//두번째 라디오 버튼을 선택한 경우
		else if (form.way[1].checked == true) {
			form.action = "cupOrder.cup";
		} else {
			form.action = "#";
		}
		form.submit();
	}
</script>
</head>
<body>
	<h2>수령방법</h2>
	<table>
		<form name="form1" method="post">
			<input type="radio" name="way" value="online" checked="checked">딜리버리 <input
				type="radio" name="way" value="offline">현장수령 <input
				type="radio" name="way" value="reservation">예약주문
		</form>

	</table>
	<a href="javascript:check()">다음 단계로</a>&nbsp;
	<a href="cupList.cup">쇼핑 계속하기</a>
</body>
</html>