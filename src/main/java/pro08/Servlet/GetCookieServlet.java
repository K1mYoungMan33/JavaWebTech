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
public class GetCookieServlet extends HttpServlet {


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

        Date date = new Date();
        Cookie cookie= new Cookie( "cookietest", URLEncoder.encode( "JSP페이지입니다.", "utf-8") );
        cookie.setMaxAge( 24*60*60 );
        resp.addCookie( cookie );

        out.println( "현재시간 : " + date + "<br>" );
        out.println( "현재시간을 Cookie로 저장합니다. : " + cookie.getComment() + "<br>");
        out.println( "getDomain " + cookie.getDomain() + "<br>");
        out.println( "getMaxAge " + cookie.getMaxAge()+ "<br>" );
        out.println( "getName " + cookie.getName() + "<br>");
        out.println( "getPath " + cookie.getPath()+ "<br>" );
        out.println( "getSecure " + cookie.getSecure() + "<br>");
        out.println( "getValue " + cookie.getValue() + "<br>");
        out.println( "getVersion " + cookie.getVersion()+ "<br>" );


        Cookie cookie2_id = new Cookie( "loginid", URLEncoder.encode( "test", "utf-8") );
        Cookie cookie2_pw = new Cookie( "loginpw", URLEncoder.encode( "test1234", "utf-8") );
        cookie2_id.setMaxAge( 2 );
        cookie2_pw.setMaxAge( 2 );
        resp.addCookie( cookie2_id );
        resp.addCookie( cookie2_pw );

        String[] myArr = { "홍길동", "대구광역시", "010-1111-3333"};
        String arrayAsString = String.join( ",", myArr );

        Cookie cookie3_arr = new Cookie( "loinginfo", URLEncoder.encode( arrayAsString, "utf-8") );
        cookie3_arr.setMaxAge( 2 );
        resp.addCookie( cookie3_arr );


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
