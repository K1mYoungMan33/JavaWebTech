<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<title>Pro7</title>
</head>
<body>
<form action="/pro07/MemberUserEdit" method="post">
    <input type="text" name="userid" value="${User.userid}">
    <input type="text" name="username" value="${User.username}">
    <input type="hidden" name="uid" value="${User.uid}">
    <input type="submit" value="수정">
    <input type="reset" value="리셋">
</form>



</body>
</html>