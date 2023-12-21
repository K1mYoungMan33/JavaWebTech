package pro08.Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

//  pro08.Servlet/pro08_1
//@WebServlet(name = "pro08_1", value = "/pro08/pro08_1")
@WebServlet(name = "pro08_1", urlPatterns = { "/pro08/pro08_1", "/pro08/pro08_2"},
        initParams = {@WebInitParam(name="email", value="plus4957@yi.or.kr")
                ,@WebInitParam(name="tel",value="010-1111-2222")
    }
)
public class pro08_1 extends HttpServlet {


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

        String email = getInitParameter( "email" );
        ServletContext context = getServletContext();
        context.setAttribute( "mail", email );
//        req.setAttribute( "mail", email );

        RequestDispatcher dispatcher = req.getRequestDispatcher( "pro08_1.jsp" );
        dispatcher.forward( req, resp );


        String user_address = "abc아d기_서붕";
        user_address = URLEncoder.encode( user_address, "utf-8" );
        out.println( "address:" + user_address );
    }

    //doHead
    //doPost
    //doDelete
    //doTrace
    public void destroy() {
        System.out.println("destroy 호출 " + this);
    }
}
