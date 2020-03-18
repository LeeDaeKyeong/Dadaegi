<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<style type="text/css">
#registForm {
	width: 500px;
	height: 600px;
	border: 1px solid pink;
	margin: auto;
}

h2 {
	text-align: center;
}

table {
	margin: auto;
	width: 450px;
}

.td_left {
	width: 150px;
	background: pink;
}

#commandCell {
	text-align: center;
}
</style>
</head>
<script>

function getSelectValue(frm)
{
 frm.optionValue.value = frm.product.options[frm.product.selectedIndex].value+frm.season.options[frm.season.selectedIndex].value+frm.onoff.options[frm.onoff.selectedIndex].value;
}

</script>
<body>
	<section id="registForm">
		<header>
			<h2>컵씨네 상품 등록</h2>
		</header>
		<form action="add.pro?product_code=${product.product_code }" method="post" name="writeForm"
			enctype="multipart/form-data">

			<table>
				<tr>
					<td colspan="2"><a href="list.pro?product_code=cake">컵씨 목록보기</a></td>
				</tr>
				<tr>
					<td colspan="2"><a href="list.pro?product_code=drink">음료씨 목록보기</a></td>
				</tr>
				<tr>
					<td class="td_left"><label for="product_code">상품코드 : </label></td>
					<td class="td_right"><input type="text" name="product_code"
						id="product_code" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="product_name">상품명 : </label></td>
					<td class="td_right"><input type="text" name="product_name"
						id="product_name" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="product_price">상품 가격 : </label></td>
					<td class="td_right"><input type="text" name="product_price"
						id="product_price" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="product_image">상품 이미지 : </label></td>
					<td class="td_right"><input type="file" name="product_image"
						id="product_image" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="product_content">상품 내용 : </label></td>
					<td class="td_right"><textarea name="product_content" id="product_content"
							rows="13" cols="40" wrap="off"></textarea></td>
				</tr>

				<tr>
					<td class="td_left"><label for="product_date">상품 등록일 : </label></td>
					<td class="td_right"><input type="date" name="product_date" id="product_date"/></td>
				</tr>
				<tr>
					<td class="td_left"><label for="product_status">상품 상태 : </label></td>
					<td class="td_right">
					<select name = "product" onChange="getSelectValue(this.form);">
						<option value="N" selected="selected">신상품</option>
						<option value="O">구상품</option>
					</select>
					<select name = "season" onChange="getSelectValue(this.form);">
						<option value="SP">봄</option>
						<option value="SM">여름</option>
						<option value="FA">가을</option>
						<option value="WI">겨울</option>
						<option value="NN">기본</option>
					</select>
					<select name = "onoff" onChange="getSelectValue(this.form);">
						<option value="1" selected="selected">활성화</option>
						<option value="0">비활성화</option>
					</select>
					<input type="text" name="optionValue" id="product_status" /></td>
				</tr>
				<tr>
					<td colspan="2" id="commandCell"><input type="submit"
						value="컵씨/음료씨 상품 등록" /> <input type="reset" value="다시작성" /> </td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>