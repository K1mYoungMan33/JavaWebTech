package pro07.Controller;

import pro07.DTO.Board;
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
import java.util.List;

//  pro07.Controller/MemberList
@WebServlet(name = "MemberList", value = "/pro07/user-list")
public class MemberList extends HttpServlet {


    UserService userService = new UserServiceImpl();

    public MemberList() throws NamingException {
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

        List<User> userList =  userService.selectList();

        String data = "<html><body>";
        data += "<table border=1>";
        data += "<tr align='center' bgcolor='lightgreen'>";
        data += "    <td>번호</td>";
        data += "    <td>아이디</td>";
        data += "    <td>이름</td>";
        data += "     <td>암호</td>";
        data += "</tr>";

        for ( User user  : userList ) {
            data += "<tr><td>" + user.getUid() + "</td>";
            data += "<td>" + user.getUserid() + "</td>";
            data += "<td>" + user.getUsername() + "</td>";
            data += "<td>" + user.getPassword() + "</td></tr>";
        }

        data += "</table>";
        data += "</body></html>";



        out.println( data );


    }

    //doHead
    //doPost
    //doDelete
    //doTrace
    public void destroy() {
        System.out.println("destroy 호출 " + this);
    }
}
