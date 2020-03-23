<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#table_tm {
	margin-left: auto;
	margin-right: auto;
	width: 1000px;
	color: gray;
	border: 1px solid #fff;
	font-family: Georgia, "나눔고딕", serif;
}

</style>
</head>
<body bgcolor="#fff">
	<table border=0 id="table_tm">
		<tr>
			<td align="center"><br> 
			<jsp:include page="menu_top.jsp"></jsp:include>
			</td>
		</tr>
		<tr style="min-height: 100%;">
			<td align="center">
			<jsp:include page='${pagefile }'></jsp:include>
			</td>
		</tr>
		<tr>
			<td align="center">
			<jsp:include page="menu_bottom.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>