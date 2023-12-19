package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login-post-script")
public class LoginPostScriptServlet extends HttpServlet {


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
        resp.setContentType( "text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        String user_id = req.getParameter( "user_id" );
        String user_pw = req.getParameter( "user_pw" );
        String user_address = req.getParameter( "user_address" );
        System.out.println( "아이디" + user_id + " 암호" + user_pw );

        String db_user_id = "user";
        String db_user_pw = "1234";

        String data = "<html>";
        data += "<head><title>LoginPostValuesServlet</title></head>";
        data += "<body>";
        if ( ( user_id == null ) || ( user_id.isEmpty() ) ) {
//            data += "<a href=''>로그인</a>";
            resp.sendRedirect( "/loginPostScript.jsp" );
        }

        if ( ( user_id.equals( "admin"  ) || db_user_id.equals( user_id ) ) && db_user_pw.equals( user_pw ) ){
            if ( user_id.equals( "admin"  ) )
                resp.sendRedirect( "/admin.jsp" );
            data += "<h1>로그인 성공</h1>";
            data += "아이디: " + user_id + "<br>";
            data += "비번: " + user_pw + "<br>";
            data += "주소: " + user_address + "<br>";
        }
        else{
//            data += "<a href='/loginPostScript.jsp'>로그인</a>";
            resp.sendRedirect( "/loginPostScript.jsp" );
        }

        data += "</body>";
        data += "</html>";

        out.print(data);
    }




    //doHead
    //doPost
    //doDelete
    //doTrace
    public void destroy() {
        System.out.println( "destroy 호출 ");

    }
}
