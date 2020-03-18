<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>

textarea {
        width: 50%;
        height: 200px;
      }

</style>
<body>
	<h2>컵씨네</h2>
	<select name="grade">
		<option value="five" selected="selected">★★★★★</option>
		<option value="four">★★★★☆</option>
		<option value="three">★★★☆☆</option>
		<option value="two">★★☆☆☆</option>
		<option value="one">★☆☆☆☆</option>
	</select>
	<form>
		<p>
			<textarea style="resize: none;" placeholder="리뷰를 작성해주세요~!"></textarea>
		</p>
		<p>
			<input type="submit" value="작성하기"> 
			<input type="reset" value="다시쓰기">
		</p>
	</form>
</body>
</html>