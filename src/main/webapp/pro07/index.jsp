<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>Pro7</title>
<style>
div{
border:1px solid blue;
}
#leftcolumn{
display : inline-block;

}

#rightcolumn{
display : inline-block;

}
</style>
</head>
<body>

<%@ include file="views/includes/Header.jsp"%>

<%@ include file="views/includes/Sidebar.jsp"%>

<a href="#">Download this CSS Layout</a>

<%@ include file="views/includes/Footer.jsp"%>





<h1><a href="/pro07/board">게시판 목록보기</a></h1>



<ul>
<li><a href="/login.jsp">로그인 form전송</a></li>
<li><a href="/login-getParameterNames.jsp">로그인 form전송</a></li>
<li><a href="/loginPostScript.jsp">로그인 form전송</a></li>
<li><a href="/loginPostValues.jsp">로그인 form전송</a></li>
<li><a href="/calc">환율계산기</a></li>
<li><a href="/pro07/user-update">회원정보수정</a></li>
<li><a href="/pro07/user-list">회원목록보기</a></li>
12월20일
<li><a href="/pro07/MemberUserList">회원목록보기</a></li>
</ul>




</body>
</html>