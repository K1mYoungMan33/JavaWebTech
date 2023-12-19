package pro07.Controller;

import pro07.DTO.User;
import pro07.Service.UserService;
import pro07.Service.UserServiceImpl;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//  pro07.Controller/MemberSignIn
@WebServlet(name = "MemberSignIn", value = "/pro07/sign-in")
public class MemberSignIn extends HttpServlet {
    UserService userService = new UserServiceImpl();

    public MemberSignIn() throws NamingException {
    }

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

        String userid = req.getParameter( "userid" );
        String user_pw = req.getParameter( "password" );

        User user = userService.select( userid );

        if ( user.getUserid().isEmpty() ) {
            resp.sendRedirect( "/pro07/sign-in.jsp" );
            return;
        }

//        System.out.println( "" + !userid.equals( user.getUserid() ) + !user_pw.equals( user.getPassword() ) );
        if( !userid.equals( user.getUserid() ) || !user_pw.equals( user.getPassword() ) ) {
            resp.sendRedirect( "/pro07/sign-in.jsp" );
            return;
        }
        else {
            resp.sendRedirect( "/pro07/index.jsp" );
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
