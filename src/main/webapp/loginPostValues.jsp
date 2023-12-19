<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title<Title</title>
</head>
<body>

<form name="frmLogin" method="get" action="input">
   아이디  :<input type="text" name="user_id"><br>
   비밀번호:<input type="password" name="user_pw"><br>
   <input type="checkbox" name="subject" value="java" checked >자바
   <input type="checkbox" name="subject" value="C언어">C언어
   <input type="checkbox" name="subject" value="JSP">JSP
   <input type="checkbox" name="subject" value="안드로이드">안드로이드
   <br><br>
   <input type="submit" value="전송">
<input type="button" value="로그인" onclick="fn_validate()">
   <input type="reset" value="초기화">
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
                    frmLogin.action = "/login-post-values";
                    frmLogin.submit();
                 }
            }
        </script>

</body>
</html>