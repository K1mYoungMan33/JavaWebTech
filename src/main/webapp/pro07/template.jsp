<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
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


 <jsp:include page="${contentPage}"></jsp:include>


<%@ include file="views/includes/Footer.jsp"%>



template의 말두


</body>
</html>