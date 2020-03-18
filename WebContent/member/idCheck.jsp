<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String openInit = "false";
	if (request.getParameter("openInit") != null) {
		openInit = "true";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
var chkId = false;
var idcheck;
function init() {
   if (<%=(request.getParameter("openInit") != null && request.getParameter("openInit").equals("true"))?true:false%>) {
      document.getElementById("member_id").value = opener.document
            .getElementById("member_id").value;
   }
}
function ok(v) {
   opener.idcheck = v.trim();
   opener.document.getElementById("member_id").value = v;
   opener.chkId = true;
   window.close();
}

</script>
<body onload="init()">
   <form action="${pageContext.request.contextPath }/idCheck.mem" method="post"
      name="ckform">
      <input type="text" name="member_id" id="member_id"> 
      <input type="submit" value="중복확인">
   </form>
   <%
      if (request.getAttribute("passibleId") != null) {
         if ((boolean)request.getAttribute("passibleId")) {%>
            <hr>
            <h4><%=request.getAttribute("member_id") %> 는 사용 가능한 아이디 입니다.<br>
            <a href='#' onclick="ok('<%=request.getAttribute("member_id") %>')">사용하기</a></h4>
         <%} else {%>
            <h4><%=request.getAttribute("member_id") %> 는 사용 불가능한 아이디 입니다.<br>다시 검색하세요.</h4>
      <%   }
      }
   %>
</body>
</html>