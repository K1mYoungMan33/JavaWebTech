package pro08.Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

//  pro8/GetServletContext
@WebServlet(name = "1SetServletContext", value = "/pro08/SetServletContext")
public class SetServletContext extends HttpServlet {


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

        ServletContext context = getServletContext();

        {
            ServletContext currentContext = getServletContext();
            String otherWebAppUriPath = "/pro7";
            ServletContext otherContext = currentContext.getContext(otherWebAppUriPath );
        }

        List member = new ArrayList();
        member.add( "홍길동" );
        member.add( 40 );
        member.add( "대구광역시 서구" );

        context.setAttribute( "member", member );
        req.setAttribute( "member2", member );
        RequestDispatcher dispatcher = req.getRequestDispatcher( "index.jsp" );
        dispatcher.forward( req, resp );




    }

    //doHead
    //doPost
    //doDelete
    //doTrace
    public void destroy() {
        System.out.println("destroy 호출 " + this);
    }
}
