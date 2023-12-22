<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div id="wrapper">

         <!-- Begin Header -->
         <div id="header">
		 /includes/Header.jsp<br/>
		     상단 메뉴	<br/><br/>
<a href="<%= request.getContextPath() %>/join-us.jsp">01회원가입</a>
<a href="<%= request.getContextPath() %>/user_list.jsp">02회원리스트</a>
<a href="<%= request.getContextPath() %>/board">03게시판목록</a>




<%
    String userid = (String) session.getAttribute("userid");
    String username = (String) session.getAttribute("username");
    if(userid !=null)
    {
%>
    <%=userid %>(<%=username %>)님 반갑습니다. <a href="SeLogout">로그아웃</a>
<%
    } else{
%>
    <a href="Se_1_login.jsp">로그인</a>
<%
    }
%>





<a href="<%= request.getContextPath() %>/user_list.jsp">02회원리스트</a>

<a href="#">03상품등록</a>
<a href="#">04상품리스트</a><br/>

<form action="<%=request.getContextPath()%>/login/login_pro.jsp" method="post">
아이디 : <input type = "text" name = "id">
비 번 : <input type = "text" name = "pw">
<input type ="submit" value = "로그인">
</form>


		 </div>