package pro07;

import pro07.DTO.Board;
import pro07.Service.BoardService;
import pro07.Service.BoardServiceImpl;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BoardServlet", value = "/pro07/board")
public class BoardServlet extends HttpServlet {
    BoardService boardService = new BoardServiceImpl();

    public BoardServlet() throws NamingException {
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
        resp.setContentType( "text/html" );
        List<Board> boardList = new ArrayList<>();
        boardList = boardService.list();


        String data = "<html><body>";
        data += "<table border=1>";
        data += "<tr align='center' bgcolor='lightgreen'>";
        data += "    <td>번호</td>";
        data += "    <td>제목</td>";
        data += "     <td>작성자</td>";
        data += "    <td>작성일자</td>";
        data += "    <td>수정일자</td>";
        data += "</tr>";

        for ( Board board : boardList ) {
            data += "<tr><td>" + board.getBoard_no() + "</td>";
            data += "<td><a href='/pro07/BoardRead?index=" + board.getBoard_no() + "'>" + board.getTitle() + "</a></td>";
            data += "<td>" + board.getWriter() + "</td>";
            data += "<td>" + board.getReg_date() + "</td>";
            data += "<td>" + board.getUpd_date() + "</td></tr>";
        }

        data += "</table>";
        data += "</body></html>";



        PrintWriter out = resp.getWriter();
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
