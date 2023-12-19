<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title<Title</title>
</head>
<body>
<form name="frmLogin"  enctype="UTF-8">
아이디: <input type="text" name="user_id"><br>
비밀번호: <input type="password" name="user_pw"><br>
<input type="hidden" name="user_address" value="대구광역시 서구">
<input type="button" value="로그인" onclick="fn_validate()">
<input type="reset" value="다시입력">
</form>
<script>
            function fn_validate() {
                let frmLogin = document.frmLogin;
                let user_id = frmLogin.user_id.value;
                let user_pw = frmLogin.user_pw.value;
                if ( ( user_id.length == 0 || user_id == "" ) ||
                 (user_pw.length == 0 || user_pw == "")) {
                    alert( "아이디 비번 입력은 필수입니다." );
                 }else {
                    frmLogin.method = "post";
                    // frmLogin.action = "/login-post-resp";
                    frmLogin.action = "/login-post-script";
                    frmLogin.submit();
                 }
            }
        </script>

</body>
</html>