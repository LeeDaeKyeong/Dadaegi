<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>컵씨네 정보 수정 페이지</title>
<style>
#modtable {
	margin: auto;
	margin-left: 30%;
	margin-top: 15%;
	width: 400px;
	border: 1px solid gray;
	text-align: center;
	width: 500px;
}

.td_title {
	font-weight: bold;
	font-size: x-large;
}

img {
	width: 100px;
	height: 100px;
}
</style>
<script>
	document.getElementById('product_date').valueAsDate = new Date();
</script>
</head>
<script>
	function getSelectValue(frm) {
		frm.optionValue.value = frm.product.options[frm.product.selectedIndex].value
				+ frm.season.options[frm.season.selectedIndex].value
				+ frm.onoff.options[frm.onoff.selectedIndex].value;
	}
</script>
<body>
	<form name="modform" action="modPro.pro" method="post"
		enctype="multipart/form-data">
		<table border=1 id="modtable">
			<tr>
				<td colspan="2" class="td_title">${fn:substring(product.product_code,0,4) eq 'cake' ? '컵' : '음료'}씨
					정보 수정 페이지</td>
			</tr>
			<tr>
				<td width="20%"><label for="cup_index">${fn:substring(product.product_code,0,4) eq 'cake' ? '컵' : '음료'}씨
						번호 </label></td>
				<td align=left width="80%">${product.cup_index }<input
					type="hidden" name="cup_index" id="cup_index"
					value=${product.cup_index } required readonly /></td>
			</tr>
			<tr>
				<td><label for="product_code">${fn:substring(product.product_code,0,4) eq 'cake' ? '컵' : '음료'}씨
						코드 </label></td>
				<td align=left><input type="text" name="product_code"
					id="product_code" value="${product.product_code }" required /></td>
			</tr>
			<tr>
				<td><label for="product_name">상품명 </label></td>
				<td align=left><input type="text" name="product_name"
					id="product_name" value="${product.product_name }" /></td>
			</tr>
			<tr>
				<td><label for="product_price">상품 가격 </label></td>
				<td align=left><input type="text" name="product_price"
					id="product_price" value="${product.product_price }" /></td>
			</tr>
			<tr>
				<td><label for="product_image">상품 이미지 </label></td>
				<td align="left"><img
					src="${pageContext.request.contextPath}/images/${product.product_image }" />
					<input type="file" name="product_image" id="product_image"
					value=${product.product_image } /></td>
			</tr>
			<tr>
				<td><label for="product_content">상품 내용 </label></td>
				<td><textarea name="product_content" id="product_content"
						rows="5" cols="50" wrap="off">${product.product_content }</textarea>
				</td>
			</tr>
			<tr>
				<td><label for="product_date">상품 등록일 </label></td>
				<td align=left><input type="date" name="product_date"
					id="product_date"
					value="${fn:substring(product.product_date,0,4) }-${fn:substring(product.product_date,5,7)}-${fn:substring(product.product_date,8,10)}" /></td>
			</tr>
			<tr>
				<td><label for="product_status">상품 상태 </label></td>
				<td><select name="product" onChange="getSelectValue(this.form);">
					<option value="N" selected="selected">신상품</option>
					<option value="O">구상품</option>
				</select>
				<select name="season" onChange="getSelectValue(this.form);">
					<option value="SP">봄</option>
					<option value="SM">여름</option>
					<option value="FA">가을</option>
					<option value="WI">겨울</option>
					<option value="NN">기본</option>
				</select>
				<select name="onoff" onChange="getSelectValue(this.form);">
					<option value="1" selected="selected">활성화</option>
					<option value="0">비활성화</option>
				</select>
				<input type="text" name="optionValue" id="product_status" value="${product.product_status }" />
				</td>
			</tr>

			<tr>
				<td colspan="2"><a href="javascript:modform.submit()">수정하기</a>&nbsp;&nbsp;
					<a href="javascript:modform.reset()">초기화</a>&nbsp;&nbsp; <a
					href="list.pro?product_code=cake">컵씨 리스트</a>&nbsp;&nbsp; <a
					href="list.pro?product_code=drink">음료씨 리스트</a></td>
			</tr>
		</table>
	</form>
</body>
</html>