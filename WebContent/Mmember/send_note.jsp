<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
form {
	width: auto;
	height: auto;
	margin-right: 1.5625%;
	margin-bottom: 20px;
	margin-top: 20px;
	padding: 3%;
	border: 1px dotted #333;
	border-radius: 10px;
}

table:first-child {
	margin-left: 2.083%
}

table h2 {
	padding-left: 30px;
}

tr {
	margin: 10px;
	height: 50px;
}

#sub {
	background-color: lightgray;
	width: 100px;
	text-align: center;
}

body {
	font-family: 'Malgun Gothic';
	font-size: 9pt;
}

#bottom {
	border: none;
	clear: both;
	text-align: center;
}

a {
	text-decoration: none;
}

#subtable {
	padding: 0px;
	margin: 0px;;
}

#subtable td {
	background-color: white;
}

img {
	width: 40px;
	height: 40px;
}

#commandCell {
	text-align: center;
}
</style>
</head>

<body>
	<form id="rating_mod" method="post" action="${pageContext.request.contextPath }/sendNote.mem?send_id=${param.send_id}">
		<h2>쪽지 보내기</h2>
		<jsp:useBean id="now" class="java.util.Date" />
		<fmt:formatDate value='${now}' pattern='yyyy-MM-dd' var="today" />
		<input type="hidden" name="send_date" id="send_date" value="${today }" />
		<table>
			<tr>
				<td id="sub">보내는 사람</td>
				<td colspan="3"><input type="text" name="send_id" id="send_id" value="${param.send_id }"/></td>
			</tr>
			<tr>
				<td id="sub">받는 사람</td>
				<td colspan="3"><input type="text" name="recv_id" id="recv_id" /></td>
			</tr>
			<tr>
				<td id="sub">내용</td>
				<td colspan="3"><textarea id="note_content" name="note_content"
						cols="40" rows="15"></textarea></td>
			</tr>
		</table>
		<section id="commandCell">
			<input type="submit" value="보내기" />&nbsp;&nbsp; <input type="reset"
				value="다시작성" /> <input type="button" value="취소"
				onClick="window.close()" />
		</section>
	</form>
</body>
</html>