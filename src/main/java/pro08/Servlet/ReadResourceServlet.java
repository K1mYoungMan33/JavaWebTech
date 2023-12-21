package pro08.Servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

//  pro8.Servlet/ReadResourceServlet
@WebServlet(name = "2ReadResourceServlet", value = "/pro08/ReadResourceServlet")
public class ReadResourceServlet extends HttpServlet {


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
        String resourcePath = "/WEB-INF/resources/example.txt";
        InputStream inputStream = context.getResourceAsStream( resourcePath );
        if ( inputStream != null ) {
            BufferedReader reader = new BufferedReader( new InputStreamReader( inputStream ) );

            String line;
            StringBuilder sb = new StringBuilder();
            while( ( line = reader.readLine() ) != null ) {
                sb.append( line + "\n" );
            }
            reader.close();

            resp.getWriter().write( "리소스 Content: \n" );
            resp.getWriter().write( "<pre>" );
            resp.getWriter().write( sb.toString() );
            resp.getWriter().write( "</pre>" );
        }
        else {
            resp.setStatus( HttpServletResponse.SC_NOT_FOUND );
            resp.getWriter().write( "리소스를 찾을 수 없습니다." );

        }



    }

    //doHead
    //doPost
    //doDelete
    //doTrace
    public void destroy() {
        System.out.println("destroy 호출 " + this);
    }
}
