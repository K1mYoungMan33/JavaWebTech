package org.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "calcServlet", value = "/calc")
public class CalcServletSSm extends HttpServlet {
    private static float USD_RATE = 1124.70F;
    private static float JPY_RATE = 10.113F;
    private static float CNY_RATE = 163.30F;
    private static float GBP_RATE = 1444.35F;
    private static float EUR_RATE = 1295.97F;
    public void init() {
        System.out.println("init호출");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();
        String command = request.getParameter("command");
        String won = request.getParameter("won");
        String operator = request.getParameter("operator");

        if(command != null && command.equals("calculate"))
        {
            String result = calculate(Float.parseFloat(won), operator);
            pw.print("<html><font size=10>변환결과</font><br>");
            pw.print("<font size=10>" + result + "</font><br>");
            pw.print("<a href='/calc'>환율 계산기</a>");
            return;
        }

        pw.print("<html><title>환율 계산기</title>");
        pw.print("<font size=5>환율 계산기</font><br>");
        pw.print("<form name='frmCalc' method='get' action='/calc' />");
        pw.print("원화:<input type='text' name='won' size=10/>");
        pw.print("<select name='operator'>");
        pw.print("<option value='dollar'>달러</option>");
        pw.print("<option value='en'>엔화</option>");
        pw.print("<option value='wian'>위안</option>");
        pw.print("<option value='pound'>파운드</option>");
        pw.print("<option value='euro'>유로</option>");
        pw.print("</select>");
        pw.print("<input type='hidden' name='command' value='calculate'/>");
        pw.print("<input type='submit' value='변환' />");
        pw.print("</form>");
        pw.print("</html>");
        pw.close();

    }

    private static String calculate(float won, String operator){
        String result = null;
        switch (operator) {
            case "dollar":
                result = String.format("%.6f", won / USD_RATE);
                break;
            case "en":
                result = String.format("%.6f", won / JPY_RATE);
                break;
            case "wian":
                result = String.format("%.6f", won / CNY_RATE);
                break;
            case "pound":
                result = String.format("%.6f", won / GBP_RATE);
                break;
            case "euro":
                result = String.format("%.6f", won / EUR_RATE);
                break;
        }
        return result;

    }

    public void destroy() {
    }
}