<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title<Title</title>
</head>
<body>
<form action="/login" name="frmLogin" method="get" enctype="UTF-8">
아이디: <input type="text" name="user_id"><br>
비밀번호: <input type="password" name="user_pw"><br>
<input type="submit">
</form>
<form action="/login" name="frmLogin" method="post" enctype="UTF-8">
아이디: <input type="text" name="user_id"><br>
비밀번호: <input type="password" name="user_pw"><br>
<input type="submit">
</form>
</body>
</html>