package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

@WebServlet("/login-param")
public class LoginGetParameterServlet extends HttpServlet {


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


        ArrayList<String> nameList = new ArrayList<String>();
        String name;
        nameList.add("A");
        nameList.add("B");
        nameList.add("C");
        nameList.add("D");
        nameList.add("E");
        nameList.add("F");
        nameList.add("F");
        nameList.add("E");
        nameList.add("A");
        
        Iterator<String> it = nameList.iterator();
 
        while(it.hasNext()) {
            name = it.next();
            if ("F".equals(name)) {
                    it.remove();
            }
        }

        System.out.println( nameList );
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet( req, resp );
        System.out.println( "doPost" + this );
        req.setCharacterEncoding( "utf-8" );
        Enumeration<String> enu = req.getParameterNames();
        System.out.println( enu + " " + enu.hasMoreElements() );
        while ( enu.hasMoreElements() )
        {
            String name = enu.nextElement();
            String[] values = req.getParameterValues( name );
            for ( String value : values ) {
                System.out.printf( "name=%s value=%s", name, value );
            }

        }


        doGet( req, resp );

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
