package pro07.Controller;

import pro07.DTO.User;
import pro07.Service.UserService;
import pro07.Service.UserServiceImpl;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//  pro07.Controller/MemberUserlist
@WebServlet(name = "MemberUserEdit", value = "/pro07/MemberUserEdit")
public class MemberUserEdit extends HttpServlet {

UserService userService;
    public void init() {
        System.out.println("init 호출 " + this);

        try {
            userService = new UserServiceImpl();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet" + this);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String userid = req.getParameter( "userid" );

        User user = userService.select( userid );


        req.setAttribute("User",user);
        RequestDispatcher dispatcher = req.getRequestDispatcher( "useredit.jsp" );
        dispatcher.forward( req, resp );

    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost" + this);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        int uid = Integer.parseInt(req.getParameter( "uid" ));
        String userid = req.getParameter( "userid" );
        String username = req.getParameter( "username" );

        User user = new User();
        user.setUid(uid);
        user.setUserid(userid);
        user.setUsername(username);

        int result = userService.update(user);

        if ( result > 0 )
        {
            resp.sendRedirect( "index.jsp" );
        }
        else{
            req.setAttribute( "User", user );
            RequestDispatcher dispatcher = req.getRequestDispatcher( "useredit.jsp" );
            dispatcher.forward( req, resp );
        }



        
    }

    private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    //doHead
    //doPost
    //doDelete
    //doTrace
    public void destroy() {
        System.out.println("destroy 호출 " + this);
    }
}
