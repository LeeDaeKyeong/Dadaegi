<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
#writeForm {
	width: 500px;
	height: 610px;
	margin: auto;
}

h2 {
	text-align: center;
}

table {
	font-size: 9pt;
	margin: auto;
	width: 450px;
}

.td_left {
	width: 150px;
	background: pink;
	text-align: center;
}

.td_right {
	width: 300px;
	background: lightgray;
}

#commandCell {
	text-align: center;
}

img {
	width: 100px;
	height: 100px;
}
</style>
</head>
<body>
	<section id="writeForm">
		<h2>문의 답변 등록</h2>
		<form action="questionReply.qn" method="post" name="questionform">
			<input type="hidden" name="page" value="${page }" /> <input
				type="hidden" name="question_index"
				value="${question.question_index }"> <input type="hidden"
				name="question_re_ref" value="${question.question_re_ref }">
			<input type="hidden" name="question_re_lev"
				value="${question.question_re_lev }"> <input type="hidden"
				name="question_re_seq" value="${question.question_re_seq }">
			<input type="hidden" name="question_pass"
				value="${question.question_pass }"> <input type="hidden"
				name="product_code" value="${question.product_code }">
			<table>
				<tr>
					<td class="td_left" height="30px"><label for="question_name">작성자</label></td>
					<td class="td_right"><input type="hidden" name="question_name"
						id="question_name" value="${question.question_name }" />${question.question_name }</td>
				</tr>
				<tr>
					<td class="td_left" height="30px"><label for="member_id">아이디</label></td>
					<td class="td_right"><input type="hidden" name="member_id"
						id="member_id" value="${question.member_id }" />${question.member_id }</td>
				</tr>
				<tr>
					<td class="td_left" height="30px"><label for="question_subject">문의제목</label></td>
					<td class="td_right"><input type="hidden"
						name="question_subject" id="question_subject"
						value="${question.question_subject }" />${question.question_subject }</td>
				</tr>
				<tr>
					<td class="td_left" height="30px"><label for="product_name">상품명</label></td>
					<td class="td_right"><input type="hidden" name="product_name"
						id="product_name" value="${question.product_name }" />${question.product_name }</td>
				<tr>
					<td class="td_left"><label for="question_file">리뷰사진</label></td>
					<td class="td_right"><img
						src="${pageContext.request.contextPath}/images/${question.question_file}" /></td>
				</tr>
				<tr>
					<td class="td_left" height="30px"><label for="question_date">작성날짜</label></td>
					<td class="td_right"><input type="hidden" name="question_date"
						id="question_date" value="${question.question_date }" />${question.question_date }</td>
				</tr>
				<tr>
					<td class="td_left"><label for="question_content">문의내용</label></td>
					<td><textarea id="question_content" name="question_content"
							cols="40" rows="15">${question.question_content }</textarea></td>
				</tr>
				<tr>
					<td class="td_left"><label for="question_answer">문의답변</label></td>
					<td><textarea id="question_answer" name="question_answer"
							cols="40" rows="15"></textarea></td>
				</tr>
			</table>
			<section id="commandCell">
				<input type="submit" value="답변글등록" />&nbsp;&nbsp; <input
					type="reset" value="다시작성" />
			</section>
		</form>
	</section>
</body>
</html>