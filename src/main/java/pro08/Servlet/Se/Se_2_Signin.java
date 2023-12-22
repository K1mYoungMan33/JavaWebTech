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
@WebServlet(name = "Se_2_signin", value = "/pro08/Se/SeLogin")
public class Se_2_Signin extends HttpServlet {


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

        String userid = req.getParameter("userid");
        String password = req.getParameter("password");

        class UserIn {
            String getUserid() {
                return "test";
            }

            String getName() {
                return "홍기홍기";
            }
        }
        UserIn user = new UserIn();


        String s_user = "new";
//        if ( userid.equals(user.getUserid() ) && password.equals(user.getPassword())) {
//        if (session.isNew()) {
        if (null == session.getAttribute("userid")) {
            // 서버를 재시작해야 isNew가 true가 된다   ?
            // 개발환경에서는 뭔가 꼬여서 다른 방식을 이용


            session.setAttribute("userid", user.getUserid());
            session.setAttribute("username", user.getName());
        } else {
            s_user = (String) session.getAttribute("userid");
        }
//            resp.sendRedirect( "ok");

//        else {
//            resp.sendRedirect( "re-sign" );

        System.out.println("String s_user" + session.isNew() + s_user);

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
