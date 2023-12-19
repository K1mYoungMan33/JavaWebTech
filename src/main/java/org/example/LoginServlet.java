package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    public void init() {
        System.out.println( "init 호출 ");

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet( req, resp );
        System.out.println( "doGet" + this );
        req.setCharacterEncoding( "utf-8" );
        String user_id = req.getParameter( "user_id" );
        String user_pw = req.getParameter( "user_pw" );
        System.out.println( "아이디" + user_id + " 암호" + user_pw );
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet( req, resp );
        System.out.println( "doPost" + this );
        req.setCharacterEncoding( "utf-8" );
        String user_id = req.getParameter( "user_id" );
        String user_pw = req.getParameter( "user_pw" );
        System.out.println( "아이디" + user_id + " 암호" + user_pw );
    }




    //doHead
    //doPost
    //doDelete
    //doTrace
    public void destroy() {
        System.out.println( "destroy 호출 ");

    }
}
