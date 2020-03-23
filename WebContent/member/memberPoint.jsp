<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
#subtable {
	margin: auto 0;
	border: 1px solid pink;
	text-align:center;
	width: auto;
	margin: auto;
}
h1{
text-align:left;
}
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>적립금 내역</h1>
<section id="search">
	<form name="f"
		action="${pageContext.request.contextPath }/pointSearch.mem?member_id=${member.member_id}"
		method="post">
		<table id="subtable">
			<tr height="50px">
				<td id="td_top" width="190px">기간</td>
				<td width="500px">&nbsp;&nbsp;<input type="date"
					name="start_date" id="start_date" />&nbsp;~&nbsp;<input
					type="date" name="end_date" id="end_date" />&nbsp; <input
					type="submit" value="조회하기" /></td>
			</tr>
		</table>
	</form>
	</section>
	<section id="content">
		<jsp:include page='${point }'></jsp:include>
	</section>
</body>
</html>