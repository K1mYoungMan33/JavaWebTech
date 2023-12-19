package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login-post-values")
public class LoginPostValuesServlet extends HttpServlet {


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
        String[] subject = req.getParameterValues( "subject" );

        String data = "<html>";
        data += "<head><title>LoginPostValuesServlet</title></head>";
        data += "<body>";
        data += "입력받은 값을 확인합니다 <br>";
        data += "아이디: " + user_id + "<br>";
        data += "비번: " + user_pw + "<br>";
        if ( null != user_address && !user_address.isEmpty() )
            data += "주소: " + user_address + "<br>";
//        data += "선택한 과목: " + subject.
        for ( String value : subject )
            data += "선택한 과목: " + value + "<br>";
        data += "</body>";
        data += "</html>";
        out.print(data);



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
