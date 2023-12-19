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

@WebServlet(name = "MemberJoinUs", value = "/pro07/member/join")
public class MemberJoinUs extends HttpServlet {
    UserService userService = new UserServiceImpl();

    public MemberJoinUs() throws NamingException {
    }


    public void init() {
        System.out.println("init 호출 " + this);

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet" + this);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        doHandle( req, resp );
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost" + this);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        doHandle( req, resp );
    }

    private void doHandle( HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String userid = req.getParameter( "userid" );
        String username = req.getParameter( "username" );
        String password = req.getParameter( "password" );

        User user = new User();
        user.setUserid( userid );
        user.setUsername( username );
        user.setPassword( password );

        if ( userService.insert( user ) > 0 ) {
            System.out.println( "회원정보 등록 완료");
        }
        else {
            System.out.println( "회원등록 실패" );
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
