<%@ page import="pro07.DTO.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>Pro7</title>
</head>
<body>


<h1><a href="/pro07/board">게시판 목록보기</a></h1>

<table border="1">
<%
    List<User> userList = (List<User>)request.getAttribute("UserList");
    for( User user : userList ){
%>
    <tr><td><%= user.getUid()%></td>
        <td><a href="MemberUserEdit?userid=<%= user.getUserid()%>"><%=user.getUserid()%></a></td>
        <td><%= user.getUsername()%></td>
        <td><a href="MemberUserDelete?uid=<%= user.getUid()%>">삭제</a></td></tr>
<%
    }
%>
</table>


</body>
</html>