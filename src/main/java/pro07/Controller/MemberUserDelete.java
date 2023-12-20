package pro07.Controller;

import pro07.DTO.User;
import pro07.Service.UserService;
import pro07.Service.UserServiceImpl;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//  pro07.Controller/MemberUserlist
@WebServlet(name = "MemberUserDelete", value = "/pro07/MemberUserDelete")
public class MemberUserDelete extends HttpServlet {

UserService userService;
    public void init() {
        System.out.println("init 호출 " + this);


    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet" + this);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");


        try {
            userService = new UserServiceImpl();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        int uid = Integer.parseInt( req.getParameter( "uid" ));
        int result = userService.delete( uid );

        if ( result > 0 ) {
            resp.sendRedirect( "MemberUserList" );
        }
        else {
            req.setAttribute( "Message", "사용자 삭제에 문제가 발생했습니다." );

            RequestDispatcher dispatcher = req.getRequestDispatcher( "Error.jsp" );
            dispatcher.forward( req, resp );

        }



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

        List<User> userList = userService.selectList();

        req.setAttribute("UserList",userList);
        RequestDispatcher dispatcher = req.getRequestDispatcher( "userlist.jsp" );
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
