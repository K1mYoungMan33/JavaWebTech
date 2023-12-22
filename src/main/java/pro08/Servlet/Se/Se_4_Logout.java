package pro08.Servlet.Se;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//  pro08.Servlet/Se_se_signin
@WebServlet(name = "Se_4_Logout", value = "/pro08/Se/SeLogout")
public class Se_4_Logout extends HttpServlet {


    public void init() {
        System.out.println("init 호출 " + this);

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet" + this);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        doHandle(req, resp);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost" + this);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        doHandle(req, resp);
    }

    private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();


        HttpSession session = req.getSession();

        if ( session.getAttribute( "userid" ) != null ) {
            session.removeAttribute( "userid" );
            session.removeAttribute( "username" );
        }
        resp.sendRedirect( "index.jsp" );



    }


    /*
    //{{ jsp에 다음을 작성
    <%
    String userid = (String) session.getAttribute("userid");
    if(userid !=null)
    {
    %>
        <h1 > 세션값(id) : <%=userid % ></h1 >
        <h1 > 이름 : <%=username % ></h1 >
    <%
    } else{
    %>
    <h1>세션이 없습니다.</h1>
    <%
        }
    %>
    //}} */

    //doHead
    //doPost
    //doDelete
    //doTrace
    public void destroy() {
        System.out.println("destroy 호출 " + this);
    }
}
