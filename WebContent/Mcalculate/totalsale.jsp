<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
#search {
	width: 100%;
	border: 1px pink solid;
	margin: auto;
}

#subtable {
	margin: auto 0;
	border: 1px solid pink;
	width: 1000px;
	margin: auto;
}

h2 {
	text-align: center;
	width: 100%;
}

#td_top {
	background-color: pink;
	text-align: center;
}
</style>
<body>
	<h2>매출 리스트</h2>
	<section id="search">
		<form name="f"
			action="${pageContext.request.contextPath }/totalsale.ca"
			method="post">
			<table id="subtable">
				<tr height="40px">
					<td id="td_top" width="50px">분석방법</td>
					<td width="500px">&nbsp;&nbsp;<input type="radio" name="way"
						value="결제방법" id="payment_way" />결제방법&nbsp;&nbsp; <input
						type="radio" name="way" value="년별" id="year" />년별 &nbsp;&nbsp;<input
						type="radio" name="way" value="월별" id="month" />월별&nbsp;&nbsp; <input
						type="radio" name="way" value="일별" id="day" />일별
					</td>
				</tr>
				<tr height="40px">
					<td id="td_top" width="50px">기간</td>
					<td width="500px">&nbsp;&nbsp;<input type="date"
						name="start_date" id="start_date" />&nbsp;~&nbsp;<input
						type="date" name="end_date" id="end_date" />&nbsp; <input
						type="submit" value="검색" /></td>
				</tr>
			</table>
		</form>
	</section>
	<section id="content">
		<jsp:include page='${way }'></jsp:include>
	</section>
</body>
</html>