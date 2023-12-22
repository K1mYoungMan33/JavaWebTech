<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<title>팝업창</title>
<script type="text/javascript">
    function setPopUpStart(obj) {
        if (obj.checked == true) { // checkbox 가 체크가 되어 있으면
            var expireDate = new Date();
            var days = 1;
            expireDate.setDate(expireDate.getDate() + days);
            // document.cookie 에 넣기
            document.cookie = "notShowPop=" + "true" + ";path=/; expires="
                + expireDate.toGMTString();
            window.close();
        }
    }
</script>
</head>
<body>
체크하면 팝업창은 다음 기회에..
두 번째 창


<br>
<br>
<br>
<br>
<br>
<form>
    <input type=checkbox onClick="setPopUpStart(this)">오늘 하루 보지 않기
</form>

</body>
</html>
