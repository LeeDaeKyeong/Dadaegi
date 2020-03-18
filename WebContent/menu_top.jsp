<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body, div, ul, li {
	margin: 0;
	padding: 0;
}

body {
	font-size: 14px;
	font-family: "맑은 고딕", arial;
}

ul {
	list-style: none;
}

a {
	color: #000;
	text-decoration: none;
}

.gnb { /* width : 720px; */
	height: 36px;
	margin: auto;
	margin-top: 10px;
}
/* 메인메뉴 영역 */
.gnb>ul>li {
	display: inline-block;
	/*float: left;*/
	width: 150px;
	height: 40px;
	margin-top: 0;
	position: relative;
}

.gnb>ul>li>a {
	display: block;
	width: 100px;
	height: 100%;
	font: bold 15px/32px "맑은 고딕", arial;
	text-align: center;
	color: #F7819F;
	background: #ffffff;
}

.gnb ul li a:hover {
	color: #000;
	background: #FFA7A7;
}

/*롤오버*/
.gnb ul li:hover ul {
	display: block;
	/*width: 400px; height: 36px; position: absolute; left:0; top: 30px;*/
}

h2 {
	text-align: center;
}

.loginlink {
	text-align: right;
	margin-left: auto;
}

#rogo{
width : 150px;
height : 100px;
}

#alarm{
width: 15px;
height: 15px;
}
</style>
</head>
<body>
	<a href="main.cup"> 
		<img id="rogo" src="images/rogo.jpg" align="center"
		border="0">
	</a>
	<br>
	<div style="float: right;">
		<c:choose>
			<c:when test="${member eq null }">
				<a class="loginlink" href="loginForm.log">로그인</a>
			</c:when>
			<c:otherwise>
				<a href="#"> <!-- 추후에 if문으로 알림 전 후 이미지 설정하기 -->
				<img id="alarm" src="images/alarm.jpg" align="center" border="0">
				</a>
				${member.member_id}님, 환영합니다!
				<a class="loginlink" href="memberInfo.mem?member_id=${member.member_id}">마이페이지</a>
				<a class="loginlink" href="logout.log">로그아웃</a>
			</c:otherwise>
		</c:choose>
	</div>
	<br>
	<div class="gnb">
		<ul>
			<li><a class="menuLink" href="introduce.cup">컵씨소개</a></li>
			<li><a class="menuLink" href="cupList.cup">컵씨들</a></li>
			<li><a class="menuLink" href="drinkList.cup">음료씨들</a></li>
			<li><a class="menuLink" href="questionList.qu">고객문의</a></li>
			<li><a class="menuLink" href="review.cup">리뷰</a></li>
		</ul>
	</div>
</body>
</html>