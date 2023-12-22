package pro08.Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

//  pro08.Servlet/GetCookieServlet
@WebServlet(name = "SessionTestServlet", value = "/pro08/SessionTestServlet")
public class SessionTestServlet extends HttpServlet {


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

        System.out.println( "session");
        System.out.println( session );

        System.out.println( "getId:" + session.getId() );
        System.out.println( "getCreationTime:" + new Date(session.getCreationTime() ) );
        System.out.println( "getLastAccessedTime:" + new Date(session.getLastAccessedTime() ) );
        System.out.println( "getMaxInactiveInterval:" + session.getMaxInactiveInterval() );
        session.setMaxInactiveInterval( 2000 );
        System.out.println( "getMaxInactiveInterval:" + session.getMaxInactiveInterval() );
        System.out.println( "isNew:" + session.isNew() );



        session.invalidate(); // 세션을 지운다
        // 이 구문으로도 세션이 파기되지 않는다면
        // context.xml 에 다음을 추가
        // <Manager pathname="SESSIONS.ser"/>
        // <Manager pathname="/"/>


        RequestDispatcher dispatcher = req.getRequestDispatcher( "GetCookie.jsp" );
        dispatcher.include( req, resp );



    }

    //doHead
    //doPost
    //doDelete
    //doTrace
    public void destroy() {
        System.out.println("destroy 호출 " + this);
    }
}
