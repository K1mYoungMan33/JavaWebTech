<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<title>팝업 제한 메인</title>
<script type="text/javascript">
    window.onload = pageLoad;
    function pageLoad() {
        notShowPop = getCookieValue(); // 쿠키 정보를 가져옴
        if (notShowPop != "true") { // 팝업제한이 true 이면 팝업을 띄우지 않고 아니면 팝업을 띄움
            window.open("popup.jsp",
                "pop",
                "width=600,height=400,history=no,resizable=no,status=no,scrollbars=yes,menubar=no");
        }
    }

    // 쿠키 읽어오는 함수
    function getCookieValue() {
        var result = "false";
        // 쿠키 여부 확인
        if (document.cookie != "") {
            let cookies = document.cookie.split( /[;=] */ );
            result = cookies[ cookies.indexOf( "notShowPop" ) + 1];


/*
            cookie = document.cookie.split(";");
            for (var i = 0; i < cookie.length; i++) {
                element = cookie[i].split("=");
                value = element[0];
                value = value.replace(/^\s* /, ''); // 정규표현식 공백 제거
                if (value == "notShowPop") { // key 가 일치하면
                    result = element[1]; // 값을 result 에 할당해서 반환
                }
            }
*/
        }
        return result;
    }
    // 쿠키 삭제 함수
    function deleteCookie() {
        document.cookie = "notShowPop=" + "false" + ";path=/; expires=-1";
    }
</script>
</head>
<body>
<form>
    쿠키를 삭제하려면 아래 버튼을 클릭하세요.<br>
    <input type=button value="쿠키삭제" onClick="deleteCookie()">
</form>
</body>
</html>