<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.PageInfo"%>
<%@ page import="vo.QuestionBean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>


<%
	ArrayList<QuestionBean> articleList = (ArrayList<QuestionBean>) request.getAttribute("articleList");
	PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
	int listCount = pageInfo.getListCount();
	int nowPage = pageInfo.getPage();
	int maxPage = pageInfo.getMaxPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<style type="text/css">
#registForm {
	width: 500px;
	height: 600px;
	border: 1px solid red;
	margin: auto;
}

h2 {
	text-align: center;
}

table {
	margin: auto;
	width: 450px;
}

#tr_top {
	background: orange;
	text-align: center;
}

#pageList {
	margin: auto;
	width: 500px;
	text-align: center;
}

#emptyArea {
	margin: auto;
	width: 500px;
	text-align: center;
}
</style>
</head>
<body>
	<!-- 게시판 리스트  -->
	<section id="listForm">
		<table>
			<%
				if (articleList != null && listCount > 0) {
			%>
			<tr id="tr_top">
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>날짜</td>
				<td>조회수</td>
			</tr>
			<%
				for (int i = 0; i < articleList.size(); i++) {
			%>
			<tr>
				<td><%=articleList.get(i).getQuestion_index()%></td>
				<td>
					<%
						if (articleList.get(i).getQuestion_re_lev() != 0) {
					%> <%
 	for (int a = 0; a <= articleList.get(i).getQuestion_re_lev() * 2; a++) {
 %> &nbsp; <%
 	}
 %>▶ <%
 	} else {
 %>▶<%
 	}
 %> <a
					href="boardDetail.bo?question_index=<%=articleList.get(i).getQuestion_index()%>&page=<%=nowPage%>"><%= articleList.get(i).getQuestion_subject() %></a>
				</td>
				<td><%=articleList.get(i).getQuestion_name()%></td>
				<td><%=articleList.get(i).getQuestion_date()%></td>
				<td><%=articleList.get(i).getQuestion_readcount()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</section>
	<section id="pageList">
		<%
			if (nowPage <= 1) {
		%>
		[이전]&nbsp;
		<%
			} else {
		%>
		<a href="questionList.qu?page=<%=nowPage - 1%>&sOption=${sOption}&sValue=${sValue}">[이전]</a>&nbsp;
		<%
			}
		%>

		<%
			for (int a = startPage; a <= endPage; a++) {
					if (a == nowPage) {
		%>
		[<%=a%>]
		<%
			} else {
		%>
		<a href="questionList.qu?page=${a}&sOption=${sOption}&sValue=${sValue}">[${a}]</a>&nbsp;
		<%
			}
		%>
		<%
			}
		%>
		<%
			if (nowPage >= maxPage) {
		%>
		[다음]
		<%
			} else {
		%>
		<a href="questionList.qu?page=<%=nowPage + 1%>&sOption=${sOption}&sValue=${sValue}">[다음]</a>
		<%
			}
		%>
		
		<form action="${pageContext.request.contextPath }/questionList.qu" method="post" name="f">
            <select name="sOption">
                <option value="title">글제목</option>
                <option value="content">내용</option>
                <option value="writer">작성자</option>
            </select>
            <input type="text" name="sValue"/>&nbsp;
            <input type="submit" value="검색"/>
        </form>
        
	</section>
	<%
		} else {
	%>
	<section id="emptyArea">등록된 글이 없습니다.</section>
	<%
		}
	%>
</body>
</html>