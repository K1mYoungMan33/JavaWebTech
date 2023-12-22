package pro07.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//  pro07.Controller/Main
@WebServlet("*.do")
public class Main extends HttpServlet {


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

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();


        //어떤 페이지에서 요청이 왔는지 확인
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String command = requestURI.substring(contextPath.length());
        System.out.println("command = " + command);

        //응답 페이지
        String page = "template.jsp";
        boolean isRedirect = false;
        // isRedirect를 주고 안주고의 차이 :

        // 내용부 페이지
        String contentPage = "";

        // 메인 페이지 이동.
        if (command.equals("/pro07/aaa.do")) {
            request.setAttribute("name", "홍길동");
            //템플래이트로 이동함.

            contentPage = "useredit.jsp";
        }
        // board 페이지 이동.
        if (command.equals("/pro07/board.do")) {
            contentPage = "board";
        }
        // board 페이지 이동.
        if (command.equals("/pro07/MemberList.do")) {
            contentPage = "/pro07/MemberUserList";
        }


        request.setAttribute("contentPage", contentPage);


        //페이지 이동
        if(isRedirect) {
            response.sendRedirect(page);
            //얘는 데이터 안가져간다.
        }
        else{
            RequestDispatcher dispatcher = request.getRequestDispatcher(page);


            if ( false && command.equals("/pro07/MemberList.do")) {
                dispatcher.include(request, response);
            }
            else
            {
                dispatcher.forward(request, response);
            }
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
