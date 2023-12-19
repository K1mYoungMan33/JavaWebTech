package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginB")
public class BBB extends HttpServlet {


    public void init() {
        System.out.println( "init 호출 " + this);

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println( "doGet" + this );
        req.setCharacterEncoding( "utf-8" );
        resp.setContentType( "text/html;charset=utf-8");
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println( "doPost" + this );
        req.setCharacterEncoding( "utf-8" );
        resp.setContentType( "text/html;charset=utf-8");
    }




    //doHead
    //doPost
    //doDelete
    //doTrace
    public void destroy() {
        System.out.println( "destroy 호출 " + this);
    }
}
