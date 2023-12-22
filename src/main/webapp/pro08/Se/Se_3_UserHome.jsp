
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>어서오시게 8번프로젝트 - 멤버로그인하는 과정들 세션을 활용해서 변경 중</h2>




<%
    String userid = (String) session.getAttribute("userid");
    String username = (String) session.getAttribute("username");
    if(userid !=null)
    {
    %>
        <h1 > 세션값(id) : <%=userid %></h1 >
        <h1 > 이름 : <%=username %></h1 >
    <%
    } else{
    %>
    <h1>세션이 없습니다.</h1>
    <%
        }
    %>

    <a href="SeLogout">로그아웃</a>

</body>
</html>