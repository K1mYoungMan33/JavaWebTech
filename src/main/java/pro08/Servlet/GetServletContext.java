package pro08.Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

//  pro8/GetServletContext
@WebServlet(name = "1GetServletContext", value = "/pro08/GetServletContext")
public class GetServletContext extends HttpServlet {


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

        List member = (List) context.getAttribute( "member" );
        String name = (String) member.get(0);
        Integer age = (int) member.get(1);
        String address = (String) member.get(2);

//        RequestDispatcher dispatcher = req.getRequestDispatcher( "index2.jsp" );
//        dispatcher.forward( req, resp );
//        String out = null + "";
        out.println( "<html><body>" );
        out.println(  name + "<br>" );
        out.println( age + "<br>" );
        out.println(  address + "<br>" );


        String serverInfo = context.getServerInfo();
        String serverConnectName = context.getServletContextName();
        Enumeration<String> parameters = context.getInitParameterNames();
//        RequestDispatcher dispatcher = req.getRequestDispatcher( "index2.jsp" );
//        dispatcher.forward( req, resp );

        out.println( serverInfo + "<br>" );
        out.println(  serverConnectName + "<br>" );

        String aaa = context.getInitParameter( "menu_member" );
        out.println(  aaa + "<br>" );


//        for ( String str : parameters )
        String strParams = "";
        while ( parameters.hasMoreElements() )
        {
            String pname = parameters.nextElement();
            String value = context.getInitParameter( pname );
            strParams += String.format( "name=%s value=%s%s", pname, value, "<br>" );
        }
        out.println( "Params : <br>" + strParams );

        String fileName = "lr-branches-2.png";
        String imagePath = context.getRealPath( "/WEB-INF/images/" + fileName );
        out.println(  imagePath + "<br>" );

        File imageFile = new File( imagePath );
        out.println( imageFile.toString() +  imageFile.exists() + "<br>" );





        out.println( "</body></html>" );

    }

    //doHead
    //doPost
    //doDelete
    //doTrace
    public void destroy() {
        System.out.println("destroy 호출 " + this);
    }
}
