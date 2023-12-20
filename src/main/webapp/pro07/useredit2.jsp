<jsp:userBean id="User" scope="request" type="DTO.User"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>Pro7</title>
</head>
<body>
<% User user =(User) request.getAttribute("User"); %>
<form action="/pro07/MemberUserEdit" method="post">
    <input type="text" name="userid" value="${User.userid}">
    <input type="text" name="username" value="${User.username}">
    <input type="submit" vlaue="수정">
    <input type="reset" vlaue="리셋">
</form>



</body>
</html>