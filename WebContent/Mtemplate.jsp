<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#table_tm {
   margin: auto;
   width: 70%;
}
#left_menu{
	float:left;
}
#content{
	float : left;
}
</style>
</head>
<body>
   <table border=0 id="table_tm">
      <tr id="left_menu">
         <td><br> 
         <jsp:include page="menu_left.jsp"></jsp:include>
         </td>
      </tr>
      <tr id="content">
         <td>
         <jsp:include page='${pagefile }'></jsp:include>
         </td>
      </tr>
   </table>
</body>
</html>