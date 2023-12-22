<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>


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
    <script type="text/javascript">
    location.href="Se_1_login.jsp";
    </script>
<%
        }
%>

    <a href="SeLogout">로그아웃</a>
