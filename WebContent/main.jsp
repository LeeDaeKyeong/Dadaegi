<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<style>
ul {
	list-style: none;
}

.sidemanu>ul>li {
	display: inline-block;
	/*float: left;*/
	width: 130px;
	height: 40px;
	margin-top: 0;
	position: relative;
}
.sidemanu>ul>li>a {
	text-decoration:none;
	display: block;
	width: 120px;
	height: 100%;
	font: bold 30px/30px "맑은 고딕", arial;
	text-align: center;
	color: #8A2908;
	background: #ffffff;
}
</style>
<body>
	<img src="images/img1.jpg" id=mainImage alt="YsImage"
		style="width: 800px; height: 450px;">
	<script>
		var myImage = document.getElementById("mainImage");
		var imageArray = [ "images/img1.jpg", "images/img2.jpg", "images/img3.jpg" ];
		var imageIndex = 0;

		function changeImage() {
			myImage.setAttribute("src", imageArray[imageIndex]);
			imageIndex++;
			if (imageIndex >= imageArray.length) {
				imageIndex = 0;
			}
		}
		setInterval(changeImage, 3000);
	</script>
	<hr>
	<div class="sidemanu">
		<ul>
			<li><a href="#"><img src="images/review.jpg">
			<br>오프라인 주문</a></li>
			<li><a href="#"><img src="images/online.jpg">
			<br>온라인 주문</a></li>
			<li><a href="#"><img src="images/map.jpg">
			<br>오시는 길</a></li>
		</ul>
	</div>
</body>
</html>