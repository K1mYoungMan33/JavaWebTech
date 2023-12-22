package pro08.Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

//  pro08.Servlet/GetCookieServlet
@WebServlet(name = "GetCookieServlet", value = "/pro08/GetCookieServlet")
public class GetCookieServlet2 extends HttpServlet {


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

        Cookie[] cookies = req.getCookies();
        String popup = "1"; // 기본값

        if ( cookies != null ) {
            for ( Cookie cookie : cookies ) {
                if ( cookie.getName().equals("popup" ) ) {
                    popup = cookie.getValue();
                    break;
                }
            }
        }
        System.out.println( "popup 상태->" + popup );


        RequestDispatcher dispatcher = req.getRequestDispatcher( "popup-2.jsp" );
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
